package com.server.server.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import com.server.server.exceptions.UserNotFoundException;
import com.server.server.model.PasswordResetToken;
import com.server.server.payload.request.ChangePasswordRequest;
import com.server.server.payload.request.ResetPasswordRequest;
import com.server.server.repository.*;
import com.server.server.services.MailService;
import com.server.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.server.server.model.ERole;
import com.server.server.model.Role;
import com.server.server.model.User;
import com.server.server.payload.request.RegisterRequest;
import com.server.server.payload.response.MessageResponse;
import com.server.server.payload.request.LoginRequest;
import com.server.server.payload.response.JwtResponse;
import com.server.server.security.services.UserDetailsImpl;
import com.server.server.security.jwt.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    // Declare the authentication manager as main strategy interface for authentication
    @Autowired
    AuthenticationManager authenticationManager;

    // Declare the user service
    @Autowired
    UserService userService;

    // Import PasswordTokenRepository for handling actions with password reset tokens
    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    // Declare the mail service
    @Autowired
    MailService mailService;

    // Import UserRepository for handling actions with users
    @Autowired
    UserRepository userRepository;

    // Import UserRolesRepositoryJPA for handling custom actions with user roles
    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    // Import RoleRepository for handling actions with roles
    @Autowired
    RoleRepository roleRepository;

    // Import ShipRepository for handling actions with ships
    @Autowired
    ShipRepository shipRepository;

    // Import Password Encoder for encoding passwords
    @Autowired
    PasswordEncoder encoder;

    // Import JWT Utils for generating JWT tokens
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Authenticate the user with usernmae and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Generate the JWT token
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Get the user details from the authentication
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // Get the roles of the user
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Return the JWT token and the user details
        if (userDetails.getShip() == null){
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles,
                    null));
        } else {
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles,
                    userDetails.getShip().getId()));
        }


    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Check if the email is already taken
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create a new user
        User user = new User();

        // Assign values from signup request payload to the new user
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setGender(signUpRequest.getGender());
        user.setNationality(signUpRequest.getNationality());
        user.setDateofbirth(signUpRequest.getDateOfBirth());
        user.setPhonenumber(signUpRequest.getPhoneNumber());
        user.setAddress(signUpRequest.getAddress());
        user.setPostalcode(signUpRequest.getPostalCode());
        user.setCity(signUpRequest.getCity());
        user.setCountry(signUpRequest.getCountry());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        if (Objects.equals(signUpRequest.getShipID(), "")){
            user.setShip(null);
        } else{
            user.setShip(shipRepository.findShipById(signUpRequest.getShipID()).get(0));
        }

        // Set the role of the user
        String role = signUpRequest.getRole();

        if (role == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_OPERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            user.setRole(userRole);
        } else {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    user.setRole(adminRole);

                    break;
                case "manager":
                    Role modRole = roleRepository.findByName(ERole.ROLE_MANAGER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    user.setRole(modRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_OPERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    user.setRole(userRole);
            }
        }

        // Save the user in the database
        userRepository.save(user);

        // Return message with successful message
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(HttpServletRequest request,
                                           @RequestBody ResetPasswordRequest resetPasswordRequest) {

        // Find the user in the database by his email
        User user = userRepository.findUserByEmail(resetPasswordRequest.getEmail());

        // Throw an exception if user not found
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        String baseUrl = request.getHeader(HttpHeaders.ORIGIN);

        System.out.println(baseUrl);

        String token = UUID.randomUUID().toString();

        LocalDate expireDate = LocalDate.now(ZoneId.systemDefault());

        // Create a password reset token with the given data
        userService.createPasswordResetTokenForUser(user, token, expireDate);
        // Create email and send it
        mailService.constructResetTokenEmail(baseUrl, token, user);

        // Return a successful message as response
        return ResponseEntity.ok(new MessageResponse("Email successfully sent!"));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> showChangePasswordPage(@RequestParam("token") String token, @RequestBody ChangePasswordRequest changePasswordRequest) {

        // Validate the given token
        PasswordResetToken passwordResetToken = mailService.validatePasswordResetToken(token);

        // If not correct, throw an exception
        if (passwordResetToken == null) {
            throw new UserNotFoundException("The reset password token is not valid!");
        }

        // Get user assigned to the token
        PasswordResetToken user = passwordTokenRepository.getUserByToken(passwordResetToken.getToken());

        // If user found, change his password using encoder and new password
        if (user.getUser() != null) {
            userRepositoryJPA.changePassword(encoder.encode(changePasswordRequest.getNew_password()), user.getUser().getEmail());
        } else {
            throw new UserNotFoundException("The password or reset password token is not valid!");
        }

        // Return message as response
        return ResponseEntity.ok(new MessageResponse("Users password successfully changed!"));
    }

}
