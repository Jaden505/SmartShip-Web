import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/api/test/Alarms';
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
    //We need to add a method to update an alarm
    postNotification(alarm) {
        let notification = JSON.stringify(alarm)
        //We need to change the API_URL to the correct one
        return axios.post(API_URL + "/send", notification, {
            headers: {
                "Authorization": 'Bearer ' + user.accessToken,
                "Content-Type": "application/json"
            }
        });
    }

    addAlarm(alarm) {
        let newAlarm = JSON.stringify(alarm)
        return axios.post(API_URL,
            newAlarm, {
                headers: {
                    "Authorization": 'Bearer ' + user.accessToken,
                    "Content-Type": "application/json"
                }
            });
    }


}
export default new AlarmService()
