import {User} from "@/models/user";

describe('User', () => {

    // test data literals
    const user1_id = 3000;
    const user1_firstname = "John";

// instances for testing
    let user1, user2;

    beforeEach(function() {
        user1 = new User(user1_id, "Sample Address", "Sample City", "Sample Country", "Sample Date of Birth", user1_firstname, "male", "Sample Lastname", "Sample Nationality", "Sample Phone Number", "Sample Postal Code", "Sample Username", "Sample Email", "Sample Password", "Sample Role", 0);
        user2 = User.createSample(user1_id+1);
    });

    it('creates a proper sample user', function() {
        expect(user2.id,
            'user2 id was not set properly')
            .toBe(user1_id+1);
        expect(user2.firstname,
            'user2 firstname was not set properly')
            .toBeTruthy();
    })

    it('clones a proper copy', function() {
        let copy = User.copyConstructor(user2);
        expect(copy,
            'copy of user2 does not match original')
            .toStrictEqual(user2);
    })

    it('constructs a proper user', function() {
        expect(user1.id,
            'user1 id was not set properly')
            .toBe(user1_id);
        expect(user1.firstname,
            'user1 firstname was not set properly')
            .toBe(user1_firstname);
    })

});