package logic;
import java.util.Scanner;

public class ReadWrite {

	public static void print(Integer[] input) {
		for(int i = 0; i < input.length; i++ ) {
			System.out.print(input[i] + " ");
		}
		
		System.out.println();
	}
	
	public static Integer[] readArray() {
		Scanner rdr = new Scanner(System.in);
		System.out.print("Enter the size: ");
		
		Integer[] input = new Integer[rdr.nextInt()];
		
		for(int i = 0; i < input.length; i++) {
			System.out.print((i + 1) + ": ");
			input[i] = rdr.nextInt();
		}
		
		return input;
	}
}
