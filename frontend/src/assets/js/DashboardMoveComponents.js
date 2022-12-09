export class DashboardMoveComponents {
    constructor(component) {
        this.component = component;
        this.offsetX;
        this.offsetY;
    }

    onDragStart(ev, component) {
        this.component = component;
        const rect = ev.target.getBoundingClientRect();

        this.offsetX = ev.clientX - rect.x;
        this.offsetY = ev.clientY - rect.y;
    }

    dropHandler(ev, dropped_position_element) {
        ev.preventDefault();

        const left = parseInt(dropped_position_element.style.left);
        const top = parseInt(dropped_position_element.style.top);

        this.component.style.position = 'absolute';
        this.component.style.left = ev.clientX - left - this.offsetX + 'px';
        this.component.style.top = ev.clientY - top - this.offsetY + 'px';

        dropped_position_element.appendChild(this.component);
    }

    dragHandler(ev) {
        ev.preventDefault();
        ev.dataTransfer.dropEffect = "move";
    }
}
