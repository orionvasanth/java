package logic;

import java.util.Scanner;


public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter principal: ");
		double principal = scanner.nextDouble();
		double annual_roi = 11d;
		double monthly_roi = annual_roi / 12 / 100;
		int years = 20;
		
		System.out.println("EMI per month: " + emi(principal, monthly_roi, years * 12));
		scanner.close();

	}
	
	public static double emi(double principal, double monthly_roi, int months){
		double part = Math.pow((1 + monthly_roi), months);
		double emi = principal * monthly_roi * part / (part - 1);
		return emi;
	}

}
