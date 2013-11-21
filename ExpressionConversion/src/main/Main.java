package main;
import logic.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Infix ix = new Infix();
		Postfix.evaluate(ix.convertToPostfix("5^2*5"));
	}

}
