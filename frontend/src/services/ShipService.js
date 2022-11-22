import http from "../http-common";

class ShipDataService {
    getAll() {
        return http.get("/ships");
    }

    get(id){
        return http.get('ships/shipId=' + id)
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

    delete(id) {
        return http.delete(`/ships/${id}`);
    }
}

export default new ShipDataService();