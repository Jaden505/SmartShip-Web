import http from "../http-common";

class Notification {
    getAll(){
        return  http.get("/test/Notification-Overview")
    }

    delete(index){
        // return http.delete("/test/Alarms/{index}")
        return http.delete("/test/Notification-Overview/"+index)
    }
    put(id){
        // return http.delete("/test/Alarms/{index}")
        return http.put("/test/Notification-Overview/"+id)
    }
    // add(alarm){
    //     // return http.delete("/test/Alarms/{index}")
    //     return http.put("/test/Alarms/"+alarm)
    // }
}


export default new Notification()
