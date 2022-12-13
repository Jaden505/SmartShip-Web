export class DashboardMoveComponents {
    constructor(component) {
        this.component = component;
        this.offsetX;
        this.offsetY;
    }

    onDragStart(ev) {
        this.component = ev.target;
        const rect = this.component.getBoundingClientRect();

        this.offsetX = window.innerWidth; - rect.x;
        this.offsetY = window.innerHeight - rect.y;
    }

    dropHandler(ev) {
        const dropped_container = ev.target.parentNode.parentNode;

        if (!dropped_container.classList.contains('droppable') || dropped_container === this.component.parentNode) return;

        const left = parseInt(dropped_container.style.left);
        const top = parseInt(dropped_container.style.top);

        this.component.style.position = 'absolute';
        this.component.style.left = ev.clientX - left - this.offsetX + 'px';
        this.component.style.top = ev.clientY - top - this.offsetY + 'px';

        this.swap(this.component, dropped_container)
        this.component.style.position = 'static';

        this.updatePosition()
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

    async updatePosition() {
        // Wait for element to be added
        await new Promise(resolve => setTimeout(resolve, 1));

        const wrapper_positions = document.querySelectorAll('.position-number')

        wrapper_positions.forEach((wrapper, index) => {
            wrapper.textContent = index+1;
        })
    }
}
