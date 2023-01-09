import axios from "axios";
import authHeader from "@/services/auth-header";

const API_URL = process.env.VUE_APP_API_URL + '/api/test/';

class ShipDataService {
    getAll() {
        return axios.get(API_URL + "ships/all", {
            headers: authHeader()
        });
    }

    getWaterSupply(id) {
        return axios.get(API_URL + 'ships/' + id + '/watersupply', {
            headers: authHeader()
        });
    }

    get(id){
        return axios.get(API_URL + 'ships/' + id, {
            headers: authHeader()
        })
    }

    create(ship) {
        return axios.post(API_URL +"ships/create", ship, {
            headers: authHeader()
        });
    }

    updateShip(ship_id, ship) {
        return axios.put(API_URL + 'ships/' + ship_id,
            {
                name: ship.name,
                location: ship.location,
                origin: ship.origin,
                destination: ship.destination,
                status: ship.status
            }, {
                headers: authHeader()
            });
    }

    deleteShip(ship_id) {
        return axios.delete(API_URL + "ships/" + ship_id, {
            headers: authHeader()
        })
    }
}

export default new ShipDataService();
