import authService from "@/services/auth.service";
import axios from "axios";

describe("Auth Service", () => {

    // Mock the user credentials for signing in
    const signInCredentials = {
        username: "Raihan",
        password: "12345"
    }

    // Mock the user information for the logged in user
    const signedInUser = {
        id: 2,
        username: "Raihan",
        email: "raihan@gmail.com",
        roles: ["ROLE_ADMIN"],
        ship: "07202515-a483-464c-b704-5671f104044b",
        accessToken: "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSYWloYW4iLCJpYXQiOjE2NzM4MTg3MTgsImV4cCI6MTY3MzgyNTExOH0.JHufhDBkNzntK1MyhvV4npBM7iQ_-G0BYpSvH3ACRNd9RVyRppMhjmBevqvU3XTlIRyELhy3hackEMiFuQko2g",
        tokenType: "Bearer"
    }

    // Mock the local storage for this test, by default is user empty and so not logged in
    global.localStorage = {
        state: { 'user': null },
        setItem(key, item) {
            this.state[key] = item
        },
        getItem(key) {
            return this.state[key]
        },
        remoteItem(key) {
            delete this.state[key]
        },
        getAll() {
            return this.state
        }
    }

    it("should sign in user with the given credentials", async () => {

        // Mock the axios post method to return the user information
        jest.spyOn(axios, 'post').mockResolvedValue({
            data: signedInUser
        })

        // Check if the sign in method return a user object
        await expect(authService.login(signInCredentials), 'the response is not correct').resolves.toEqual(signedInUser)

        // Check if the request has been made
        expect(axios.post, 'the post request havent been called').toHaveBeenCalledTimes(1)

        // Check if the user object is stored in the local storage
        expect(global.localStorage.getItem('user'), 'the local storage is empty').toEqual(JSON.stringify(signedInUser))

    })

    it("should sign out user", async () => {
        // Call the sign out method
        authService.logout();

        // Check if the user object is removed from the local storage and the user is null
        expect(global.localStorage.getItem('user'), 'the local storage hasnt been removed').toBeNull()
    })

});
