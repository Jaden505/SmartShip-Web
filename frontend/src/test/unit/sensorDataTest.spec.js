import {InMemoryEntitiesService} from "@/test/unit/inMemoryEntity";
import {SensorData} from "@/models/sensorData";

describe('SensorDataService', () => {

    let sensorService;

    beforeEach(function (){
        sensorService = new InMemoryEntitiesService(SensorData.createSample);
    })

    it('constructs a proper authors-service and books-service', function() {
        expect(sensorService.entities.length,
            'sensorService was not set up properly')
            .toBeGreaterThan(0);
    })

    it('findAll returns all', function() {
        let books = sensorService.findAll();
        expect(books,
            'sensorService.findAll does not return all books')
            .toStrictEqual(sensorService.entities);
    })

    it('findById returns the specified sensor', function() {
        const sensor = sensorService.entities[0];

        expect(sensorService.findById(sensor.sensorId),
            `sensorService.findById cannot find book-${sensor.sensorId}`)
            .toStrictEqual(sensor);
    })


    it('deleteById deletes the specified sensor', function() {
        const sensorData = sensorService.entities[0];

        sensorService.deleteById(sensorData.id);

        expect(sensorService.findById(sensorData.id),
            `sensorService.deleteById did not delete sensor-${sensorData.id}`)
            .toBeUndefined();
    })
});
