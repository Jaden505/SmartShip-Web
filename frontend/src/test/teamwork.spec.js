import { mount } from '@vue/test-utils'
import Alarms from "@/components/pages/Alarms";

jest.mock("@/services/alarm.service", () => {
    return {
        getAll: jest.fn().mockResolvedValue({ data: [{ id: 1, parameter: 'Temperature', category: 'Sea', settedUpValue: '20' }] }),
    }
});

describe('Alarms', () => {
    let wrapper;

    beforeEach(() => {
        wrapper = mount(Alarms);
    });

    test('get all alarms', async () => {
        // Arrange
        const expectedAlarms = [{ id: 1, parameter: 'Temperature', category: 'Sea', settedUpValue: '20' }];

        // Act
        await wrapper.vm.$nextTick();

        // Assert
        expect(wrapper.vm.alarms).toEqual(expectedAlarms);
    });
});



