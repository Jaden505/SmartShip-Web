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
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    @Autowired
    MailService mailService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

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
    public ResponseEntity<?> registerUser( @RequestBody RegisterRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        User user = new User();

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

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(HttpServletRequest request,
                                           @RequestBody ResetPasswordRequest resetPasswordRequest) {

        User user = userRepository.findUserByEmail(resetPasswordRequest.getEmail());

        System.out.println(resetPasswordRequest.getEmail());
        if (user == null) {
            System.out.println("No user found!");
        }

        String baseUrl = request.getHeader(HttpHeaders.ORIGIN);

        System.out.println(baseUrl);

        String token = UUID.randomUUID().toString();

        LocalDate expireDate = LocalDate.now(ZoneId.systemDefault());

        userService.createPasswordResetTokenForUser(user, token, expireDate);
        mailService.constructResetTokenEmail(baseUrl, token, user);

        return ResponseEntity.ok(new MessageResponse("Email successfully sent!"));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> showChangePasswordPage(@RequestParam("token") String token, @RequestBody ChangePasswordRequest changePasswordRequest) {

        System.out.println(token);

        PasswordResetToken passwordResetToken = mailService.validatePasswordResetToken(token);

        if (passwordResetToken == null) {
            throw new UserNotFoundException("The reset password token is not valid!");
        }

        PasswordResetToken user = passwordTokenRepository.getUserByToken(passwordResetToken.getToken());

        if (user.getUser() != null) {
            userRepositoryJPA.changePassword(encoder.encode(changePasswordRequest.getNew_password()), user.getUser().getEmail());
        } else {
            throw new UserNotFoundException("The password or reset password token is not valid!");
        }

        return ResponseEntity.ok(new MessageResponse("Users password successfully changed!"));
    }

}
