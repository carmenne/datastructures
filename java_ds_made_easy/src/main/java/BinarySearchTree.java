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


    Node deleteNode(Node root, int key) {

        if (root.data == key) {

            // The node to be deleted is found

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node succ = findSuccessor(root.right);
                root.data = succ.data;
                root.right = deleteNode(root.right, succ.data);
            }

            return root;

        } else if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right,key);
        }

        return root;

    }

    private Node findSuccessor(Node node) {
        if (node.left == null) return node;
        return findSuccessor(node.left);
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

        tree2.deleteNode(tree2.root, 81);

        System.out.println();
        InorderTraversal.printRecursive(tree2.root);

        // Input: {87, 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27, 41, 27, 73, 37, 12, 69, 68, 30, 83, 31, 63, 24, 68, 36, 30, 3, 23, 59, 70}
        // Output: 3 12 16 22 23 24 27 28 30 31 36 37 41 50 59 60 63 64 68 69 73 78 83 87 91 93 94
    }
}
