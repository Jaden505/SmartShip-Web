export class DashboardMoveComponents {
    constructor() {
        this.moving_element;
        this.component;
    }

    onDragStart(ev, component) {
        this.moving_element = ev.target;
        this.component = component;
    }

    dropHandler(ev, swap_component, components) {
        // Cant drop on itself
        const dropped_container = ev.target.parentNode.parentNode;
        if (!dropped_container.classList.contains('droppable') || !this.moving_element.classList.contains('droppable') ||
            dropped_container === this.moving_element) return components;

        let component_index = components.indexOf(this.component);
        let swap_component_index = components.indexOf(swap_component);

        if ( component_index < swap_component_index ) {
            [components[component_index], components[swap_component_index]] = [components[swap_component_index], components[component_index]];
        } else {
            [components[swap_component_index], components[component_index]] = [components[component_index], components[swap_component_index]];
        }

        return components;
    }
}
