import { mount } from '@vue/test-utils'
// import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
// import Dashboard from "@/components/pages/Dashboard";
//
// const wrapper = mount(Dashboard, {
//     global: {
//         stubs: { FontAwesomeIcon }
//     }
// })

test('should save to localStorage', () => {
    jest.spyOn(Storage.prototype, 'setItem')
    jest.spyOn(Storage.prototype, 'getItem')

    window.localStorage.setItem('test', 'test')
    expect(window.localStorage.getItem('test')).toBe('test')


});




