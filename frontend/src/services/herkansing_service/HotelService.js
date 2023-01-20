import axios from "axios";
import authHeader from "@/services/auth-header";

class HotelService{
    BACKEND_URL = 'http://localhost:8085/api/test/hotel'

    getAll() {
        return axios.get(this.BACKEND_URL);
    }

    getById(id) {
        return axios.get(this.BACKEND_URL + "/" + id);
    }

    createScooter(){
        return axios.get(this.BACKEND_URL);
    }

}
export default new HotelService();
