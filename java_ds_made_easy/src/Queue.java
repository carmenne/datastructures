import java.util.Arrays;

public class Queue {

    private int capacity, tail, size, head;

    private Object[] values;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.values = new Object[capacity];
    }

    public void enqueue(Object value) {

        if (size == capacity) {
            throw new IllegalArgumentException("Full Queue Exception");
        }

        this.values[this.tail] = value;
        this.size++;
        this.tail = (this.tail + 1) % this.capacity;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty Queue Exception");
        } else {
            this.size--;
            var node = this.values[this.head];
            this.head = (this.head + 1) % this.capacity;
            return node;
        }

    }

    public Object front() {
        if (isEmpty()) {
            return null;
        } else {
            return this.values[this.head];
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }


    public static void main(String[] args) {
        System.out.println("Queue implementation with circular array");

        var queue = new Queue(3);

        System.out.printf("Queue size should be 0: %d%n", queue.getSize());
        System.out.printf("Queue should be empty: %b%n", queue.isEmpty());

        System.out.printf("If queue is empty, front should return null: %s%n", queue.front());

        try {
            System.out.printf("If queue is empty, dequeue should return null: %s%n", queue.dequeue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        System.out.printf("Queue size should be 3: %d%n", queue.getSize());

        System.out.printf("queue.front should return 10: %s%n", queue.front());
        System.out.printf("queue.front should return 10: %s%n", queue.front());
        System.out.printf("Queue size should be 3: %d%n", queue.getSize());

        System.out.printf("queue.dequeue should return 10: %s%n", queue.dequeue());
        System.out.printf("Queue size should be 2: %d%n", queue.getSize());

        queue.enqueue(13);
        System.out.printf("Queue size should be 3: %d%n", queue.getSize());

        System.out.printf("queue.front should return 11: %s%n", queue.front());
        System.out.printf("Queue size should be 3: %d%n", queue.getSize());

        try {
            queue.enqueue(14);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("queue.front should return 11: %s%n", queue.front());
        System.out.printf("Queue size should be 3: %d%n", queue.getSize());
    }
}





