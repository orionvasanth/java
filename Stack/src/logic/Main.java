package logic;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Get minimum of a stack in O(1)
		//getMinimum();
		
		StackProblems sp = new StackProblems();
		Integer[] input = {9, 11, 8, 15, 16, 1, 7, 5, 4 };
		sp.push(input);
		sp.print();
		sp.reverse();
		sp.print();
		sp.sort();
		sp.print();
	}
	
	public static void getMinimum() {
		GetMinimum m = new GetMinimum();
		Integer[] input = {9, 11, 8, 15, 16, 1, 7, 5, 4 };
		m.push(input);
		Integer choice;
		do {
			choice = new Scanner(System.in).nextInt();
			switch(choice) {
			case 1:
				System.out.println("Popped element: " + m.pop());
				break;
			case 2:
				System.out.println("Min element: " + m.getMinimum());
				break;
			} 
		} while(choice != 3);		
	}

}
