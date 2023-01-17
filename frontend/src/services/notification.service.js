const axios = require('axios');
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/api/test/notification-overview';
export class NotificationService {
    static getAll() {
        return axios.get(
            API_URL,{
                headers: authHeader()
            }
        );
    }
    static delete(id) {
        return axios.delete(
            API_URL + "/" + id, {
                headers: authHeader()
            }
        );
    }
}
