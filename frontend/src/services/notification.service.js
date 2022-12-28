import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/api/test/Notification-Overview';
class Notification {
    getAll(){
        return axios.get(API_URL, {
            headers: authHeader()
        });
    }
}


export default new Notification()