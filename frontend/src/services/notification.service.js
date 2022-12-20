import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL = 'http://localhost:8085/api/test/Notification-Overview';
class Notification {
    getAll(){
        return axios.get(API_URL, {
            headers: authHeader()
        });
    }
}


export default new Notification()