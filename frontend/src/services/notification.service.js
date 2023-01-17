const axios = require('axios');
import authHeader from "@/services/auth-header";
const API_URL = "http://localhost:8085/api/test/notification-overview"
export class NotificationService {
    async getAll() {
        return await axios.get(
            API_URL,{
                headers: authHeader()
            }
        );
    }
    async delete(id) {
        return await axios.delete(
            API_URL + "/" + id,{
                headers: authHeader()
            }
        );
    }
}
