package main;
import logic.SuffixTree;
import node.Node;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "mississippi$";
		SuffixTree st = new SuffixTree();
		for(int i = 0; i < word.length(); i++) {
			System.out.println("Inserting " + (i + 1) + " suffix: " + word.substring(i));
			Node child = new Node();
			child.setPathLabel(word.substring(i));
			//child.setPathLabel(word.substring(i) + "$");
			child.setId(i + 1);
			st.insertOptimized(child);
		}
		st.printTree();
	}
}
