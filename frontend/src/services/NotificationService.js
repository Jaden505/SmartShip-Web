import http from "../http-common";

class NotificationService {
    getAll(){
        return  http.get("/test/NotificationOverview")
    }
}


export default new NotificationService()
