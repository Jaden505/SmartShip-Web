import http from "../http-common";

class ShipDataService {
    getAll() {
        return http.get("/ships");
    }
    // todo the right endpoint
    getWater() {
        return http.get("test/chart");
    }

    get(id) {
        return http.get(`/ships/${id}`);
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
