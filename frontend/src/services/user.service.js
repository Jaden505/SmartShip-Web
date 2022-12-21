import axios from 'axios';
import authHeader from './auth-header';

const API_URL = process.env.VUE_APP_API_URL + '/api/test/';

class UserService {
    getUsers() {
        return axios.get( API_URL + 'users/all', {
            headers: authHeader()
        });
    }

    getUsersByRole(role_id) {
        return axios.get( API_URL + 'users/role/' + role_id, {
            headers: authHeader()
        });
    }

    updateUser(user_id, user){
        return axios.put(API_URL + 'users/' + user_id,  {
            username: user.username,
            password: user.password,
            email: user.email,
            ship: user.ship
        }, {
            headers: authHeader()
        });
    }

    createUser(user){
        return axios.post(API_URL +'users/create',  {
            username: user.username,
            password: user.password,
            email: user.email,
            shipID: user.shipID,
            roleID: user.roleID
        }, {
            headers: authHeader()
        });
    }

    deleteUser(user_id) {
        return axios.delete(API_URL + 'users/' + user_id, {
            headers: authHeader()
        });
    }

}

export default new UserService();