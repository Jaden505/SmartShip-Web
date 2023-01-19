export class Alarm {
    parameter;
    category;
    settedUpValue;
    shipId;
    date;
    message;
    unit;


    constructor(parameter, category, settedUpValue, shipId, date, message, unit) {
        this.parameter = parameter;
        this.category = category;
        this.settedUpValue = settedUpValue;
        this.shipId = shipId;
        this.date = date;
        this.message = message;
        this.unit = unit;
    }
}
