import axios from 'axios';

const API_URL = process.env.VUE_APP_API_URL + '/api/test/';
class StatusService {
    get() {
        return axios.get(API_URL + 'statuses');
    }
}

export default new StatusService();