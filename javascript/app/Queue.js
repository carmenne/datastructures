class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.root = null;
        this.length = 0;
        this.tail = null;
    }
    
    enqueue_On(value) {
        var newNode = new Node(value);
        this.length += 1;
        
        if (null == this.root) {
            this.root = newNode;
        } else {
            var node = this.root;

            while (null != node.next) {
                node = node.next;
            }
            node.next = newNode;
        }
    }
    
    enqueue(value) {
        var newNode = new Node(value);
        this.length += 1;
        
        if (null == this.root) {
            this.root = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        
    }
    
    dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        
        this.length -= 1;
        var node = this.root;
        this.root = this.root.next;
        return node.value;
    }
    
    front() {
        if (this.isEmpty()) {
            return null;
        }
        
        return this.root.value;
        
    }
    
    size() {
        return this.length;
    }
    
    isEmpty() {
        return this.length == 0;
    }
}

module.exports = Queue;
