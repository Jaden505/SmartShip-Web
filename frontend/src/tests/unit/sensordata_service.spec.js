import sensordataService from "@/services/sensordata.service";
import axios from "axios";

describe('SensorData Service', () => {

    const sensorData = {
        "sensorId": "05VJZSGKERRMYXONKZIY",
        "group": "Motor",
        "sensorName": "Engine 1 Temperature",
        "ship": {
        id: "07202515-a483-464c-b704-5671f104044b",
            name: "Serendipity",
            status: {
            id: 1,
                status: "ACTIVE"
        },
        gpsLatitude: "-58.04300",
            gpsLongtitude: "-81.54812",
            tank1: 1200,
            tank2: 1300
    },
        time: "13:25:10 15/07/2022",
        type: "Temperature",
        value: "67.02",
        unit: "Celcius",
        speed: "12.9",
        gpsLatitude: "N52°3'53.754",
        gpsLongtitude: "E3°40'54.03299999999982"
    }


    it('should get all sensor data', function () {
        jest.spyOn(axios, 'get').mockResolvedValue({

        })


    });


})
