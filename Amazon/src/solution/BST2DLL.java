package solution;

import java.util.Stack;

class DLLNode {
    int value;
    DLLNode previous;
    DLLNode next;
    public DLLNode(int v){
        this.value = v;
        this.previous = null;
        this.next = null;
    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
}

public class BST2DLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static DLLNode iterativeInorderWalk(TreeNode root) {		
		TreeNode node = root;
		if(node == null)
			return null;
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		DLLNode head = null, tail = null;
		while(!nodeStack.isEmpty() || node != null){
			if(node != null){
				nodeStack.push(node);
				node = node.left;
			}else{
				node = nodeStack.pop();
				DLLNode x = new DLLNode(node.value);
				if(head == null) {
					head = x;
					tail = head;
				} else {					
					x.previous = tail;
					tail.next = x;
					tail = tail.next;
				}
				node = node.right;
			}
		}
		
		return head;
	}

}
