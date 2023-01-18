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

    it('should post one notification to the existing list',() => {
        //Arrange
        let lengthBeforePost = alarms.length;
        console.log("The amount of alarms is: "+alarms.length)
        let alarm = new Alarm("Windy","Wind Speed",112,3001,new Date(),
            "This is a message", "m/s");
        //Act
        alarmService.post(alarm);
        //Assert
        expect(alarms.length).toEqual(lengthBeforePost + 1);
        console.log("The amount of alarms is now: "+alarms.length)

    })
})

