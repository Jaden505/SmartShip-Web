import axios from 'axios';

const API_URL = process.env.VUE_APP_API_URL + '/api/auth/';

class AuthService {
    login(user) {
        return axios
            .post(API_URL + 'signin', {
                username: user.username,
                password: user.password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('user');
    }

    register(user) {
        return axios.post(API_URL + 'signup', {
            address: user.address,
            city: user.city,
            country: user.country,
            dateOfBirth: user.dateOfBirth,
            firstname: user.firstname,
            gender: user.gender,
            lastname: user.lastname,
            nationality: user.nationality,
            phoneNumber: user.phoneNumber,
            postalCode: user.postalCode,
            username: user.username,
            email: user.email,
            password: user.password,
            role: user.role,
            shipID: user.shipID
        });
    }

    resetPassword(email) {
        return axios.post(API_URL + 'resetPassword', {
            email: email,
        });
    }

    changePassword(new_password, token) {
        return axios.post(API_URL + `changePassword?token=${token}`, {
            new_password: new_password,
        });
    }
}

export default new AuthService();
