import authHeader from './auth-header';
import axios from "axios";

const API_URL = 'http://localhost:8085/api/'
import http from "../http-common";

class UserService {
    getUsers() {
        return axios.get(API_URL + 'users/all');
    }

    getUsersByRole(role_id) {
        return axios.post(API_URL + 'users/role=' + role_id, { headers: authHeader() });
    }

    updateUser(user_id, user){
        return http.put('/users/id=' + user_id,  {
            username: user.username,
            password: user.password,
            email: user.email,
            shipID: user.shipID
        });
    }

    createUser(user){
        return http.post('/users/create',  {
            username: user.username,
            password: user.password,
            email: user.email,
            shipID: user.shipID
        });
    }

    deleteUser(user_id){
        return http.delete('/users/id=' + user_id);
    }
}

export default new UserService();