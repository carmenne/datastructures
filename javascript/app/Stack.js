class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    constructor() {
        this.root = null;
        this.size = 0;
    }

    push(value) {
        var newNode = new Node(value);
        this.size += 1;
               
        if (null != this.root) {
            newNode.next = this.root;
        }
        
        this.root = newNode;
    }
        
    pop() {
        if (this.isEmpty()) {
            return null;
        }

        this.size -= 1;
        var node = this.root;
        this.root = this.root.next;
        return node.value;
    }
    
    peek() {
        if (this.isEmpty()) {
            return null;
        }
        
        return this.root.value;       
    }
    
    isEmpty() {
        return this.size == 0;
    }
    
    clear() {
        this.root = null;
        this.size = 0;
    }
        
    print() {
        console.log(stack);
    }
}

module.exports = Stack;
