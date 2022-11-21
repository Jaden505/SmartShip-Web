import authHeader from './auth-header';
import http from "../http-common";
import axios from "axios";

class UserService {

    getUsers() {
        return http.get('/users/all');
    }

    getUsersByRole(role_id) {
        return http.post('/users/role=' + role_id, { headers: authHeader() });
    }

    updateUser(user_id, user){
        return axios.put('/users/id=' + user_id,  {
            username: user.username,
            password: user.password,
            email: user.email
        });
    }

    createUser(user){
        return axios.put('/users/create',  {
            username: user.username,
            password: user.password,
            email: user.email
        });
    }

    deleteUser(user_id){
        return axios.delete('/users/id=' + user_id);
    }
}

export default new UserService();