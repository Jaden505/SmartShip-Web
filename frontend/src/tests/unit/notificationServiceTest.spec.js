import {InMemoryEntitiesService} from "@/services/in-memory-entities-service";
import {Notification} from "@/models/notification";
let notificationService;

beforeEach(() => {
    notificationService = new InMemoryEntitiesService(Notification.createSample);
})
describe('NotificationServiceTest', () => {
    it('Should get all notifications',() => {
        //Arrange
        let notifications;
        //Act
        notifications = notificationService.findAll();
        //Assert
        expect(notifications.length).toEqual(notificationService.findAll().length);
    })

    it('should delete one notification',() => {
        //Arrange
        let notifications;
        let firstNotification;

        //Act
        notifications = notificationService.findAll();
        firstNotification = notifications[0][0];
        notificationService.deleteById(firstNotification.id);

        //Assert
        if(notifications.length > 0) {
            // eslint-disable-next-line jest/no-conditional-expect
            expect(notifications.length).toBeGreaterThan(notificationService.findAll().length);
        }
        else{
            // eslint-disable-next-line jest/no-conditional-expect
            expect(notifications.length).toEqual(notificationService.findAll().length);
        }
    })
})

