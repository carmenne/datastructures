
import java.util.Stack;
/* Class containing left and right child of current
node and key value*/
class Node
{
    int key;
    boolean explored;
    Node left, right;

    public Node(int item)
    {
        key = item;
        explored = false;
        left = right = null;
    }

    boolean isExplored() {
        return explored;
    }


    void setExplored(boolean visited) {
        explored = visited;
    }
}

class BinaryTree
{
    Node root;

    // Constructors
    BinaryTree(int key)
    {
        root = new Node(key);
    }

    BinaryTree()
    {
        root = null;
    }

    void print() {
        pt(root);
    }

    void pt(Node node) {

        if (node == null) {
            return;
        }

        if (null != node.left)
            pt(node.left);

        System.out.printf("n=%d ", node.key);

        if (null != node.right)
            pt(node.right);
    }

    void print_st() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()) {

            Node node = stack.pop();
            System.out.printf("n=%d ", node.key);

            if (null != node.right)
                stack.push(node.right);

            if (null != node.left)
                stack.push(node.left);
        }

    }

    void print_st2() {
        Stack<Node> stack = new Stack<Node>();
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
        tree.print_st();
        System.out.println();
        tree.print_st2();

    }
}
