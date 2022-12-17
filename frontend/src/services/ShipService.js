import axios from "axios";

const API_URL = 'http://localhost:8085/api/test/';

class ShipDataService {
    getAll() {
        return axios.get(API_URL + "ships/all");
    }
    // todo the right endpoint
    getWater() {
        return axios.get(API_URL + 'chart');
    }

    get(id){
        return axios.get(API_URL + 'ships/' + id)
    }

    create(ship) {
        return axios.post(API_URL +"ships/create", ship);
    }

    updateShip(ship_id, ship) {
        return axios.put(API_URL + 'ships/' + ship_id,
            {
                name: ship.name,
                location: ship.location,
                origin: ship.origin,
                destination: ship.destination,
                status: ship.status
            });
    }

    deleteShip(ship_id) {
        return axios.delete(API_URL + "ships/" + ship_id)
    }
}

export default new ShipDataService();
