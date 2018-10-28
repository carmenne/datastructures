class Node{
    constructor(value) {
        this.value = value;
        this.next = null;
    }
    
}

class QueueArray {
    
    constructor() {
        this.items = [];
    }
    
    enqueue(value) {
        var newNode = new Node(value);
        
        const len = this.items.length;
        this.items[len] = newNode;
            
    }
    
    dequeue() {
        if (this.isEmpty()) {
            return null;
        }
    
        return this.items.shift().value;
    }
    
    front() {
        if (this.isEmpty()) {
            return null;
        }
        
        return this.items[0].value;
    }
    
    isEmpty() {
        return this.items.length == 0;
    }
    
    size() {
        return this.items.length;
    }
}

module.exports = QueueArray;

var queue = new QueueArray();
queue.enqueue(10);
queue.enqueue(11);
queue.enqueue(12);
    
console.log("Should be 3:", queue.size());
console.log("Should be 10:", queue.dequeue());
console.log("Should be 2:", queue.size());
console.log("Should be 11:", queue.front());
console.log("Should be 11:", queue.front());
