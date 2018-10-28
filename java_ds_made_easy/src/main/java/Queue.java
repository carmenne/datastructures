import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Queue  implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(Queue.class);

    private int capacity, tail, size, head;

    private Object[] values;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.values = new Object[capacity];
    }

    public void enqueue(Object value) {

        if (size == capacity) {
            throw new IllegalStateException("Full Queue Exception");
        }

        this.values[this.tail] = value;
        this.size++;
        this.tail = (this.tail + 1) % this.capacity;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty Queue Exception");
        } else {
            this.size--;
            Object node = this.values[this.head];
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
        LOG.info("Queue implementation with circular array");

        Queue queue = new Queue(3);

        LOG.info("Queue size should be 0: {}", queue.getSize());
        LOG.info("Queue should be empty: {}", queue.isEmpty());

        LOG.info("If queue is empty, front should return null: {}", queue.front());

        try {
            LOG.info("If queue is empty, dequeue should return null: {}", queue.dequeue());
        } catch (IllegalStateException e) {
            LOG.error(e.getMessage());
        }

        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        LOG.info("Queue size should be 3: {}", queue.getSize());

        LOG.info("queue.front should return 10: {}", queue.front());
        LOG.info("queue.front should return 10: {}", queue.front());
        LOG.info("Queue size should be 3: {}", queue.getSize());

        LOG.info("queue.dequeue should return 10: {}", queue.dequeue());
        LOG.info("Queue size should be 2: {}", queue.getSize());

        queue.enqueue(13);
        LOG.info("Queue size should be 3: {}", queue.getSize());

        LOG.info("queue.front should return 11: {}", queue.front());
        LOG.info("Queue size should be 3: {}", queue.getSize());

        try {
            queue.enqueue(14);
        } catch (IllegalStateException e) {
            LOG.error(e.getMessage());
        }

        LOG.info("queue.front should return 11: {}", queue.front());
        LOG.info("Queue size should be 3: {}", queue.getSize());
    }

    @Override
    public void run(String... args) throws Exception {

    }
}





