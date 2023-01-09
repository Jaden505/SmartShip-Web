import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/api/test/Notification-Overview';
class Notification {
    getAll(){
        return axios.get(API_URL, {
            headers: authHeader()
        });
    }
    delete(index) {
        return axios.delete(API_URL + "/" + index, {
            headers: authHeader()
        });
    }
}


export default new Notification()
