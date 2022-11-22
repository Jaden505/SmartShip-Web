import http from "../http-common";

class StatusService {
    get() {
        return http.get( '/statuses');
    }
}

export default new StatusService();