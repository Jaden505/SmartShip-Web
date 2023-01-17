const NotificationService = require('../../services/notification.service');
import axios from "axios";

let notificationService = new NotificationService();
describe('NotificationService', () => {
    it('Checks ', async () => {
        await notificationService.getAll().then((response) => {
            expect(response.data).toBeInstanceOf(Array);
            console.log((response.data).length);
        });
    });

    it('should return correct todo', async () => {
        let length = await notificationService.getAll().then((response) => {
            return (response.data).length;
        })
        let firstData = await notificationService.getAll().then((response) => {
            return ((response.data)[0]).id;
        })

        console.log(firstData);
        if (length > 0) {
            console.log("There are" + length + "notifications");
           let errase = await notificationService.delete(firstData).then((response) => {
                return (response.data);
            })
            console.log("Notification deleted");
            expect(errase.STATUS).toBe(204);
        }
        else{
            console.log("There are no notifications");
            expect(length).toBe(0);
        }
    });
});
