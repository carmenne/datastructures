import java.util.*;

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

    public void InOrderTraversal() {
        inorder(root);
    }

    public void prinAllPathsToLeaves() {
        List<Integer> path = new ArrayList<>();
        path.add(root.data);
        toLeaf(root, path);
    }

    private void inorder(Node node) {

        if (node == null) return;

        inorder(node.left);
        node.print();
        inorder(node.right);
    }

    private void toLeaf(Node node, List<Integer> path) {

        if (null == node.left && null == node.right) {
            System.out.println(Arrays.toString(path.toArray()));
            return;
        }

        if (null != node.left) path.add(node.left.data);
        toLeaf(node.left, path);
        path.remove(path.size()-1);


        if (null != node.right) path.add(node.right.data);
        toLeaf(node.right, path);
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.build();
        tree.prinAllPathsToLeaves();
        System.out.println();
    }
}
