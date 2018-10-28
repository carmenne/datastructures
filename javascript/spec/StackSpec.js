var Stack = require('../app/Stack.js');
var stack;

beforeEach(function(){
	stack = new Stack();
});

function pushOnStack() {
	stack.push(10);
	stack.push(11);
	stack.push(12);
}

describe("Stack Data Structure", function() {

	describe("Stack data structure construction", function() {
		it("Should create a stack", function() {
			expect(stack).not.toBe(undefined);
		});
	});
	
	describe("isEmpty()", function() {
			
		it("Should be empty", function() {
			expect(stack.isEmpty()).toBe(true);
		});
		
		it("Should be able to call clear on an emty stack", function() {
			expect(stack.isEmpty()).toBe(true);
		});

	});
	
	
	describe("push()", function() {
		
		it("Should be able call push", function() {
			pushOnStack();
			expect(stack.size).toBe(3);
		});
		
		it("Should not be empty", function() {
			pushOnStack();
			expect(stack.isEmpty()).toBe(false);
		});

	});
	
	describe("pop()", function() {
		
		it("Should be able call pop and retrieve last element", function() {
			pushOnStack();
			expect(stack.pop()).toBe(12);
		});
		
		it("Should decrease stack size", function() {
			pushOnStack();
			stack.pop();
			expect(stack.size).toBe(2);
		});

	});
	
	describe("peek()", function() {
		
		it("Should be able call peek and retrieve last element", function() {
			pushOnStack();
			stack.pop();
			expect(stack.peek()).toBe(11);
		});
		
		it("Should have the same size", function() {
			pushOnStack();
			stack.peek()
			expect(stack.size).toBe(3);
		});

	});
	
	
})
