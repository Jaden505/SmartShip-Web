import axios from 'axios';
const API_URL = 'http://localhost:8085/api/test/Alarms';

class Alarms {
    getAll(){
        return axios.get(API_URL);
    }

    delete(index){
        // return http.delete("/test/Alarms/{index}")
        return axios.delete(API_URL + "/" + index);
    }

    put(id){
        // return http.delete("/test/Alarms/{index}")
        return axios.put(API_URL + "/" + id);
    }
    post(){
        return axios.post(API_URL);
    }
    // add(alarm){
    //     // return http.delete("/test/Alarms/{index}")
    //     return http.put("/test/Alarms/"+alarm)
    // }
}


export default new Alarms()
