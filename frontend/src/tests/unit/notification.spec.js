import {mount} from '@vue/test-utils'
import NotificationOverview from '@/views/NotificationOverview.vue'

let wrapper;

beforeEach(() => {
    wrapper = mount(NotificationOverview)
})

it('renders properly', function () {
    expect(wrapper.html()).toMatchSnapshot()
});
