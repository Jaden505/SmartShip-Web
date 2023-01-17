import {AlarmService} from "@/services/alarm.service";
import {Alarm} from "@/models/alarm";


const alarmService = new AlarmService();
describe('AlarmService', () => {
    it('getAll', async () => {
        //Arrange
        let alarms;
        //Act
        alarms = await alarmService.getAll().then((response) => {
            return response.data;
        })
        //Assert
        expect(alarms).toBeInstanceOf(Array);
    });

    it('postNotification', async () => {
        //Arrange
        let alarm = new Alarm("parameter", "category", 1, 3001, new Date(), "message", "unit");
        //Arrange
        let lengthBeforeDelete;
        let lengthAfterDelete;

        //Act
        lengthBeforeDelete = await alarmService.getAll().then((response) => {
            return (response.data).length;
        })
            console.log("There are/is " + lengthBeforeDelete + " notification(s)");

            await alarmService.postNotification(alarm)
            lengthAfterDelete = await alarmService.getAll().then((response) => {
                return (response.data).length;
            })
            //Assert
            expect(lengthAfterDelete).toBe(lengthBeforeDelete + 1);
            expect(lengthAfterDelete).toBeGreaterThan(lengthBeforeDelete);

    })

    // it('delete', async () => {
    //     //Arrange
    //     let firstData;
    //     let lengthBeforeDelete;
    //     let lengthAfterDelete;
    //
    //     //Act
    //     lengthBeforeDelete = await notificationService.getAll().then((response) => {
    //         return (response.data).length;
    //     })
    //
    //     if (lengthBeforeDelete > 0) {
    //         firstData = await notificationService.getAll().then((response) => {
    //             return ((response.data)[0]).id;
    //         })
    //
    //         console.log("There are/is " + lengthBeforeDelete + " notification(s)");
    //
    //         await notificationService.delete(firstData)
    //         lengthAfterDelete = await notificationService.getAll().then((response) => {
    //             return (response.data).length;
    //         })
    //         //Assert
    //         expect(lengthAfterDelete).toBe(lengthBeforeDelete - 1);
    //         expect(lengthBeforeDelete).toBeGreaterThan(lengthAfterDelete);
    //     }
    //     else{
    //         //Assert
    //         console.log("There are no notifications");
    //         expect(lengthBeforeDelete).toBe(0);
    //     }
    // });
});
