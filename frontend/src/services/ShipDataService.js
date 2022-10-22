import http from "../http-common";

class ShipDataService {
    getAll() {
        return http.get("/ships");
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

    deleteAll() {
        return http.delete(`/ships`);
    }

    findByTitle(title) {
        return http.get(`/ships?title=${title}`);
    }
}

export default new ShipDataService();