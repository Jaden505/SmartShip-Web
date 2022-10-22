module.exports = (sequelize, Sequelize) => {
    const Ship = sequelize.define("ship", {
        operator: {
            type: Sequelize.STRING
        },
        location: {
            type: Sequelize.STRING
        },
        status: {
            type: Sequelize.STRING
        },
    });

    return Ship;
};