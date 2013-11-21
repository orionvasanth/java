package main;
import logic.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		LinkedList list = new LinkedList();
		list.insert(input);
		list.makeLoop(5);
		list.hasLoop(list.getHead());
	}

}
