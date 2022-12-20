import axios from 'axios';
const API_URL_ALARMS = 'http://localhost:8085/api/test/Alarms';
const API_URL_NOTIFICATION = 'http://localhost:8085/api/test/Notification-Overview';

class Alarms {
    getAll() {
        return axios.get(API_URL_ALARMS);
    }

    delete(index) {
        return axios.delete(API_URL_ALARMS + "/" + index);
    }

    put(id) {
        return axios.put(API_URL_ALARMS + "/" + id);
    }

    addAlarm(alarm) {
        return axios.post(API_URL_ALARMS, {
            parameter: alarm.parameter,
            category: alarm.category,
            value_since_last_update: alarm.valueSinceLastUpdate,
            setted_up_value: alarm.settedUpValue,
            ship_id: alarm.ship_idtext
        });
    }

    getAllNotifications(){
        return axios.get(API_URL_NOTIFICATION);
    }
}


export default new Alarms()
