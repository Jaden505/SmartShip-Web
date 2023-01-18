import axios from "axios";
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/api/test/notification-overview';
class NotificationService {
    getAll() {
        return axios.get(
            API_URL,{
                headers: authHeader()
            }
        );
    }
    delete(id) {
        return axios.delete(
            API_URL + "/" + id, {
                headers: authHeader()
            }
        );
    }
}

export default new NotificationService();
