export const status = [
    {id: 1, status: "ACTIVE"},
    {id: 2, status: "IDLE"},
    {id: 3, status: "MAINTENANCE"},
]

export class Ship {
    id;
    name;
    status;
    gpsLatitude;
    gpsLongtitude;
    tank1;
    tank2;


    constructor(id, name, status, gpsLatitude, gpsLongtitude, tank1, tank2) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongtitude = gpsLongtitude;
        this.tank1 = tank1;
        this.tank2 = tank2;
    }

    static copyConstructor(ship) {
        if (ship == null) return null;
        return Object.assign(new Ship(), ship);
    }

    static createSample(id) {
        let ship = new Ship();
        ship.id = id;
        ship.name = "Ship" + id;
        ship.status = "ACTIVE";
        ship.gpsLatitude = 50 + id;
        ship.gpsLongtitude = 30 + id;
        ship.tank1 = id;
        ship.tank2 = id * 2;
        return ship;
    }
}