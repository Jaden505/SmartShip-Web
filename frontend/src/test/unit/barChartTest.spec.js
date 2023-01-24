import BarChart from "@/components/charts/BarChart";
import {mount,  shallowMount} from "@vue/test-utils";


describe('BarChartComponent', () => {

    let wrapper;

    beforeEach(function () {
        wrapper = shallowMount(BarChart);
    })

    it('wrapper exists', function(){
        expect(wrapper.exists()).toBe(true)
    })

    it('check children structure', function() {
        expect(wrapper.element.children.length,
            `main page starting with ${wrapper.element.tagName} has no child elements`).toBe(1)
    })

    it('check if the BarChart component exists', function (){
        expect(wrapper.findComponent({ name: "BarChart" }).exists()).toBe(true)
    })

    it('check property lackData', () => {
        expect(wrapper.vm.lackData,
            `lackData isn't false`).toBeFalsy()
    })

});
