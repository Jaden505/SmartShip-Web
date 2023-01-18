import {mount} from "@vue/test-utils";
import NotificationOverview from "@/components/pages/NotificationOverview";

describe('NotificationOverview', () => {
    it('Checks if all subcategories exist', function () {
        const wrapper = mount(NotificationOverview)
        expect(wrapper.element.children.length, `main page starting with ${wrapper.element.tagName} 
            has no child elements`).toBeGreaterThan(0);
        // eslint-disable-next-line jest/no-standalone-expect
        expect(wrapper.html()).toContain('Notifications');
        expect(wrapper.findAll('div').length).toBeGreaterThan(0);
    });

})
