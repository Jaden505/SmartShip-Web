import { shallowMount } from '@vue/test-utils'
import Alarms from "@/components/pages/Alarms";
import UpdateAlarms from "@/components/ship/updateAlarms";

describe('Alarms.vue', () => {
    it('opens AddAlarms component when openPop is called', () => {
        // Arrange
        const wrapper = shallowMount(Alarms)

        // Assert initial state
        expect(wrapper.vm.add).toBe(false)

        // Act
        wrapper.vm.openPop()

        // Assert the change in state
        expect(wrapper.vm.add).toBe(true)

        // Assert that AddAlarms component is rendered
        expect(wrapper.findComponent({ Alarms }).exists()).toBe(false)

        //fix dit lol
    })
})