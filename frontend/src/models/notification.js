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
}
