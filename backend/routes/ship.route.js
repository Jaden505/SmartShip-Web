module.exports = app => {
    const ships = require("../controllers/ship.controller.js");

    let router = require("express").Router();

    // Create a new Tutorial
    router.post("/", ships.create);

    // Retrieve all ships
    router.get("/", ships.findAll);

    // Retrieve all published ships
    router.get("/published", ships.findAllPublished);

    // Retrieve a single Tutorial with id
    router.get("/:id", ships.findOne);

    // Update a Tutorial with id
    router.put("/:id", ships.update);

    // Delete a Tutorial with id
    router.delete("/:id", ships.delete);

    // Delete all ships
    router.delete("/", ships.deleteAll);

    app.use('/api/ships', router);
};