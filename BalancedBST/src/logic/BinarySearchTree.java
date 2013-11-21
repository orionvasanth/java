package logic;
import java.util.LinkedList;

public class BinarySearchTree {
	
	private Node root = null;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void constructBSTFrmSortdLL(LinkedList<Integer> input) {
		setRoot(constructBSTFrmSortdLL(input, input.size()));
		printByLevel(getRoot());
	}
	
	public Node constructBSTFrmSortdLL(LinkedList<Integer> input, Integer n) {
		if(n <= 0)
			return null;
		
		Node left = constructBSTFrmSortdLL(input, n/2);
		Node root = new Node(input.removeFirst());
		root.setLeftChild(left);
		root.setRightChild(constructBSTFrmSortdLL(input, n - (n/2) - 1));
		
		return root;
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
}
