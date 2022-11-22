import axios from 'axios';
import authHeader from './auth-header';
import http from "../http-common";

const API_URL = 'http://localhost:8080/api/test/';

class UserService {
    getUsers() {
        return http.get( 'users/all');
    }

    getUsersByRole(role_id) {
        return http.post( 'users/role=' + role_id, { headers: authHeader() });
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

    deleteUser(user_id) {
        return http.delete('/users/id=' + user_id);
    }

    getPublicContent() {
        return axios.get(API_URL + 'all');
    }

    getUserBoard() {
        return axios.get(API_URL + 'user', { headers: authHeader() });
    }

    getModeratorBoard() {
        return axios.get(API_URL + 'manager', { headers: authHeader() });
    }

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}

export default new UserService();