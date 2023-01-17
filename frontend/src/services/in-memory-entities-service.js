export class InMemoryEntitiesService
    /* implements EntitiesServiceInterface<E> */ {

    notifications;

    constructor(sampleCreator = null) {
        this.notifications = [];
        if (sampleCreator != null) {
            for (let i = 0; i < 7; i++) {
                this.save(sampleCreator(0));
            }
        }
    }

    findAll() {
        return this.notifications;
    }

    save(notification) {
        if(notification == null) {
            return;
        }
        this.notifications.push(notification);
    }

    deleteById(id) {
        this.notifications = this.notifications.filter(e => e?.id !== id);
    }
}
