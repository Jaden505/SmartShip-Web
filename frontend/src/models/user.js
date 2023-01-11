export class User {

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

    constructor(address, city, country, dateOfBirth, firstname, gender, lastname, nationality, phoneNumber, postalCode, username, email, password, role, shipID = null) {
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

}