export class InMemoryEntitiesService {

    _entities;
    get entities() {
        return this._entities;
    }


    constructor(sampleCreator = null) {
        this._entities = [];
        if (sampleCreator != null) {
            for (let i = 0; i < 13; i++) {
                this.save(sampleCreator(i));
            }
        }
    }

    findAll() {
        return this._entities;
    }

    findById(id) {
        return this._entities.find(e => e?.id === id);
    }

    save(entity) {
        this._entities.push(entity);
    }
}
