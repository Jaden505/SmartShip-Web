export class InMemoryEntitiesService {

    _entities;
    get entities() {
        return this._entities;
    }


    constructor(sampleCreator = null) {
        this._entities = [];
        if (sampleCreator != null) {
            for (let i = 0; i < 7; i++) {
                this.save(sampleCreator(i));
            }
        }
    }

    findAll() {
        return this._entities;
    }

    findById(id, subelement = false) {
        if (subelement === false) {
            return this._entities.find(e => e?.id === id);
        } else {
            return this._entities.find(e => e.ship.id === id);
        }
    }

    findByGroup(group) {
        return this._entities.find(e => e?.group === group);
    }

    save(entity) {
        this._entities.push(entity);
    }
}
