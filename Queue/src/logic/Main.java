package logic;

public class Main {
	public static void main(String[] args) {
		Queue q = new Queue();
		Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		q.enqueue(input);
		q.print();
		q.reverse();
		q.print();
		q.sort();
		q.print();
	}
}
