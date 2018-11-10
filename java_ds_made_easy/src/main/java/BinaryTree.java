import java.util.ArrayDeque;
import java.util.Deque;

class BinaryTree
{
    Node root;



    public static BinaryTree build()
    {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new Node(0, State.NEW);
        tree.root.left = new Node(1, State.NEW);
        tree.root.right = new Node(2, State.NEW);
        tree.root.left.left = new Node(3, State.NEW);
        tree.root.left.right = new Node(4, State.NEW);
        tree.root.right.left = new Node(5, State.NEW);
        tree.root.right.right = new Node(6, State.NEW);
        tree.root.left.left.left = new Node(7, State.NEW);
        tree.root.left.left.right = new Node(8, State.NEW);
        tree.root.left.right.left = new Node(9, State.NEW);
        tree.root.left.right.right = new Node(10, State.NEW);
        tree.root.right.left.left = new Node(11, State.NEW);
        tree.root.right.left.right = new Node(12, State.NEW);
        tree.root.right.right.left = new Node(13, State.NEW);
        tree.root.right.right.right = new Node(14, State.NEW);

        return tree;

    }
}
