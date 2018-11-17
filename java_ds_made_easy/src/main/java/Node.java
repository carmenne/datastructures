class Node {
    int data;
    Node left, right;
    State state;

    Node(int item) {
        this(item, State.NEW);
    }

    Node(int item, State value) {
        data = item;
        state = value;
    }

    void print() {
        System.out.printf("n=%d ", data);
    }
}
