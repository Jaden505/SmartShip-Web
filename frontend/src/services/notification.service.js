const axios = require('axios');

class NotificationService {
    async getAll() {
        return await axios.get(
            `http://localhost:8085/api/test/notification-overview`
        );
    }
    async delete(id) {
        return await axios.delete(
            `http://localhost:8085/api/test/notification-overview/${id}`
        );
    }
}


module.exports = NotificationService;
