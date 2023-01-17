import authService from "@/services/auth.service";
import {flushPromises, mount} from "@vue/test-utils";
import axios from "axios";
import {createStore} from "vuex";

describe("Auth Service", () => {

    const signInCredentials = {
        username: "Raihan",
        password: "12345"
    }

    const signedInUser = {
        id: 2,
        username: "Raihan",
        email: "raihan@gmail.com",
        roles: ["ROLE_ADMIN"],
        ship: "07202515-a483-464c-b704-5671f104044b",
        accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSYWloYW4iLCJpYXQiOjE2NzM4MTg3MTgsImV4cCI6MTY3MzgyNTExOH0.JHufhDBkNzntK1MyhvV4npBM7iQ_-G0BYpSvH3ACRNd9RVyRppMhjmBevqvU3XTlIRyELhy3hackEMiFuQko2g",
        tokenType: "Bearer"
    }

    global.localStorage = {
        state: { 'user': null },
        setItem(key, item) {
            this.state[key] = item
        },
        getItem(key) {
            return this.state[key]
        },
        getAll() {
            return this.state
        }
    }

    it("should sign in user with the given credentials", async () => {

        jest.spyOn(axios, 'post').mockResolvedValue({
            data: {
                id: 2,
                username: "Raihan",
                email: "raihan@gmail.com",
                roles: ["ROLE_ADMIN"],
                ship: "07202515-a483-464c-b704-5671f104044b",
                accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSYWloYW4iLCJpYXQiOjE2NzM4MTg3MTgsImV4cCI6MTY3MzgyNTExOH0.JHufhDBkNzntK1MyhvV4npBM7iQ_-G0BYpSvH3ACRNd9RVyRppMhjmBevqvU3XTlIRyELhy3hackEMiFuQko2g",
                tokenType: "Bearer"
            }
        })

        // Check if the sign in method return a user object
        await expect(authService.login(signInCredentials)).resolves.toEqual(signedInUser)

        // Check if the request has been made
        expect(axios.post).toHaveBeenCalledTimes(1)

        // Check if the user object is stored in the local storage
        expect(global.localStorage.getItem('user')).toEqual(JSON.stringify(signedInUser))

    })

});
