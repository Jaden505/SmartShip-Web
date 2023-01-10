import axios from "axios";
import authHeader from "@/services/auth-header";

const API_URL = process.env.VUE_APP_API_URL + '/api/test/sensorData';

class SensorDataService {
    getAll() {
        return axios.get(API_URL + "/", {
            headers: authHeader()
        });
    }

    getByShipId(ship_id){
        return axios.get(API_URL + '/' + ship_id, {
            headers: authHeader()
        })
    }

    getCategories(){
        return axios.get(API_URL + "/Categories", {
            headers: authHeader()
        })
    }
}

export default new SensorDataService();
