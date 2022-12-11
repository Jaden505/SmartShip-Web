export class DashboardMoveComponents {
    constructor(component) {
        this.component = component;
        this.offsetX;
        this.offsetY;
    }

    onDragStart(ev) {
        this.component = ev.target;
        const rect = ev.target.getBoundingClientRect();

        this.offsetX = ev.clientX - rect.x;
        this.offsetY = ev.clientY - rect.y;
    }

    dropHandler(ev) {
        const dropped_container = ev.target.parentNode.parentNode;

        if (!dropped_container.classList.contains('droppable')) return;

        const left = parseInt(dropped_container.style.left);
        const top = parseInt(dropped_container.style.top);

        this.component.style.position = 'absolute';
        this.component.style.left = ev.clientX - left - this.offsetX + 'px';
        this.component.style.top = ev.clientY - top - this.offsetY + 'px';

        this.swap(this.component, dropped_container)
        this.component.style.position = 'static';
    }

    dragHandler(ev) {
        ev.dataTransfer.dropEffect = "move";
    }

    swap(node1, node2) {
        const afterNode2 = node2.nextElementSibling;
        const parent = node2.parentNode;
        node1.replaceWith(node2);
        parent.insertBefore(node1, afterNode2);
    }
}
