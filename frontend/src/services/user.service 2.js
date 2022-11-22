import authHeader from './auth-header';
import http from "../http-common";

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

    deleteUser(user_id){
        return http.delete('/users/id=' + user_id);
    }
}

export default new UserService();