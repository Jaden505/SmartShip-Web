import {mount, RouterLinkStub, RouterViewStub} from '@vue/test-utils'
import {createStore} from 'vuex'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';
import Dashboard from "@/components/pages/Dashboard";

describe('Dashboard Page', () => {

    const user = {
        id: 2,
        username: "Raihan",
        email: "raihan@gmail.com",
        roles: ["ROLE_ADMIN"],
        ship: "07202515-a483-464c-b704-5671f104044b",
        accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSYWloYW4iLCJpYXQiOjE2NzM4MTg3MTgsImV4cCI6MTY3MzgyNTExOH0.JHufhDBkNzntK1MyhvV4npBM7iQ_-G0BYpSvH3ACRNd9RVyRppMhjmBevqvU3XTlIRyELhy3hackEMiFuQko2g",
        tokenType: "Bearer"
    }

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

    global.localStorage.setItem('user', JSON.stringify(user))

    wrapper = mount(Dashboard, {
        global: {
            stubs: {
                FontAwesomeIcon,
                RouterLink: RouterLinkStub,
                RouterView: RouterViewStub
            },
            plugins: [store]
        },
    });

    it('should create a local storage mock', () => {
        expect(localStorage.getItem('user')).toBe(JSON.stringify(user))
    });

    it('creates a correct dashboard page structure', () => {
        expect(wrapper.exists()).toBe(true);

        expect(wrapper.element.children.length, `dashboard page starting with ${wrapper.element.tagName} has no child elements!`).toBe(2);

        expect(wrapper.element.children[0].tagName).toBe('ASIDE');
    });

    it('should display the data from local storage', () => {
        expect(wrapper.find('#username').text()).toBe('Raihan');
    });


})



