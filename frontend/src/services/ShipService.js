import http from "../http-common";

class ShipDataService {
    getAll() {
        return http.get("/ships");
    }

    get(id){
        return http.get('/ships/shipId=' + id)
    }

    create(ship) {
        return http.post("/ships/create", ship);
    }

    update(id, ship) {
        return http.put(`/ships/${id}`, ship);
    }

    delete(id) {
        return http.delete(`/ships/${id}`);
    }
}

export default new ShipDataService();