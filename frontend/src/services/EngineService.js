const API_URL = 'http://localhost:8085/api/';

class EngineService {
    getEngine() {
        return API_URL.get("test/engine");
    }
}

export default new EngineService();
