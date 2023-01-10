export class Alarm {
    id;
    parameter;
    category;
    valueSinceLastUpdate;
    settedUpValue;
    shipId;


    constructor(id, parameter, category, valueSinceLastUpdate, settedUpValue, shipId) {
        this.id = id;
        this.parameter = parameter;
        this.category = category;
        this.valueSinceLastUpdate = valueSinceLastUpdate;
        this.settedUpValue = settedUpValue;
        this.shipId = shipId;
    }
}