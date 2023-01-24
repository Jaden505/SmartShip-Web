import {SensorData} from "@/models/sensorData";


const SENSOR_ID = "Vincent";
const GROUP_MOTOR = "Motor";

describe('sensorDataModel', () => {

// instances for testing
    let sensorData, sensorData2

    beforeEach(function () {
        sensorData = new SensorData(SENSOR_ID);
        sensorData2 = new SensorData("1");
    });

    it('creates a proper sample sensorId', function () {
        expect(sensorData.sensorId,
            'sensorId was not set properly')
            .toBe(SENSOR_ID);
    })

    it('clones a proper copy', function () {
        let copy = SensorData.copyConstructor(sensorData2)
        expect(copy,
            'copy of sensorData does not match original')
            .toStrictEqual(sensorData2);
    })

    it('constructs a proper author', function () {
        expect(sensorData.group,
            'sensorData lastName was not set properly')
            .toBeUndefined();
        sensorData.group = "Motor"
        expect(sensorData.group,
            'sensorData lastName was not set properly')
            .toBe(GROUP_MOTOR);
    })

})
