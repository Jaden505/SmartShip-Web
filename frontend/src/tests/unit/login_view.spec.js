import Login from "@/components/Login";
import {createStore} from "vuex";
import {mount} from '@vue/test-utils'



describe('Login', () => {

    let wrapper

    // Create a mock store with the login module, user should be logged out
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

    // Mount the Login component with the mock store
    beforeEach(() => {
        wrapper = mount(Login, {
            global: {
                plugins: [store]
            }
        })
    });

    it('renders correct login page', () => {
        // Check that the login page is rendered
        expect(wrapper.exists()).toBe(true)

        // Check that the wrapper is rendered and has the correct amount of elements
        expect(wrapper.element.children.length,
            `login page starting with ${wrapper.element.tagName} has no child elements`)
            .toBeGreaterThan(0);

        // Check that the initial message is rendered, should be empty string
        expect(wrapper.html(),
            'The header did not render the message')
            .toContain(wrapper.vm.message);
    });

    it('should render correct contents', () => {
        const title = wrapper.find('h2').text()
        const password = wrapper.find('#password').text()
        const username = wrapper.find('#username').text()
        const loginButton = wrapper.find('button').text()

        // Check that the login page contains the correct elements
        expect(title).toEqual('Welcome to SmartShip Dashboard')
        expect(password).toEqual('Password')
        expect(username).toEqual('Your username')
        expect(loginButton).toEqual('Sign In')
    });

    it('should display the correct message', async() => {
        // Check if the page contains the sign in button
        const button = wrapper.find('button')
        // Simulate a click on the button
        button.trigger('click')
        // Wait for the promise to resolve
        setTimeout(() => {
            // Check that the message is updated
            expect(wrapper.vm.message).toEqual('Network Error')
        }, 4000)
    });

});