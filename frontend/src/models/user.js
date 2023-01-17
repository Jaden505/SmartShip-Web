export class User {

    id;
    address;
    city;
    country;
    dateOfBirth;
    firstname;
    gender;
    lastname;
    nationality;
    phoneNumber;
    postalCode;
    username;
    email;
    password;
    role;
    shipID;

    constructor(id, address, city, country, dateOfBirth, firstname, gender, lastname, nationality, phoneNumber, postalCode, username, email, password, role, shipID) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.shipID = shipID;
    }

    static copyConstructor(user) {
        if (user == null) return null;
        return Object.assign(new User(), user);
    }

    static createSample(id) {
        let user = new User();
        user.id = id;
        user.address = "Sample Address";
        user.city = "Sample City";
        user.country = "Sample Country";
        user.dateOfBirth = "Sample Date of Birth";
        user.firstname = "Sample Firstname";
        user.gender = "male";
        user.lastname = "Sample Lastname";
        user.nationality = "Sample Nationality";
        user.phoneNumber = "Sample Phone Number";
        user.postalCode =  "Sample Postal Code";
        user.username = "Sample Username";
        user.email = "Sample Email";
        user.password = "Sample Password";
        user.role = "Sample Role";
        user.shipID = 0;
        return user;
    }
}