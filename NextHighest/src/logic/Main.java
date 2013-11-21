package logic;

public class Main {
	public static void main(String[] args) {
		Generator g = new Generator(54217);
		System.out.println(g.getNext());
		g.getAll();
	}
}
