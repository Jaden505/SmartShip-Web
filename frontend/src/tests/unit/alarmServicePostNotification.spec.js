import {Alarm} from "@/models/alarm";
import {InMemoryEntitiesService} from "@/services/in-memory-entities-service";

//Arrage
let alarmService;
let alarms;
beforeEach(() => {
    //Act
    alarmService = new InMemoryEntitiesService(Alarm.createSample);
    alarms = alarmService.findAll();
})
it('should post one notification to the existing list',() => {
    //Arrange
    let lengthBeforePost = alarms.length;
    console.log("The amount of alarms is: "+alarms.length)
    let alarm = new Alarm("Windy","Wind Speed",112,
        "07202515-a483-464c-b704-5671f104044b",new Date(),
        "This is a message", "m/s");
    //Act
    alarmService.post(alarm);
    //Assert
    expect(alarms.length).toEqual(lengthBeforePost + 1);
    console.log("The amount of alarms is now: "+alarms.length)

})
