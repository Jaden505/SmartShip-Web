import http from "../http-common";

class EngineService {
    getEngine() {
        return http.get("/test/engine");
    }
}

export default new EngineService();
