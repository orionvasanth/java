package node;

public class Node {
	
	private Node leftChild = null;
	private Integer data = 0;
	private Node rightChild = null;
	private Node inSuccessor = null;
	

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getInSuccessor() {
		return inSuccessor;
	}

	public void setInSuccessor(Node inSuccessor) {
		this.inSuccessor = inSuccessor;
	}
	
}
