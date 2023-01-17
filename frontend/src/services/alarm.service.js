const axios = require('axios');
import authHeader from "@/services/auth-header";
const API_URL = "http://localhost:8085/api/test/Alarms"
let user = JSON.parse(localStorage.getItem('user'));

export class AlarmService {
    async getAll() {
        return await axios.get(API_URL, {
            headers: authHeader()
        });
    }

    async delete(index) {
        return await axios.delete(API_URL + "/" + index, {
            headers: authHeader()
        });
    }

    async postNotification(alarm) {
        let notification = JSON.stringify(alarm)
        return await axios.post(API_URL + "/send", notification, {
            headers: {
                "Authorization": 'Bearer ' + user.accessToken,
                "Content-Type": "application/json"
            }
        });
    }

    async addAlarm(alarm) {
        let newAlarm = JSON.stringify(alarm)
        return await axios.post(API_URL,
            newAlarm, {
                headers: {
                    "Authorization": 'Bearer ' + user.accessToken,
                    "Content-Type": "application/json"
                }
            });
    }
}

// const axios = require('axios');
// import authHeader from "@/services/auth-header";
//
// const API_URL_ALARMS = "http://localhost:8085/api/test/Alarms";
// let user = JSON.parse(localStorage.getItem('user'));
//
// class AlarmService {
//     async getAll() {
//         return await axios.get(API_URL_ALARMS, {
//             headers: authHeader()
//         });
//     }
//
//     async delete(index) {
//         return await axios.delete(API_URL_ALARMS + "/" + index, {
//             headers: authHeader()
//         });
//     }
//
//     async postNotification(alarm) {
//         let notification = JSON.stringify(alarm)
//         return await axios.post(API_URL_ALARMS + "/send", notification, {
//             headers: {
//                 "Authorization": 'Bearer ' + user.accessToken,
//                 "Content-Type": "application/json"
//             }
//         });
//     }
//
//     async addAlarm(alarm) {
//         let newAlarm = JSON.stringify(alarm)
//         return await axios.post(API_URL_ALARMS,
//             newAlarm, {
//                 headers: {
//                     "Authorization": 'Bearer ' + user.accessToken,
//                     "Content-Type": "application/json"
//                 }
//             });
//     }
// }
//
//
// export default new AlarmService()
