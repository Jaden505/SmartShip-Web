import http from "../http-common";
import axios from "axios";

const API_URL = 'http://localhost:8085/api/'

class ShipDataService {
    getAll() {
        return http.get("/ships");
    }


    get(id){
        return axios.get(API_URL + 'ships/shipId=' + id)
    }

    create(data) {
        return http.post("/ships", data);
    }

    update(id, data) {
        return http.put(`/ships/${id}`, data);
    }

    delete(id) {
        return http.delete(`/ships/${id}`);
    }
}

export default new ShipDataService();