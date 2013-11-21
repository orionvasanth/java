package logic;
import java.util.LinkedList;

public class Queue {
	private LinkedList<Node> list = new LinkedList<Node>();
	
	public void enqueue(Node x) {
		list.addLast(x);
	}
	
	public Node dequeue() {
		return list.removeFirst();
	}
	
	public Node peek() {
		return list.peekFirst();
	}
	
	public Boolean isEmpty() {
		return list.isEmpty();
	}
}
