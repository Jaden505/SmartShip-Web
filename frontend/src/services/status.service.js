import axios from 'axios';
import authHeader from "@/services/auth-header";

const API_URL = 'http://localhost:8085/api/test/';
class StatusService {
    get() {
        return axios.get(API_URL + 'statuses', {
            headers: authHeader()
        });
    }
}

export default new StatusService();