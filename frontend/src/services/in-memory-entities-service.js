export class InMemoryEntitiesService
    /* implements EntitiesServiceInterface<E> */ {

    list;

    constructor(sampleCreator = null) {
        this.list = [];
        if (sampleCreator != null) {
            for (let i = 0; i < 7; i++) {
                this.save(sampleCreator(0));
            }
        }
    }

    findAll() {
        return this.list;
    }

    save(sampleCreator) {
        if (sampleCreator == null) {
            return;
        }
        this.list.push(sampleCreator);
    }

    deleteById(id) {
        this.list = this.list.filter(e => e?.id !== id);
    }

    post(alarm) {
        if (alarm == null) {
            return;
        }
        let notification = [];
        notification.push(alarm);
        this.list = this.list.push(notification);
    }
}
