import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8085/api/test/';

class UserService {
    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}

export default new UserService();