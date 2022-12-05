export default class User {
    constructor(name, email, password, shipID, roleID) {
        this.username = name;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.shipID = shipID;
    }
}