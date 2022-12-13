import axios from 'axios';
const API_URL = process.env.VUE_APP_API_URL + '/api/test/Alarms';

class Alarms {
    getAll() {
        return axios.get(API_URL);
    }

    delete(index) {
        // return http.delete("/test/Alarms/{index}")
        return axios.delete(API_URL + "/" + index);
    }

    put(id) {
        // return http.delete("/test/Alarms/{index}")
        return axios.put(API_URL + "/" + id);
    }

    addAlarm(alarm) {
        return axios.post(API_URL, {
            parameter: alarm.parameter,
            category: alarm.category,
            value_since_last_update: alarm.valueSinceLastUpdate,
            setted_up_value: alarm.settedUpValue,
            ship_id: alarm.ship_idtext
        });
            // parameter: alarm.parameter,
            // category: alarm.category,
            // value_since_last_update: alarm.valueSinceLastUpdate,
            // setted_up_value: alarm.settedUpValue,
            // ship_id: alarm.ship_idtext,;
        // add(alarm){
        //     // return http.delete("/test/Alarms/{index}")
        //     return http.put("/test/Alarms/"+alarm)
        // }
    }
}


export default new Alarms()
