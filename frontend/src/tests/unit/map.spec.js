import Map from '@/components/ship/Map.vue'
import {shallowMount} from "@vue/test-utils";
import {ShipDataService} from "@/services/ship.service";

let ShipService;

beforeEach(() => {
    ShipService = new ShipDataService();
    window.localStorage.setItem('user',
        JSON.stringify({
        accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXJ0IiwiaWF0IjoxNjczMjEwMDM3LCJleHAiOjE2NzMyMTY0Mzd9." +
            "V2M_o0UX448yuRJBJZjgz-crfL_Ye4Dr9PBfSie9e69TjCvqMoyWniDsRlBIoqjX5_VsSn_Y91aaYwkAWXI9vQ",
        email: "joli@gmail.com",
        id: 1,
        roles: ['ROLE_ADMIN'],
        ship: 3001,
        tokenType: "Bearer",
        username: "joli"}))
})

describe('Div map is rendered', () => {
    it('checks if the div of the map is rendered', () => {
        const wrapper = shallowMount(Map)
        expect(wrapper.find('div').exists()).toBe(true)
        expect(wrapper.find('div').isVisible()).toBe(true)
        expect(wrapper.find('div').attributes('id')).toBe('map')
        expect(wrapper.find('div').attributes('class')).toBe('map')
    })
})




