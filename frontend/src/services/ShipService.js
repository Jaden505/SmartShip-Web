import axios from "axios";

import http from "../http-common";

const API_URL = 'http://localhost:8085/api/';

class ShipDataService {
    getAll() {
        return API_URL.get("ships");
    }
    // todo the right endpoint
    getWater() {
        return axios.get(API_URL + 'test/chart');
    }

    get(id){
        return http.get('/ships/shipId=' + id)
    }

    create(ship) {
        return http.post("/ships/create", ship);
    }

    updateShip(ship_id, ship) {
        return http.put('/ships/shipId=' + ship_id,
            {
                name: ship.name,
                location: ship.location,
                origin: ship.origin,
                destination: ship.destination
            });
    }

    deleteShip(ship_id) {
        return http.delete("ships/shipId=" + ship_id)
    }
}

export default new ShipDataService();
