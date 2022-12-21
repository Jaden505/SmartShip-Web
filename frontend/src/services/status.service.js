import axios from 'axios';
import authHeader from "@/services/auth-header";

const API_URL = process.env.VUE_APP_API_URL + '/api/test/';
class StatusService {
    get() {
        return axios.get(API_URL + 'statuses', {
            headers: authHeader()
        });
    }
}

export default new StatusService();