import authHeader from './auth-header';
import http from "../http-common";
import axios from "axios";

const API_URL = 'http://localhost:8085/api/'

class UserService {

    getUsers() {
        return http.get('/users/all');
    }

    getUsersByRole(role_id) {
        return http.post('/users/role=' + role_id, { headers: authHeader() });
    }

    updateUser(user_id, user){
        return axios.put('users/id=' + user_id,  {
            username: user.username,
            password: user.password,
            email: user.email
        });
    }

    createUser(user){
        return axios.put(API_URL + 'users/create',  {
            username: user.username,
            password: user.password,
            email: user.email
        });
    }
}

export default new UserService();