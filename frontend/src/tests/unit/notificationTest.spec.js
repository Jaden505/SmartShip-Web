const NotificationService = require('../../services/notification.service');


let notificationService = new NotificationService();
describe('NotificationService', () => {
    it('getAll', async () => {
        //Arrange
        let notifications;
        //Act
        notifications = await notificationService.getAll().then((response) => {
            return response.data;
        })
        //Assert
        expect(notifications).toBeInstanceOf(Array);
    });

    it('delete', async () => {
        //Arrange
        let firstData;
        let lengthBeforeDelete;
        let lengthAfterDelete;

        //Act
        lengthBeforeDelete = await notificationService.getAll().then((response) => {
            return (response.data).length;
        })

        if (lengthBeforeDelete > 0) {
            firstData = await notificationService.getAll().then((response) => {
                return ((response.data)[0]).id;
            })

            console.log("There are/is " + lengthBeforeDelete + " notification(s)");

            await notificationService.delete(firstData)
            lengthAfterDelete = await notificationService.getAll().then((response) => {
                return (response.data).length;
            })
            //Assert
            expect(lengthAfterDelete).toBe(lengthBeforeDelete - 1);
            expect(lengthBeforeDelete).toBeGreaterThan(lengthAfterDelete);
        }
        else{
            //Assert
            console.log("There are no notifications");
            expect(lengthBeforeDelete).toBe(0);
        }
    });
});
