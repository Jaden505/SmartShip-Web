import axios from 'axios';
import authHeader from './auth-header';

const API_URL = process.env.VUE_APP_API_URL + '/api/test/';

class UserService {
    getUsers() {
        return axios.get( API_URL + 'users/all', {
            headers: authHeader()
        });
    }

    getUserById(id){
        return axios.get(API_URL + "users/" + id, {
            headers: authHeader()
        })
    }

    getUsersByRole(role) {
        return axios.get( API_URL + 'users/role/' + role, {
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

    updateProfile(user_Id, user){
        return axios.put(API_URL + 'users/profile/' + user_Id, {
            firstname: user.firstname,
            lastname: user.lastname,
            gender: user.gender,
            email: user.email,
            phonenumber: user.phoneNumber,
            address: user.address,
            postalcode: user.postalCode,
            city: user.city,
            country: user.country
        }, {
            headers: authHeader()
        })
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
