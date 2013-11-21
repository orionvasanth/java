package tree;
import node.Node;

public class BinaryTree {

	private Node root = null;
	private Node temp = null;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void setInSuccessor() {
		inOrder(root);
	}

	private void inOrder(Node u) {
		if(u.getLeftChild() != null)
			inOrder(u.getLeftChild());

		if(temp != null)
			temp.setInSuccessor(u);

		temp = u;

		if(u.getRightChild() != null) {
			inOrder(u.getRightChild());
		}
	}

}
