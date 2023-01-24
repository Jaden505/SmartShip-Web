import {mount, shallowMount} from "@vue/test-utils";
import PieChart from "@/components/charts/PieChart";

describe('PieChartComponent', () => {

    let wrapper;

    beforeEach(function () {
        wrapper = shallowMount(PieChart);
    })

    it('wrapper exists', function () {
        expect(wrapper.exists()).toBe(true)
    })

    it('check children structure', function () {
        expect(wrapper.element.children.length,
            `main page starting with ${wrapper.element.tagName} has no child elements`).toBe(1)
    })

    it('check if the PieChart component exists', function (){
        expect(wrapper.findComponent({ name: "PieChart" }).exists()).toBe(true)
    })

    it('initial array should be empty', function (){
        expect(wrapper.vm.data_points.length,
            'data_points is not the right type').toBe(0)
    })

})
