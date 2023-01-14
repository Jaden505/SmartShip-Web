import { mount } from '@vue/test-utils'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import Dashboard from "@/components/pages/Dashboard";

const wrapper = mount(Dashboard, {
    global: {
        stubs: { FontAwesomeIcon }
    }
})

const localStorageMock = (function () {
    let store = {};

    return {
        getItem(key) {
            return store[key];
        },

        setItem(key, value) {
            store[key] = value;
        },

        clear() {
            store = {};
        },

        removeItem(key) {
            delete store[key];
        },

        getAll() {
            return store;
        },
    };
})();

describe('storage', () => {
    beforeAll(() => {
        Object.defineProperty(window, "localStorage", { value: localStorageMock });
    });

    it('saves the key to the storage', () => {
        window.localStorage.setItem('user', {
            accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXJ0IiwiaWF0IjoxNjczMjEwMDM3LCJleHAiOjE2NzMyMTY0Mzd9.V2M_o0UX448yuRJBJZjgz-crfL_Ye4Dr9PBfSie9e69TjCvqMoyWniDsRlBIoqjX5_VsSn_Y91aaYwkAWXI9vQ",
            email: "btynior@gmail.com",
            id: 1,
            roles: ['ROLE_ADMIN'],
            ship: null,
            tokenType: "Bearer",
            username: "bart"})

        expect(window.localStorage.getItem('user')).toEqual({accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXJ0IiwiaWF0IjoxNjczMjEwMDM3LCJleHAiOjE2NzMyMTY0Mzd9.V2M_o0UX448yuRJBJZjgz-crfL_Ye4Dr9PBfSie9e69TjCvqMoyWniDsRlBIoqjX5_VsSn_Y91aaYwkAWXI9vQ",
            email: "btynior@gmail.com",
            id: 1,
            roles: ['ROLE_ADMIN'],
            ship: null,
            tokenType: "Bearer",
            username: "bart"});
    });
});




