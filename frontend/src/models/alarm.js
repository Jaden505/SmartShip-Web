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

    static createSample() {
        let alarms = []

        for (let i = 0; i < 8; i++) {
            let alarm = new Alarm()
            alarm.parameter = "parameter" + i;
            alarm.category = "category" + i;
            alarm.settedUpValue = "settedUpValue" + i;
            alarm.shipId = "shipId" + i;
            alarm.date = new Date();
            alarm.message = "message" + i;
            alarm.unit = "unit" + i;
        }
        return alarms;
    }
}
