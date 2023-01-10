import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL_ALARMS = process.env.VUE_APP_API_URL + '/api/test/Alarms';

class Alarms {
    getAll() {
        return axios.get(API_URL_ALARMS, {
            headers: authHeader()
        });
    }

    delete(index) {
        return axios.delete(API_URL_ALARMS + "/" + index, {
            headers: authHeader()
        });
    }

    put(id) {
        return axios.put(API_URL_ALARMS + "/" + id, {
            headers: authHeader()
        });
    }

    addAlarm(alarm) {
        return axios.post(API_URL_ALARMS, {
            alarm
        }, {
            headers: authHeader()
        });
    }
}


export default new Alarms()
