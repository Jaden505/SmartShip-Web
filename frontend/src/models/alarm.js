export class Alarm {
    parameter;
    category;
    valueSinceLastUpdate;
    settedUpValue;
    shipId;


    constructor(parameter, category, valueSinceLastUpdate, settedUpValue, shipId) {
        this.parameter = parameter;
        this.category = category;
        this.valueSinceLastUpdate = valueSinceLastUpdate;
        this.settedUpValue = settedUpValue;
        this.shipId = shipId;
    }
}