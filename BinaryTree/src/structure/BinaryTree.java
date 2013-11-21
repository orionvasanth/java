package structure;

class DiameterofTree {
	TreeNode root;
	int width;
	
	public DiameterofTree() {
		root = null;
		width = 0;
	}
	
	public DiameterofTree(TreeNode node, int width){
		this.root = node;
		this.width = width;
	}
}

class DiameterwithHeightofTree {
	DiameterofTree diameter;
	int height;
	
	public DiameterwithHeightofTree() {
		diameter = new DiameterofTree();
		height = 0;
	}
	
	public DiameterwithHeightofTree(DiameterofTree diameter, int height){
		this.diameter = diameter;
		this.height = height;
	}
}

public class BinaryTree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public static Boolean isBalancedBinaryTree(BinaryTree bt){
		return isBalancedBinaryTree(bt.getRoot(), new Integer(0));
	}
	
	//O(n^2)
	public static Integer getDiameterByBruteForce(TreeNode node){
		
		if(node == null)
			return 0;
		
		Integer leftHeight = getHeight(node.getLeftChild());
		Integer rightHeight = getHeight(node.getRightChild());
		
		Integer longestPathThroughNode = leftHeight + rightHeight + 1;
		
		return Math.max(longestPathThroughNode.intValue(), 
				Math.max(getDiameterByBruteForce(node.getLeftChild()), getDiameterByBruteForce(node.getRightChild())));
	}
	
	public static DiameterwithHeightofTree getDiameterOptimized(TreeNode node){
		//max of the following
		//diameter of left subtree
		//diameter of right subtree
		//height of left + height of right + 1
		if(node == null) {
			return new DiameterwithHeightofTree();
		}
		
		DiameterwithHeightofTree left = getDiameterOptimized(node.getLeftChild());
		DiameterwithHeightofTree right = getDiameterOptimized(node.getRightChild());
		
		int width = left.height + right.height + 1;
		int height = Math.max(left.height, right.height) + 1;
		
		if(width > left.diameter.width) {
			if(width > right.diameter.width) {
				return new DiameterwithHeightofTree(new DiameterofTree(node, width), height);
			} else {
				return new DiameterwithHeightofTree(right.diameter, height);
			}
		} else {
			if(left.diameter.width > right.diameter.width)
				return new DiameterwithHeightofTree(left.diameter, height);
			else return new DiameterwithHeightofTree(right.diameter, height); 
		}
	}
	
	//O(n)
	private static Boolean isBalancedBinaryTree(TreeNode node, Integer treeHeight){
		
		Integer leftTreeHeight = new Integer(0);
		Integer rightTreeHeight = new Integer(0);
		
		Boolean isLeftBalanced = Boolean.FALSE;
		Boolean isRightBalanced =  Boolean.FALSE;
		
		if(node == null){
			treeHeight = new Integer(0);
			return true;
		}
		
		isLeftBalanced = isBalancedBinaryTree(node.getLeftChild(), leftTreeHeight);
		isRightBalanced = isBalancedBinaryTree(node.getRightChild(), rightTreeHeight);
		
		treeHeight = Math.max(leftTreeHeight.intValue(), rightTreeHeight.intValue()) + 1;
		
		if(Math.abs(leftTreeHeight.intValue() - rightTreeHeight.intValue()) > 1)
			return Boolean.FALSE;
		
		return isLeftBalanced && isRightBalanced;
	}
	
	public static Boolean isBSTUsingInorderTraversal(BinaryTree bt){
		return isBSTUsingInorderTraversal(bt.getRoot(), null);
	}
	
	private static Boolean isBSTUsingInorderTraversal(TreeNode node, TreeNode prevNode){
		if(node == null)
			return Boolean.TRUE;
		
		if(!isBSTUsingInorderTraversal(node.getLeftChild(), prevNode))
			return Boolean.FALSE;
		if(prevNode != null){
			if(node.getParent() == prevNode){
				//node is right child, prevNode is parent
				if(node.getData() <= prevNode.getData())
					return Boolean.FALSE;
			} else {
				if(prevNode.getParent() == node){
					//prevNode is left child, node is parent
					if(prevNode.getData() > node.getData())
						return Boolean.FALSE;
				}
			}
		}
		prevNode = node;
		if(!isBSTUsingInorderTraversal(node.getRightChild(), prevNode))
			return Boolean.FALSE;
		
		return Boolean.TRUE;
	}
	
	public static Boolean isBSTUsingMinMax(BinaryTree bt){
		return isBSTUsingMinMax(bt.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//T = O(n), S = O(n) if recursive stack space is included else O(1) 
	private static Boolean isBSTUsingMinMax(TreeNode node, Integer min, Integer max){
		if(node == null)
			return Boolean.TRUE;
		
		if(!(node.getData() >= min && node.getData() <= max))
			return Boolean.FALSE;
		
		if(!isBSTUsingMinMax(node.getLeftChild(), min, node.getData()))
			return Boolean.FALSE;
		
		if(!isBSTUsingMinMax(node.getRightChild(), node.getData() + 1, max))
			return Boolean.FALSE;
		
		return Boolean.TRUE;
	}
	
	public static Integer getHeight(BinaryTree bt){		
		return getHeight(bt.getRoot());
	}
	
	//O(n)
	private static Integer getHeight(TreeNode node){
		
		Integer leftTreeHeight = new Integer(0);
		Integer rightTreeHeight = new Integer(0);
		
		if(node == null)
			return 0;
		
		return Math.max(leftTreeHeight.intValue(), rightTreeHeight.intValue()) + 1;		
	}
	
	
}
