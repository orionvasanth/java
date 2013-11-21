package logic;

public class Node {
	private Integer data = null;
	private Node leftChild = null;
	private Node rightChild = null;
	private Integer level = null;
	
	public Node(Integer data) {
		this.setData(data);
	}
	
	public Node() {
		
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

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
