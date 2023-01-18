import axios from "axios";
import authHeader from "@/services/auth-header";
const API_URL =  process.env.VUE_APP_API_URL +"/api/test/Alarms"
let user = JSON.parse(localStorage.getItem('user'));

class AlarmService {
    getAll() {
        return axios.get(API_URL, {
            headers: authHeader()
        });
    }

     delete(index) {
        return axios.delete(API_URL + "/" + index, {
            headers: authHeader()
        });
    }

    postNotification(alarm) {
        let notification = JSON.stringify(alarm)
        return axios.post(API_URL + "/send", notification, {
            headers: {
                "Authorization": 'Bearer ' + JSON.parse(localStorage.getItem('user')).accessToken,
                "Content-Type": "application/json"
            }
        });
    }

    addAlarm(alarm) {
        let newAlarm = JSON.stringify(alarm)
        return axios.post(API_URL,
            newAlarm, {
                headers: {
                    "Authorization": 'Bearer ' + JSON.parse(localStorage.getItem('user')).accessToken,
                    "Content-Type": "application/json"
                }
            });
    }
}
export default new AlarmService()
