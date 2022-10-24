import axios from 'axios';

const API_URL = 'http://localhost:8085/api/auth/';

class AuthService {
    login(user) {
        return axios
            .post(API_URL + 'login', {
                email: user.email,
                password: user.password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    // logout() {
    //     localStorage.removeItem('user');
    // }
}

export default new AuthService();