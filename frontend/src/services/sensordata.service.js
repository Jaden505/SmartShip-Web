import axios from "axios";
import authHeader from "@/services/auth-header";

const API_URL = process.env.VUE_APP_API_URL + '/api/test/sensordata';

class SensorDataService {
    getAll() {
        return axios.get(API_URL + "/all", {
            headers: authHeader()
        });
    }

    get(id){
        return axios.get(API_URL + '/' + id, {
            headers: authHeader()
        })
    }
}

export default new SensorDataService();
