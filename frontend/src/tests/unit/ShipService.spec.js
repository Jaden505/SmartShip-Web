import {InMemoryEntitiesService} from "@/tests/EntityInstanceMemory";
import {Ship} from "@/models/ship";


describe('ShipService tests', () => {

    let shipService;

    // Create a new instance of the service before each test
    beforeEach(() => {
        shipService = new InMemoryEntitiesService(Ship.createSample)
    })

    it('should get all ships', async () => {
        let shipData;

        // Get all ships
        shipData = await shipService.findAll();

        console.log(shipData);

        // Assert - check that we got the correct number of ships and the correct data
        expect(shipData.length).toEqual(13);
        expect(shipData[0]).toEqual({"gpsLatitude": 50, "gpsLongtitude": 30, "id": 0, "name": "Ship0", "status": "ACTIVE", "tank1": 0, "tank2": 0});
    });

    it('should get ship by id', async () => {

        // Act - get all sensor data for a specific ship
        let shipById = await shipService.findById(1);
        let shipData = await shipService.findAll();

        // Assert - check that we got the correct ship
        expect(shipData).toContain(shipById);
    });
})
