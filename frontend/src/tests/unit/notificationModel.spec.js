import {Notification} from "@/models/notification";
// instances for testing
let author;

beforeEach(function() {
    author = new Notification("Wind","Wind Speed",112,3001,new Date(),"This is a message", "m/s");
})

describe('Notification Model', () => {
    it('Checks if a Notification is properly build', function() {
        expect(author.parameter).not.toBeNull();
        expect((author.parameter).length).toBeGreaterThan(0)

        expect(author.category).not.toBeNull();
        expect((author.category).length).toBeGreaterThan(0)

        expect(author.value).not.toBeNull();
        expect(author.value).not.toEqual(0)

        expect(author.shipId).not.toBeNull();
        expect(author.shipId).not.toEqual(0)

        expect(author.date).not.toBeNull();
        expect(author.date).not.toEqual(0)

        expect(author.message).not.toBeNull();
        expect((author.message).length).toBeGreaterThan(0)

        expect(author.unit).not.toBeNull();
        expect((author.unit).length).toBeGreaterThan(0)
    });
})
