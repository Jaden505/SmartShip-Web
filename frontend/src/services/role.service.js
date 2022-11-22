import http from "../http-common";

class RoleService {
    get() {
        return http.get( '/roles');
    }
}

export default new RoleService();