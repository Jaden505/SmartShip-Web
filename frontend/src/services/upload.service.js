import axios from 'axios';
import authHeader from "@/services/auth-header";
const API_URL = process.env.VUE_APP_API_URL + '/image';
let user = JSON.parse(localStorage.getItem('user'));

class UploadFilesService {
    upload(file, email) {
        let formData = new FormData();
        formData.append('image', file, file.name);
        formData.append('userEmail', email);

        return axios.post(API_URL + "", formData,{
            headers: {
                "Authorization": 'Bearer ' + user.accessToken,
                "Content-Type": "multipart/form-data"
            }
        });
    }

    getFile(userId) {
        return axios.get(API_URL + `/${userId}`, {
            headers: authHeader()
        });
    }
}

export default new UploadFilesService();