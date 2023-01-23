import axios from "axios";
import authHeader from "@/services/auth-header";

const API_URL = process.env.VUE_APP_API_URL + '/api/test/sensorData';

class SensorDataService {
    getAll() {
        return axios.get(API_URL + "/", {
            headers: authHeader()
        });
    }

    getSensorNameByMotor() {
        return axios.get(API_URL + "/Motor", {
            headers: authHeader()
        });
    }

    getSensorNameBySeaConditions() {
        return axios.get(API_URL + "/SeaConditions", {
            headers: authHeader()
        });
    }

    getSensorNameByFuel() {
        return axios.get(API_URL + "/Fuel", {
            headers: authHeader()
        });
    }

    getSensorNameByBattery() {
        return axios.get(API_URL + "/Battery", {
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

    getSensorValue(group, name, ship){
        return axios.get(API_URL + "/Value/" + group + "/" + name + "/" + ship, {
            headers: authHeader()
        })
    }

    getSensorName(group){
        return axios.get(API_URL + "/Value/" + group,{
            headers: authHeader()
        })
    }
}

export default new SensorDataService();
