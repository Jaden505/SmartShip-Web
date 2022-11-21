import http from "../http-common";

class SensorDataService {
    getSensorData() {
        return http.get("/test/sensor_data");
    }
}

export default new SensorDataService();
