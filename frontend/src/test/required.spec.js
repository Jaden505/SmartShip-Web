import { shallowMount } from "@vue/test-utils";
import UpdateAlarms from "@/components/ship/updateAlarms";

describe("UpdateAlarms.vue", () => {
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(UpdateAlarms);
    });

    it("should have required input fields", () => {
        expect(wrapper.find("[name='valueSinceLastUpdate']").attributes().required).toBe("required");
    });

    //DIT IS FOUT !!
});