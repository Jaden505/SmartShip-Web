export class Notification {
    parameter;
    category;
    value;
    shipId;
    date;
    message;
    unit;


    constructor(parameter, category, value, shipId, date, message, unit) {
        this.parameter = parameter;
        this.category = category;
        this.value = value;
        this.shipId = shipId;
        this.date = date;
        this.message = message;
        this.unit = unit;
    }
    static createSample() {
        let notifications = []

        for (let i = 0; i < 8; i++) {
            let notification = new Notification()
            notification.parameter = "parameter" + i;
            notification.category = "category" + i;
            notification.value = "value" + i;
            notification.shipId = "shipId" + i;
            notification.date = "date" + i;
            notification.message = "message" + i;
            notification.unit = "unit" + i;


            notifications.push(notification)
        }
        return notifications;
    }
}

