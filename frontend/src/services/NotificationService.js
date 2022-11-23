import axios from 'axios';
const API_URL = 'http://localhost:8085/api/test/Notification-Overview';
class Notification {
    getAll(){
        return axios.get(API_URL);
    }
}


export default new Notification()
