import {InMemoryEntitiesService} from "@/services/in-memory-entities-service";
import {Notification} from "@/models/notification";
let notificationService;

beforeEach(() => {
    notificationService = new InMemoryEntitiesService(Notification.createSample);
})

it('Should get all notifications',() => {
    //Arrange
    let notifications;
    //Act
    notifications = notificationService.findAll();
    //Assert
    expect(notifications.length).toEqual(notificationService.findAll().length);
})
