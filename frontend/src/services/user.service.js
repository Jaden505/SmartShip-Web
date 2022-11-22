import authHeader from './auth-header';
// import http from "../http-common";
import axios from "axios";

const API_URL = 'http://localhost:8085/api/'

class UserService {

    getUsers() {
        return axios.get(API_URL + 'users/all');
    }

    getUsersByRole(role_id) {
        return axios.post(API_URL + 'users/role=' + role_id, { headers: authHeader() });
    }

    updateUser(user_id, user){
        return axios.put(API_URL + 'users/id=' + user_id,  {
            username: user.username,
            password: user.password,
            email: user.email
        });
    }

    deleteUser(user_id){
        return axios.delete(API_URL + 'users/id=' + user_id);
    }
}

export default new UserService();