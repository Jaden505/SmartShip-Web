import Login from "@/components/Login";
import {flushPromises, mount} from "@vue/test-utils";
import {createStore} from "vuex";


describe('Login', () => {

    let wrapper

    const store = createStore({
        modules: {
            auth: {
                state() {
                    return {
                        status: {
                            loggedIn: false
                        },
                        user: null
                    }
                }
            }
        },
    })

    beforeEach(() => {
        wrapper = mount(Login, {
            global: {
                plugins: [store]
            }
        })
    });

    it('renders correct login page', () => {
        expect(wrapper.exists()).toBe(true)

        expect(wrapper.element.children.length,
            `login page starting with ${wrapper.element.tagName} has no child elements`)
            .toBeGreaterThan(0);

        expect(wrapper.html(),
            'The header did not render the message')
            .toContain(wrapper.vm.message);
    });

    it('should render correct contents', () => {
        expect(wrapper.find('h2').text()).toEqual('Welcome to SmartShip Dashboard')

        expect(wrapper.find('#password').text()).toEqual('Password')
        expect(wrapper.find('#username').text()).toEqual('Your username')

        expect(wrapper.find('button').text()).toEqual('Sign In')
    });

    it('should display the correct message', async() => {
        const button = wrapper.find('button')
        button.trigger('click')
        setTimeout(() => {
            expect(wrapper.vm.message).toEqual('Network Error')
        }, 4000)
    });

});