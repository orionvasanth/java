package main;
import logic.*;
import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		Integer[] input = {15, 6, 18, 3, 8, 17, 20, 2, 4, 7, 13, 9, 12};
		bst.insert(input);
		System.out.println("Inorder: ");
		bst.recursiveInorderWalk(bst.getRoot());
		System.out.println();
		bst.iterativeInorderWalk(bst.getRoot());
		System.out.println();
		System.out.println("Preorder: ");
		bst.recursivePreorderWalk(bst.getRoot());
		System.out.println();
		bst.iterativePreorderWalk(bst.getRoot());
		System.out.println();
		System.out.println("Postorder: ");
		bst.recursivePostorderWalk(bst.getRoot());
		System.out.println();
		bst.iterativePostorderWalk(bst.getRoot());		
		System.out.println();
		System.out.println("Breadth first search: ");
		bst.BreadthFirstSearch(bst.getRoot());
		System.out.println();
		System.out.println("Print by level: ");
		bst.printByLevel(bst.getRoot());	
		System.out.println();
		System.out.println("Size: " + bst.recursiveSize(bst.getRoot()) + ", " + bst.iterativeSize(bst.getRoot()));
		System.out.println();
		System.out.println(bst.isBalanced(bst.getRoot()));
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(Integer element : input) {
			list.addLast(element);
		}
		
		BinaryTree bt = new BinaryTree();
		bt.constructFromDLL(list);
		
		bst.printByLevel(bt.getRoot());
		System.out.println();
		System.out.println("The Binary tree is a BST? " + bst.isBST(bt.getRoot()));
		
		System.out.println(bst.getLCA(new Node(8), new Node(2)).getData());
	}
}
