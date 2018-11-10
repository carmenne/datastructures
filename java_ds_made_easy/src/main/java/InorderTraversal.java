import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;

class InorderTraversal {

    static void printRecursive(Node node) {

        if (node == null) {
            return;
        }

        if (null != node.left)
            printRecursive(node.left);

        System.out.printf("n=%d ", node.data);

        if (null != node.right)
            printRecursive(node.right);
    }


    static void printIterative(Node node) {

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        Hashtable<Integer, Boolean> states = new Hashtable<>();
        states.put(node.data, false);

        while (!stack.isEmpty()) {

            node = stack.pop();
            boolean explored = states.get(node.data) != null && states.get(node.data);

            if (explored) {
                System.out.printf("n=%d ", node.data);
            } else {

                if (null != node.right) {
                    stack.push(node.right);
                }

                states.put(node.data, true);
                stack.push(node);

                if (null != node.left) {
                    stack.push(node.left);
                }

            }
        }
    }

    static void printIterative2(Node node) {

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        Hashtable<Integer, Integer> states = new Hashtable<>();
        states.put(node.data, 0);

        while (!stack.isEmpty()) {

            node = stack.peek();
            int explorations = null == states.get(node.data) ? 0 : states.get(node.data);
            if (explorations == 0) {
                if (null != node.left)
                    stack.push(node.left);

                states.put(node.data, 1);
            } else if (explorations == 1) {
                System.out.printf("n=%d ", node.data);

                if (null != node.right)
                    stack.push(node.right);

                states.put(node.data, 2);
            } else if (explorations == 2) {
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {

        BinaryTree binaryTree = BinaryTree.build();

        InorderTraversal.printRecursive(binaryTree.root);
        System.out.println();
        InorderTraversal.printIterative(binaryTree.root);
        System.out.println();
        InorderTraversal.printIterative2(binaryTree.root);

    }
}

