// We import axios to make the HTTP requests and authHeader to get the token from the local storage.
import axios from "axios";
import authHeader from "@/services/auth-header";
// We define the API_URL as the URL of the backend server.
const API_URL = process.env.VUE_APP_API_URL + '/api/test/notification-overview';
class NotificationService {
    //We define a function to get all notifications.
    getAll() {
        //We return the axios get request to the API_URL with the authHeader.
        return axios.get(
            API_URL,{
                headers: authHeader()
            }
        );
    }
    //We define a function to get all notifications by shipId.
    delete(id) {
        //We return the axios delete request to the API_URL with the authHeader.
        return axios.delete(
            API_URL + "/" + id, {
                headers: authHeader()
            }
        );
    }
}
//We export the NotificationService.
export default new NotificationService();
