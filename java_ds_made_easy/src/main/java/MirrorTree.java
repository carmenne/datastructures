import java.util.LinkedList;

class MirrorTree {

    static void mirrorRecursive(Node node) {

        if (node == null) return;

        mirrorRecursive(node.left);
        mirrorRecursive(node.right);
        swap(node);

    }

    static void mirrorIterative(Node node) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            node = queue.remove();

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            swap(node);

        }
    }

    static void swap(Node node) {
        Node temp = node.right;
        node.right = node.left;
        node.left = temp;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.build();
        mirrorRecursive(binaryTree.root);
        InorderTraversal.printRecursive(binaryTree.root);
        System.out.println();
        binaryTree = BinaryTree.build();
        mirrorIterative(binaryTree.root);
        InorderTraversal.printRecursive(binaryTree.root);
        System.out.println();
        binaryTree = BinaryTree.build();

    }
}
