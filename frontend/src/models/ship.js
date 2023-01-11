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

}