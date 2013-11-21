package logic;
import java.util.Stack;
import java.util.LinkedList;

public class BinarySearchTree {
	private Node root = null;

	public BinarySearchTree() {

	}

	public void insert(Integer[] input) {
		for(Integer x : input)
			insert(new Node(x));
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(Node toAdd) {
		Node x = root, y = null;

		while( x != null) {
			y = x;
			if(toAdd.getData() < x.getData())
				x = x.getLeftChild();
			else
				x = x.getRightChild();
		}

		if(y == null)
			root = toAdd;
		else {
			if(toAdd.getData() < y.getData())
				y.setLeftChild(toAdd);
			else
				y.setRightChild(toAdd);
		}
	}

	public Node recursiveSearch(Node x, Integer data) {
		if(x == null || x.getData() == data)
			return x;		
		if(data < x.getData())
			return recursiveSearch(x.getLeftChild(), data);
		else
			return recursiveSearch(x.getRightChild(), data);
	}

	public Node iterativeSearch(Node x, Integer data) {

		while(x != null && x.getData() != data) {

			if(data < x.getData())
				x = x.getLeftChild();
			else
				x = x.getRightChild();
		}

		return x;
	}

	public void recursiveInorderWalk(Node x) {
		if(x != null) {
			if(x.getLeftChild() != null)
				recursiveInorderWalk(x.getLeftChild());

			System.out.print(x.getData() + " ");

			if(x.getRightChild() != null)
				recursiveInorderWalk(x.getRightChild());
		}
	}

	public void iterativeInorderWalk(Node root) {
		if(root != null) {
			Stack<Node> stk = new Stack<Node>();
			while(true) {
				while(root != null) {
					stk.push(root);
					root = root.getLeftChild();
				}

				if(stk.isEmpty())
					break;

				root = stk.pop();
				System.out.print(root.getData() + " ");
				root = root.getRightChild();
			}
		}
	}

	public void recursivePreorderWalk(Node x) {
		if(x != null) {
			System.out.print(x.getData() + " ");

			Node leftChild = x.getLeftChild();
			if(leftChild != null)
				recursivePreorderWalk(x.getLeftChild());

			Node rightChild = x.getRightChild();
			if(rightChild != null)
				recursivePreorderWalk(rightChild);
		}
	}

	public void iterativePreorderWalk(Node root) {
		if(root != null) {
			Stack<Node> stk = new Stack<Node>();
			while(true) {
				while(root != null) {
					System.out.print(root.getData() + " ");
					stk.push(root);
					root = root.getLeftChild();
				}

				if(stk.isEmpty())
					break;

				root = stk.pop();
				root = root.getRightChild();
			}
		}
	}

	public void recursivePostorderWalk(Node x) {
		if(x != null) {
			Node leftChild = x.getLeftChild();
			if(leftChild != null)
				recursivePostorderWalk(leftChild);

			Node rightChild = x.getRightChild();
			if(rightChild != null) 
				recursivePostorderWalk(rightChild);

			System.out.print(x.getData() + " ");
		}
	}

	public void iterativePostorderWalk(Node root) {
		if(root != null) {
			Stack<Node> stk = new Stack<Node>();
			while(true) {
				while(root != null) {
					stk.push(root);
					root.setVisitedLeft(true);
					root = root.getLeftChild();
				}

				if(stk.isEmpty())
					break;
				root = stk.pop();

				if(root.getVisitedRight()) {
					System.out.print(root.getData() + " ");
					root = null;
				}
				else {
					root.setVisitedRight(true);
					stk.push(root);
					root = root.getRightChild();
				}
			}
		}
	}

	public void BreadthFirstSearch(Node x) {
		Queue q = new Queue();
		q.enqueue(x);

		while(!q.isEmpty()) {
			x = q.dequeue();
			System.out.print(x.getData() + " ");

			Node leftChild = x.getLeftChild();
			if(leftChild != null)
				q.enqueue(leftChild);

			Node rightChild = x.getRightChild();
			if(rightChild != null)
				q.enqueue(rightChild);
		}
	}

	public void printByLevel(Node x) {
		Queue q = new Queue();
		x.setLevel(1);
		q.enqueue(x);
		Integer level = x.getLevel();

		while(!q.isEmpty()) {
			x = q.dequeue();
			if(x.getLevel() == level)
				System.out.print(x.getData() + "  ");
			else {
				System.out.println();
				System.out.print(x.getData() + "  ");
				level = x.getLevel();
			}

			Node leftChild = x.getLeftChild();
			if(leftChild != null) {
				leftChild.setLevel(x.getLevel() + 1);
				q.enqueue(leftChild);
			}

			Node rightChild = x.getRightChild();
			if(rightChild != null) {
				rightChild.setLevel(x.getLevel() + 1);
				q.enqueue(rightChild);
			}
		}
	}

	public  void DepthFirstSearch(Node x) {
		recursivePostorderWalk(x);
	}

	public Node getMinimum(Node x) {
		while(x.getRightChild() != null)
			x = x.getLeftChild();

		return x;
	}

	public Node getMaximum(Node x) {
		while(x.getRightChild() != null) 
			x = x.getRightChild();

		return x;
	}

	private Node getParent(Node x) {
		Node p = null, q = root;

		while(q != null && !q.equals(x)) {
			p = q;
			if(x.getData() < q.getData())
				q = q.getLeftChild();
			else q = q.getRightChild();
		}

		if( q!= null)
			return p;
		else return q;
	}

	private void transplant(Node z, Node v) {
		Node p = getParent(z);

		if(p == null)
			root = v;
		else
			if(p.getLeftChild() == z)
				p.setLeftChild(v);
			else
				p.setRightChild(v);
	}
	
	public Node getLCA(Node x, Node y) {
		return getLCA(root, x, y);
	}	
	
	private Node getLCA(Node root, Node x, Node y) {
		if(root == null)
			return root;
		
		if(root.equals(x) || root.equals(y))
			return root;
		
		Node left = getLCA(root.getLeftChild(), x, y);
		Node right = getLCA(root.getRightChild(), x, y);
		
		if(left != null && right != null)
			return root;
		else
			return (left != null ? left : right);
	}

	public Integer getHeight(Node x) {
		if(x == null)
			return 0;
		else 
			return Math.max(getHeight(x.getLeftChild()), getHeight(x.getRightChild())) + 1;
	}

	public Integer isBalanced(Node x) {
		if(x != null) {
			int leftHeight = isBalanced(x.getLeftChild());
			if(leftHeight == -1)
				return -1;
			
			int rightHeight = isBalanced(x.getRightChild());
			if(rightHeight == -1)
				return -1;
			else {
				if(leftHeight > rightHeight)
					if(leftHeight - rightHeight > 1)
						return -1;
					else
						return leftHeight + 1;
				else
					if(rightHeight - leftHeight > 1)
						return -1;
					else
						return rightHeight + 1;
			}
		}

		return 0;
	}

	public void delete(Integer data) {
		Node z = recursiveSearch(root, data);

		if(z.getLeftChild() == null) 
			transplant(z, z.getRightChild());
		else
			if(z.getRightChild() == null) 
				transplant(z, z.getLeftChild());
			else {			
				Node y = getMinimum(z.getRightChild());
				if(y != z.getRightChild())
					transplant(y, y.getRightChild());
				transplant(z, y);
			}
	}

	public Integer recursiveSize(Node root) {
		if(root != null) 
			return 1 + recursiveSize(root.getLeftChild()) + recursiveSize(root.getRightChild());
		else return 0;
	}

	public Integer iterativeSize(Node root) {
		Integer size = 0;
		if(root == null)
			return size;

		Queue q = new Queue();
		q.enqueue(root);
		while(!q.isEmpty()) {
			size++;
			root = q.dequeue();
			Node leftChild = root.getLeftChild();
			if(leftChild != null)
				q.enqueue(leftChild);

			Node rightChild = root.getRightChild();
			if(rightChild != null)
				q.enqueue(rightChild);
		}

		return size;
	}
	
	public Boolean isBST(Node x) {
		if(x != null)
			return isBST(x, Integer.MIN_VALUE, Integer.MAX_VALUE);		

		return true;
	}
	
	private Boolean isBST(Node x, Integer min, Integer max) {
		if( x!= null) {
			Node leftChild = x.getLeftChild();
			Integer data = x.getData();
			Boolean left, right;
			if(leftChild != null) {
				if(data > leftChild.getData())
					left = isBST(leftChild, min, data - 1);
				else
					return false;
			} else left = true;
			
			if(left) {
				Node rightChild = x.getRightChild();
				if(rightChild != null) {
					if(data <= rightChild.getData())
						right = isBST(rightChild, data, max);
					else
						return false;
				} else right = true;
			} else right = false;

			if(left && right)
				return true;
			else return false;

		}
		return true;
	}

	public void verticalSumInList(Node root) {//incomplete
		Stack<Node> stk = new Stack<Node>();
		LinkedList<Integer> sum = new LinkedList<Integer>();

		while(true) {
			while(root != null) {
				stk.push(root);
				root = root.getLeftChild();
				sum.addFirst(0); 
			}

			if(stk.isEmpty())
				break;
			else 
				root = stk.pop();

			System.out.print(root.getData() + "  ");
			root = root.getRightChild();
		}

	}
}
