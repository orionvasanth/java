package logic;
import java.util.*;

public class Infix {
	
	private Hashtable<Character, Integer> prcdnc = new Hashtable<Character, Integer>();
	
	public Infix() {
		
		prcdnc.put('^', 3);
		prcdnc.put('/', 2);
		prcdnc.put('*', 2);
		prcdnc.put('+', 1);
		prcdnc.put('-', 1);
		prcdnc.put('(', 0);
		prcdnc.put(')', -1);
	}	
	
	public StringBuffer convertToPostfix(String exp) {
		char[] symbols = exp.toCharArray();
		
		Stack<Symbol> oprStk = new Stack<Symbol>();
		StringBuffer result = new StringBuffer("");
		
		for(char symbol : symbols) {
			if(Character.isLetterOrDigit(symbol)) {
				result.append(symbol);				
			} else {
				while(!oprStk.isEmpty() && oprStk.peek().value > prcdnc.get(symbol)) {
					if(!oprStk.peek().symbol.equals('('))
						result.append(oprStk.pop().symbol);
					else {
						oprStk.pop();
						if(new Character(symbol).equals(')'))
							break;
					}
				}
				
				if(!new Character(symbol).equals(')'))
					oprStk.push(new Symbol(symbol, prcdnc.get(symbol)));
			}
		}
		
		while(!oprStk.isEmpty()) {
			result.append(oprStk.pop().symbol);
		}
		
		System.out.println("Post-fix equivalent of the Infix expression: " + result);
		
		return result;
	}

	public void convertToPrefix(String expr) {
		
	}

}
