package logic;
import java.util.LinkedList;

public class BinaryTree {
	
	private Node root = null;
	
	private Node constructFromDLL(LinkedList<Integer> list, Integer size) {
		if(size > 0) {
			Node left = constructFromDLL(list, size / 2);
			Node root = new Node(list.removeFirst());
			root.setLeftChild(left);
			root.setRightChild(constructFromDLL(list, size - (size/2) - 1));
			
			return root;
		}		
		return null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void constructFromDLL(LinkedList<Integer> list) {
		root = constructFromDLL(list, list.size());
	}
}
