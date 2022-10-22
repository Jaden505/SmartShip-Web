const db = require("../models");
const Ship = db.ships;
const Op = db.Sequelize.Op;

// Create and Save a new Ship
exports.create = (req, res) => {

};

// Retrieve all Ships from the database.
exports.findAll = (req, res) => {
    const ship_id = req.query.id;
    let condition = ship_id ? { ship_id: { [Op.like]: `%${ship_id}%` } } : null;

    Ship.findAll({where: condition})
        .then(data => {
            res.send(data);
        })
        .catch(err => {
            res.status(500).send({
                message:
                err.message || "Some error occurred while retrieving ships."
            })
        })
};

// Find a single Ship with an id
exports.findOne = (req, res) => {

};

// Update a Ship by the id in the request
exports.update = (req, res) => {

};

// Delete a Ship with the specified id in the request
exports.delete = (req, res) => {

};

// Delete all Ships from the database.
exports.deleteAll = (req, res) => {

};

// Find all published Ships
exports.findAllPublished = (req, res) => {

};