
import java.util.Stack;
/* Class containing left and right child of current
node and key value*/
class Node
{
    int key;
    boolean explored;
    Node left, right;

    Node(int item)
    {
        key = item;
    }

    boolean isExplored() {
        return explored;
    }

    void setExplored() {
        explored = true;
    }
}

class BinaryTree
{
    private Node root;

    void print() {
        printRecursive(root);
    }

    private void printRecursive(Node node) {

        if (node == null) {
            return;
        }

        if (null != node.left)
            printRecursive(node.left);

        System.out.printf("n=%d ", node.key);

        if (null != node.right)
            printRecursive(node.right);
    }


    void printIterative() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            Node node = stack.pop();

            if (node.explored) {
                System.out.printf("n=%d ", node.key);
            } else {

                if (null != node.right) {
                    stack.push(node.right);
                }

                node.explored = true;
                stack.push(node);

                if (null != node.left) {
                    stack.push(node.left);
                }

            }
        }
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.left.right.right = new Node(10);
        tree.root.right.left.left = new Node(11);
        tree.root.right.left.right = new Node(12);
        tree.root.right.right.left = new Node(13);
        tree.root.right.right.right = new Node(14);

        tree.print();
        System.out.println();
        tree.printIterative();

    }
}
