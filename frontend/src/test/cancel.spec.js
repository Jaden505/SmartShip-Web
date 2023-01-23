
import { shallowMount } from '@vue/test-utils'
import UpdateAlarms from "@/components/ship/updateAlarms";

describe('updateAlarms.vue', () => {
    it('calls cancelForm when cancel button is clicked', () => {
        // Arrange
        const wrapper = shallowMount(UpdateAlarms);
        const cancelButton = wrapper.find('#cancel');
        const cancelFormSpy = jest.spyOn(wrapper.vm, 'cancelForm');

        // Act
        cancelButton.trigger('click');

        // Assert
        expect(cancelFormSpy).toHaveBeenCalled();
        cancelFormSpy.mockRestore();

        //just comment out the localstorage stuff in the updateAlarms since the localstorage is fetched from the token and this is just a frontend test anyways

    });
});