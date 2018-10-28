var Queue = require('../app/Queue.js');
var queue;

beforeEach(function(){
    queue = new Queue();
});

putInQueue = function() {
    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);
}

describe("Queue Data Structure", function() {

    describe("Queue construction", function() {
        it("Should create a queue", function() {
            expect(queue).not.toBe(undefined);
        });
    });
    
    describe("isEmpty()", function() {
        it("Should be empty", function() {
            expect(queue.isEmpty()).toBe(true);
            expect(queue.size()).toBe(0);
        });
    });
    
    describe("enqueue()", function() {
        it("Should be enqued", function(){
            putInQueue();
            expect(queue.isEmpty()).toBe(false);
            expect(queue.size()).toBe(3);
        });
    });
    
    describe("dequeue()", function() {
        it("Should return null if queue is empty", function() {
            expect(queue.dequeue()).toBe(null);
        });
        
        it("Should be dequeued", function() {
            putInQueue();
            expect(queue.dequeue()).toBe(10);
            expect(queue.size()).toBe(2);
            expect(queue.dequeue()).toBe(11);
            expect(queue.size()).toBe(1);
            expect(queue.dequeue()).toBe(12);
            expect(queue.size()).toBe(0);
        });
    });
    
    describe("front()", function() {
        it("Should return null if queue is empty", function() {
            expect(queue.front()).toBe(null);
        });
        
        it("Should be dequeued", function() {
            putInQueue();
            expect(queue.front()).toBe(10);
            expect(queue.size()).toBe(3);
        });
    });
    
    
});
