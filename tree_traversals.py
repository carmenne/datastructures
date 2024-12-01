class Node:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

# dfs recursive
def pre_order_recursive(node):
    """Recursive Depth-First Search (DFS) for a binary tree. Pre-order traversal"""
    if not node:
        return

    print(node.value, end="")

    pre_order_recursive(node.left)
    pre_order_recursive(node.right)

def in_order_recursive(root):
    if not root:
        return

    in_order_recursive(root.left)
    print(root.value, end="")
    in_order_recursive(root.right)

def post_order_recursive(root):

    if not root:
        return

    post_order_recursive(root.left)
    post_order_recursive(root.right)

    print(root.value, end="")

def level_order_recursive(root):

    if not root:
        return



def pre_order_iterative(root):
    """Iterative Depth-First Search (DFS) for a binary tree. Pre-order traversal"""
    stack = [root]
    while stack:

        node = stack.pop()
        print(node.value, end="")
        if node.right:
            stack.append(node.right) # 3
        if node.left:
            stack.append(node.left) # 3, 6

def in_order_iterative(root):
    """Iterative Depth-First Search (DFS) for a binary tree. In-order traversal"""
    stack = [root]
    node = root

    while stack:

        while node:
            if node.left:
                stack.append(node.left)
            node = node.left

        node = stack.pop()
        print(node.value, end="")
        if node.right:
            stack.append(node.right)
        node = node.right

def post_order_iterative(root):
    stack = [root]
    other = []

    while stack:
        node = stack.pop()
        other.append(node)

        if node.left:
            stack.append(node.left)
        if node.right:
            stack.append(node.right)

    while other:
        node = other.pop()
        print(node.value, end="")

def level_order_iterative(root):
    queue = [root]

    while queue:
        node = queue.pop(0)
        print(node.value, end="")

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)



if __name__ == "__main__":
    # Build a sample binary tree
    #        1
    #       / \
    #      2   3
    #     / \   \
    #    4   5   6
    root = Node(1, Node(2, Node(4), Node(5)), Node(3, None, Node(6)))


    print("Pre-order Recursive:")
    pre_order_recursive(root)

    print("\nPre-order Iterative:")
    pre_order_iterative(root)

    print("\nIn-order Recursive:")
    in_order_recursive(root)

    print("\nIn-order Iterative:")
    in_order_iterative(root)

    print("\nPost-order Recursive:")
    post_order_recursive(root)

    print("\nPost-order Iterative:")
    post_order_iterative(root)

    print("\nLevel-order Recursive:")
    level_order_recursive(root)

    print("\nLevel-order Iterative:")
    level_order_iterative(root)