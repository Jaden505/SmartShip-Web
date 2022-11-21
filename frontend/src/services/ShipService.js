import axios from "axios";

const API_URL = 'http://localhost:8085/api/';

class ShipDataService {
    getAll() {
        return API_URL.get("ships");
    }
    // todo the right endpoint
    getWater() {
        return axios.get(API_URL + 'test/chart');
    }

    get(id) {
        return API_URL.get(`ships/${id}`);
    }

    create(data) {
        return API_URL.post("ships", data);
    }

    update(id, data) {
        return API_URL.put(`ships/${id}`, data);
    }

    delete(id) {
        return API_URL.delete(`/ships/${id}`);
    }
}

export default new ShipDataService();
