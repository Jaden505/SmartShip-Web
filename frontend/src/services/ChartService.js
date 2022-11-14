import http from "../http-common";

class ChartService {
    getAll() {
        return http.get("/test/watertank");
    }

    get(id) {
        return http.get(`/test/watertank/${id}`);
    }
}

export default new ChartService();
