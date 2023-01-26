import axios from "axios";

class RoomService{
    BACKEND_URL = 'http://localhost:8085/api/test/room'

    getAll() {
        return axios.get(this.BACKEND_URL);
    }

    getById(id) {
        return axios.get(this.BACKEND_URL + "/" + id);
    }
}
export default new RoomService();
