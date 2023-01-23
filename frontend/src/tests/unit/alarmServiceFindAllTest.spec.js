import {InMemoryEntitiesService} from "@/services/in-memory-entities-service";
import {Alarm} from "@/models/alarm";
//Arrage
let alarmService;
let alarms;
beforeEach(() => {
    //Act
    alarmService = new InMemoryEntitiesService(Alarm.createSample);
    alarms = alarmService.findAll();
})
describe('AlarmServiceTest', () => {
    it('Should get all alarms',() => {
        //Assert
        expect(alarms.length).toEqual(alarmService.findAll().length);
    })
})

