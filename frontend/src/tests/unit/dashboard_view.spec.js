import {mount, RouterLinkStub, RouterViewStub, shallowMount} from '@vue/test-utils'
import {createStore} from 'vuex'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';
import Dashboard from "@/components/pages/Dashboard";

describe('Dashboard Page', () => {

    // Mock the user information for the logged in user
    const user = {
        id: 2,
        username: "Raihan",
        email: "raihan@gmail.com",
        roles: ["ROLE_ADMIN"],
        ship: "07202515-a483-464c-b704-5671f104044b",
        accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSYWloYW4iLCJpYXQiOjE2NzM4MTg3MTgsImV4cCI6MTY3MzgyNTExOH0.JHufhDBkNzntK1MyhvV4npBM7iQ_-G0BYpSvH3ACRNd9RVyRppMhjmBevqvU3XTlIRyELhy3hackEMiFuQko2g",
        tokenType: "Bearer"
    }

    // Mock the local storage for this test, with user and his/her information as the value
    global.localStorage = {
        state: {
            'user': user
        },
        setItem(key, item) {
            this.state[key] = item
        },
        getItem(key) {
            return this.state[key]
        }
    }

    let wrapper;

    // Create a store for the component to use and mock the getters and actions,
    // dashboard can be accessed only by logged in users and that's why we need to mock the loggedIn status
    const store = createStore({
        modules: {
            auth: {
                state() {
                    return {
                        status: {
                            loggedIn: true
                        },
                        user: user
                    }
                }
            }
        },
    })

    // Mount the component with the store and stubs and set the local storage item for the user
    beforeEach(() => {
        global.localStorage.setItem('user', JSON.stringify(user))

        wrapper = shallowMount(Dashboard, {
            global: {
                stubs: {
                    FontAwesomeIcon,
                    RouterLink: RouterLinkStub,
                    RouterView: RouterViewStub
                },
                plugins: [store]
            },
        });
    })

    it('should create a local storage mock', () => {
        // Arrange
        let userFromLocalStorage;
        let shipFromLocalStorage;

        // Act
        userFromLocalStorage = global.localStorage.getItem('user')
        shipFromLocalStorage = global.localStorage.getItem('ship')

        // Assert - ship item is not set in the local storage and it should be null
        expect(userFromLocalStorage).toBe(JSON.stringify(user))
        expect(shipFromLocalStorage).toBe(null)
    });

    it('creates a correct dashboard page structure', () => {
        // Check if the component is mounted
        expect(wrapper.exists()).toBe(true);

        // Check if the wrapper has the correct amount of children
        expect(wrapper.element.children.length, `dashboard page starting with ${wrapper.element.tagName} has no child elements!`).toBe(2);

        // Check if the tag name of the first component is correct
        expect(wrapper.element.children[0].tagName).toBe('SIDE-BAR-STUB');
    });

    it('should display the data from local storage', () => {
        // Arrange
        const username = wrapper.find('#username').text();
        const role = wrapper.find('#role').text();

        // Check if the username and role are correct based on the user information from the local storage
        expect(username).toBe('Raihan');
        expect(role).toBe('Admin');
    });


})



