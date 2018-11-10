import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

enum State {
    NEW,
    EXPLORING_LEFT,
    EXPLORING_RIGHT
}

class PreorderTraversal {

    static void printRecursive(Node node) {

        if (null == node) return;

        node.print();
        printRecursive(node.left);
        printRecursive(node.right);
    }

    static void printIterative(Node node) {

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {

            node = stack.peek();

            switch (node.state) {

                case NEW:
                    node.print();
                    node.state = State.EXPLORING_LEFT;
                    if (null != node.left)
                        stack.push(node.left);
                    break;

                case EXPLORING_LEFT:
                    node.state = State.EXPLORING_RIGHT;
                    if (null != node.right)
                        stack.push(node.right);
                    break;

                case EXPLORING_RIGHT:
                    stack.pop();
                    break;
            }

        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = BinaryTree.build();
        PreorderTraversal.printRecursive(binaryTree.root);
        System.out.println();
        PreorderTraversal.printIterative(binaryTree.root);
    }
}
