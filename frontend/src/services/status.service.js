import axios from 'axios';

const API_URL = 'http://localhost:8085/api/test/';
class StatusService {
    get() {
        return axios.get(API_URL + 'statuses');
    }
}

export default new StatusService();