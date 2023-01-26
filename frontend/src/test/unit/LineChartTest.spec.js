import {mount, shallowMount} from "@vue/test-utils";
import LineChart from "@/components/charts/LineChart";

describe('LineChartComponent', () => {

    let wrapper;

    beforeEach(function () {
        wrapper = shallowMount(LineChart);
    })

    it('wrapper exists', function () {
        expect(wrapper.exists()).toBe(true)
    })

    it('check if the LineChart component exists', function (){
        expect(wrapper.findComponent({ name: "LineChart" }).exists()).toBe(true)
    })

    it('check min_data_points', function (){
        expect(wrapper.vm.min_data_points,
            'property min_data_points does not exists').toBe(4)
    })

})
