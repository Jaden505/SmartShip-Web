import {InMemoryEntitiesService} from "@/tests/in-memory-entities-service";
import {SensorData} from "@/models/sensor_data";


describe('SensorData Service', () => {

    let sensorDataService;

    // Create a new instance of the service before each test
    beforeEach(() => {
        sensorDataService = new InMemoryEntitiesService(SensorData.createSample)
    })

    it('should get all sensor data', async () => {
        // Arrange
        let allSensorData;

        // Act - get all sensor data
        allSensorData = await sensorDataService.findAll();

        // Assert - check that we got the correct number of sensor data and the correct data
        expect(allSensorData.length).toEqual(7);
        expect(allSensorData[0].ship).toEqual({"gpsLatitude": 60, "gpsLongtitude": 24, "id": 0, "name": "Ship0", "status": "ACTIVE", "tank1": 1000, "tank2": 2000});
        expect(allSensorData[5].sensorName).toEqual("sensorName5");

    });

    it('should get sensor data by ship id', async () => {
        // Arrange
        let allSensorData;
        let sensorDataByShipId;

        // Act - get all sensor data for a specific ship
        sensorDataByShipId = await sensorDataService.findById(1, true);
        allSensorData = await sensorDataService.findAll();

        // Assert - check that we got the correct data
        expect(allSensorData).toContain(sensorDataByShipId);
        expect(sensorDataByShipId.sensorName).toEqual("sensorName1");

    });

    it('should return sensor data for a specific group', async () => {
        // Arrange
        let allSensorData;
        let sensorDataByGroup;
        let sensorDataByGroup2;

        // Act - get all sensor data for a specific group
        sensorDataByGroup = await sensorDataService.findByGroup("Fuel");
        sensorDataByGroup2 = await sensorDataService.findByGroup("Battery");
        allSensorData = await sensorDataService.findAll();

        // Assert - check that we got the correct data
        expect(allSensorData).toContain(sensorDataByGroup);
        expect(allSensorData).toContain(sensorDataByGroup2);

    });
})
