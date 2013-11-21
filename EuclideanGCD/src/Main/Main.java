package Main;
import logic.EuclideanGCD;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x: ");
		Integer x = input.nextInt();
		System.out.print("Enter y: ");
		Integer y = input.nextInt();
		
		System.out.print(EuclideanGCD.GCD(x, y));
	}

}
