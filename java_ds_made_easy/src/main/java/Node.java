class Node {
    int data;
    Node left, right;
    State state;

    Node(int item) {
        data = item;
    }

    Node(int item, State value) {
        this(item);
        state = value;
    }

    void print() {
        System.out.printf("n=%d ", data);
    }
}
