import {Ship} from "@/models/ship";

export class SensorData {

    sensorId
    group
    sensorName
    ship
    time
    type
    value
    unit
    speed
    gpsLatitude
    gpsLongtitude


    constructor(sensorId, group, sensorName, ship, time, type, value, unit, speed, gpsLatitude, gpsLongtitude) {
        this.sensorId = sensorId;
        this.group = group;
        this.sensorName = sensorName;
        this.ship = ship;
        this.time = time;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.speed = speed;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongtitude = gpsLongtitude;
    }

    static createSample(id) {
        let sensorData = new SensorData();
        sensorData.gpsLatitude = 60.0 + id;
        sensorData.gpsLongtitude = 24.0 + id;
        sensorData.sensorId = id;
        sensorData.group =  SensorData.groups[Math.floor(Math.random() * SensorData.groups.length)];
        sensorData.sensorName = "sensorName" + id;
        sensorData.ship = Ship.createSample(id);
        sensorData.time = "time" + id;
        sensorData.type = "type" + id;
        sensorData.value = "value" + id;
        sensorData.unit = "unit" + id;
        sensorData.speed = "speed" + id;
        return sensorData;
    }

    static groups = [
        "Fuel", "Motor", "Sea Conditions", "Battery"
    ];


}