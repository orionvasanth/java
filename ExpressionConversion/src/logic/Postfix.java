package logic;
import java.util.*;

public class Postfix {
	
	private static Double getValue(Double opnd1, Double opnd2, Character oprtr) {
		
		if(oprtr.equals('+'))
			return opnd1 + opnd2;
		
		if(oprtr.equals('-'))
			return opnd1 - opnd2;

		if(oprtr.equals('*'))
			return opnd1 * opnd2;

		if(oprtr.equals('/'))
			return opnd1 / opnd2;

		if(oprtr.equals('^'))
			return Math.pow(opnd1, opnd2);
		
		return 0.0;
	}
	
	public static void evaluate(StringBuffer expr) {
		Stack<Double> result = new Stack<Double>();
		for(int i = 0; i < expr.length(); i++) {
			if(Character.isDigit(expr.charAt(i)))
				result.push(Double.valueOf(Character.digit(expr.charAt(i), 10)));
			else {
				Character oprtr = Character.valueOf(expr.charAt(i));
				Double opnd2 = result.pop();
				Double opnd1 = result.pop();
				result.push(getValue(opnd1, opnd2, oprtr));
			}
		}
		
		System.out.println("The result is " + result.peek());
	}
}
