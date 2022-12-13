import axios from 'axios';
const API_URL = process.env.VUE_APP_API_URL + '/api/test/Notification-Overview';
class Notification {
    getAll(){
        return axios.get(API_URL);
    }
}


export default new Notification()
