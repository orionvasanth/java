package logic;
import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> input = new LinkedList<Integer>();
		for(int i = 1; i < 8; i++) {
			input.add(i);
		}
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.constructBSTFrmSortdLL(input);
	}

}
