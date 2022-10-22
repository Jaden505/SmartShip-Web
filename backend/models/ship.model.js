module.exports = (sequelize, Sequelize) => {
    const Ship = sequelize.define("ship", {
        ship_id: {
            type: Sequelize.INTEGER
        },
        operator: {
            type: Sequelize.STRING
        },
        location: {
            type: Sequelize.STRING
        },
        status: {
            type: Sequelize.STRING
        },
        origin: {
            type: Sequelize.STRING
        },
        destination: {
            type: Sequelize.STRING
        },
    });

    return Ship;
};