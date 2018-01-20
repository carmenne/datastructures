import static java.lang.Math.abs;
import static java.lang.Math.max;

public class BinarySearchTree<E extends Comparable<E>> {
	public class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {
		return findNode(root, val);
	}
	
	// Method #2.
	protected int depth(E val) {

		return depth(root, val, 0);
	}


	// Method #3.
	protected int height(E val) {

		int h = height(root, val);
		return h;
	}


	// Method #4.
	protected boolean isBalanced(Node n) {

		if (null == n) {
			return false;
		}

		if (null == findNode(n.value)) {
			return false;
		}

		if (n.leftChild == null) {

			if (n.rightChild == null) {
				return true;
			} else {
				return abs(-1 - height(n.rightChild.value)) <= 1;
			}
		}

		if (null == n.rightChild) {

			return abs(height(n.leftChild.value) - (-1)) <= 1;
		}

		int lefth = height(n.leftChild.value);
		int righth =  height(n.rightChild.value);
		return abs (lefth - righth) <= 1;

	}
	
	// Method #5. .
	public boolean isBalanced() {

		if (null == root) {
			return false;
		}

		Node node = root;
		boolean balanced = isBalanced(node);
		if (!balanced) {
			return false;
		}

		if (null == node.leftChild) {
			if (null == node.rightChild) {
				return balanced;
			} else {
				return isBalanced(node.rightChild);
			}

		} else {
			if (null == node.rightChild) {
				return isBalanced(node.leftChild);
			}

			boolean balancedLeft = isBalanced(node.leftChild);
			boolean balancedRight = isBalanced(node.rightChild);
			return balancedLeft && balancedRight;
		}
	}


	// <!-- Private methods -->
	private Node findNode(Node node, E val) {
		if (null == node || null == val) {
			return null;
		}

		if (null != node.value && node.value.equals(val)) {
			return node;
		}

		if (null != node.leftChild && val.compareTo(node.leftChild.value) <= 0) {
			return findNode(node.leftChild, val);
		}

		if (null != node.rightChild && val.compareTo(node.rightChild.value) >= 0) {
			return findNode(node.rightChild, val);
		}

		return null;
	}


	private int depth(Node node, E val, int depth) {
		if (null == node || val == null) {
			return -1;
		}

		if (null != node.value && node.value.equals(val)) {
			return depth;
		}

		if (null != node.leftChild && val.compareTo(node.leftChild.value) <= 0) {
			return depth(node.leftChild, val, ++depth);
		}

		if (null != node.rightChild && val.compareTo(node.rightChild.value) >= 0) {
			return depth(node.rightChild, val, ++depth);
		}

		return -1;

	}

	private int height(Node node, E val) {

		if (null == node || null == val) {
			return -1;
		}


		if (null != node.value && node.value.equals(val)) {
			return height(node, 0);
		}

		if (null != node.leftChild && val.compareTo(node.leftChild.value) <= 0) {
			return height(node.leftChild, val);
		}

		if (null != node.rightChild && val.compareTo(node.rightChild.value) >= 0) {
			return height(node.rightChild, val);
		}

		return -1;
	}

	private int height(Node node, int height) {

		if (null == node) {
			return height;
		}

		if (null == node.leftChild) {

			if (null == node.rightChild) {
				return height; // leaf
			}

			return height(node.rightChild, ++height);
		}

		if (null == node.rightChild) {
			return height(node.leftChild, ++height);
		}

		++height;
		return max(height(node.leftChild, height), height(node.rightChild, height));
	}

}
