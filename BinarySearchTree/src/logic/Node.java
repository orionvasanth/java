package logic;

public class Node {
	
	private Node rightChild = null;
	private Node leftChild = null;
	private Integer data = null;
	private Boolean visitedLeft = false;
	private Boolean visitedRight = false;
	private Integer level = null;
	
	public boolean equals(Node x) {
		if(this.data == x.getData())
			return true;
		else 
			return false;
	}
	
	public Node() {
		
	}
	
	public Node(Integer data) {
		setData(data);
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public Integer getData() {
		return data;
	}
	
	public void setData(Integer data) {
		this.data = data;
	}

	public Boolean getVisitedLeft() {
		return visitedLeft;
	}

	public void setVisitedLeft(Boolean visitedLeft) {
		this.visitedLeft = visitedLeft;
	}

	public Boolean getVisitedRight() {
		return visitedRight;
	}

	public void setVisitedRight(Boolean visitedRight) {
		this.visitedRight = visitedRight;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
