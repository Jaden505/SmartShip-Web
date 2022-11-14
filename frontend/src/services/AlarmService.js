import http from "../http-common";

class Alarms {
    getAll(){
        return  http.get("/test/Alarms")
    }
}


export default new Alarms()
