import http from "../http-common";

class Alarms {
    getAll(){
        return  http.get("/test/Alarms")
    }

    delete(index){
        // return http.delete("/test/Alarms/{index}")
        return http.delete("/test/Alarms/"+index)
    }
    // put(index){
    //     // return http.delete("/test/Alarms/{index}")
    //     return http.put("/test/Alarms/"+index)
    // }
    // add(alarm){
    //     // return http.delete("/test/Alarms/{index}")
    //     return http.put("/test/Alarms/"+alarm)
    // }
}


export default new Alarms()
