public class BinarySearchTree {

    Node root;

    Node insert(Node root, int data) {

        if (root == null) return new Node(data);

        if (data > root.data) {
            root.right = insert(root.right, data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        }

        return root;
    }


    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 6);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 8);

        InorderTraversal.printRecursive(tree.root);
        System.out.println();

        // 2 81 87 42 66 90 45
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = tree.insert(tree2.root, 2);
        tree2.insert(tree2.root, 81);
        tree2.insert(tree2.root, 87);
        tree2.insert(tree2.root, 42);
        tree2.insert(tree2.root, 66);
        tree2.insert(tree2.root, 90);
        tree2.insert(tree2.root, 45);
        InorderTraversal.printRecursive(tree2.root);
    }
}
