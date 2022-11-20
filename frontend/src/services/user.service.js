import authHeader from './auth-header';
import http from "../http-common";

class UserService {
    getUsers() {
        return http.get('/users/all');
    }

    getUsersByRole(role_id) {
        return http.post('/users/role=' + role_id, { headers: authHeader() });
    }
}

export default new UserService();