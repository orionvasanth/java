package structure;

public class TreeNode extends Node {

	private TreeNode leftChild;
	private TreeNode rightChild;
	private TreeNode parent;
	
	public TreeNode(Integer data){
		super(data);
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Boolean isLeaf(){
		if(leftChild == null && rightChild == null)
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}
}
