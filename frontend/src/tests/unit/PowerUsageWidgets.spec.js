import {mount, RouterLinkStub, RouterViewStub, shallowMount} from '@vue/test-utils'
import {createStore} from 'vuex'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';
import PowerUsage from "@/components/pages/PowerUsage";
import Dashboard from "@/components/pages/Dashboard";

describe('PowerUsage Widgets', () => {
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

        wrapper = shallowMount(PowerUsage, {
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

    it('edit button should exists', () => {
        // Check if the component is mounted
        expect(wrapper.exists()).toBe(true);

        // Check if edit button exists
        expect(wrapper.find('#edit-button').exists()).toBe(true);
    });

    it('by default all 3 charts should be displayed', () => {
        // Check if the component is mounted
        expect(wrapper.exists()).toBe(true);

        // Charts holder should be visible
        expect(wrapper.find('#charts-holder').exists()).toBe(true);

        // Check if the chart holder has the correct amount of charts
        expect(wrapper.find('#charts-holder').element.children.length, `power usage page doesn't have all charts shown by default`).toBe(3);
    });
})
