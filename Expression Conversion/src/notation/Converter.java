/**
 * 
 */
package notation;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Vasanth Kumar Vadivelu(vavadive)
 * 
 */
public class Converter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] infix = { '4', '$', '2', '*', '3', '-', '3', '+', '8', '/', '4',
				'/', '(', '1', '+', '1', ')' };
		char[] prefix = convertInfixtoPrefix(infix);
		System.out.println();
		for (int i = 0; i < prefix.length; i++)
			if (prefix[i] != '\u0000')
				System.out.print(prefix[i] + " ");
		char[] postfix = convertInfixtoPostfix(infix);
		System.out.println();
		for (int i = 0; i < postfix.length; i++)
			System.out.print(postfix[i] + " ");
		System.out.println();
		System.out.println(convertPostfixtoPrefix(postfix));
		System.out.println(convertPostfixtoInfix(postfix));
		System.out.println(convertPrefixtoInfix(prefix));
		System.out.println(convertPrefixtoPostfix(prefix));
	}

	public static HashMap<Character, Integer> precedence = new HashMap<Character, Integer>();

	static {
		precedence.put('(', 0);
		precedence.put('$', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('+', 3);
		precedence.put('-', 3);
		precedence.put(')', 4);
	}

	public static char[] convertInfixtoPrefix(char[] input) {
		char[] reversed = new char[input.length];
		char[] prefix = new char[input.length];

		for (int i = input.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = input[i];
		}
		Stack<Character> opndStack = new Stack<Character>();
		int j = reversed.length - 1;
		for (int i = 0; i < reversed.length; i++) {
			if (Character.isLetterOrDigit(reversed[i])) {
				prefix[j] = reversed[i];
				j--;
				continue;
			} else {
				// operand
				if (reversed[i] == '(') {
					while (!(opndStack.peek() == ')')) {
						prefix[j] = opndStack.pop();
						j--;
					}
					opndStack.pop();
					continue;
				} else {
					if (opndStack.isEmpty())
						opndStack.push(reversed[i]);
					else {
						while (!opndStack.isEmpty()
								&& precedence.get(opndStack.peek()) < precedence
										.get(reversed[i])) {
							prefix[j] = opndStack.pop();
							j--;
						}
						opndStack.push(reversed[i]);
					}
				}
			}
		}
		while (!opndStack.isEmpty()) {
			prefix[j] = opndStack.pop();
			j--;
		}
		return prefix;
	}

	public static char[] convertInfixtoPostfix(char[] input) {
		Stack<Character> opndStack = new Stack<Character>();
		char[] postfix = new char[input.length];
		int j = 0;
		for (int i = 0; i < input.length; i++) {
			if (Character.isLetterOrDigit(input[i])) {
				postfix[j] = input[i];
				j++;
			} else {
				if (input[i] == ')') {
					while (!opndStack.isEmpty() && opndStack.peek() != '(') {
						postfix[j] = opndStack.pop();
						j++;
					}
					opndStack.pop();
				} else {
					if (opndStack.isEmpty() || opndStack.peek() == '(')
						opndStack.push(input[i]);
					else {
						while (!opndStack.isEmpty()
								&& precedence.get(opndStack.peek()) <= precedence
										.get(input[i])) {
							postfix[j] = opndStack.pop();
							j++;
						}
						opndStack.push(input[i]);
					}
				}
			}
		}
		while (!opndStack.isEmpty()) {
			postfix[j] = opndStack.pop();
			j++;
		}
		return postfix;
	}

	public static StringBuilder convertPostfixtoPrefix(char[] postfix) {
		Stack<StringBuilder> exprStack = new Stack<StringBuilder>();
		for (int i = 0; i < postfix.length; i++) {
			if (postfix[i] == '\u0000')
				break;
			if (Character.isLetterOrDigit(postfix[i])) {
				exprStack.push(new StringBuilder(postfix[i] + " "));
			} else {
				StringBuilder right = exprStack.pop();
				StringBuilder left = exprStack.pop();
				exprStack.push(new StringBuilder(postfix[i] + " ").append(left)
						.append(right));
			}
		}
		return exprStack.pop();
	}

	public static StringBuilder convertPostfixtoInfix(char[] postfix) {
		Stack<StringBuilder> exprStack = new Stack<StringBuilder>();
		for (int i = 0; i < postfix.length; i++) {
			if (postfix[i] == '\u0000')
				break;
			if (Character.isLetterOrDigit(postfix[i])) {
				exprStack.push(new StringBuilder(postfix[i] + " "));
			} else {
				StringBuilder right = exprStack.pop();
				StringBuilder left = exprStack.pop();
				exprStack.push(left.append(new StringBuilder(postfix[i] + " ")
						.append(right)));
			}
		}
		return exprStack.pop();
	}

	public static StringBuilder convertPrefixtoInfix(char[] prefix) {
		Stack<StringBuilder> exprStack = new Stack<StringBuilder>();
		for(int i = prefix.length - 1; i >= 0; i--){
			if(prefix[i] == '\u0000')
				continue;
			if(Character.isLetterOrDigit(prefix[i]))
				exprStack.push(new StringBuilder(prefix[i] + " "));
			else
			{
				StringBuilder left = exprStack.pop();
				StringBuilder right = exprStack.pop();				
				exprStack.push(left.append(new StringBuilder(prefix[i] + " ")).append(right));
			}
		}
		
		return exprStack.pop();
	}
	
	public static StringBuilder convertPrefixtoPostfix(char[] prefix){
		Stack<StringBuilder> exprStack = new Stack<StringBuilder>();
		for(int i = prefix.length - 1; i >= 0; i--){
			if(prefix[i] == '\u0000')
				continue;
			if(Character.isLetterOrDigit(prefix[i]))
				exprStack.push(new StringBuilder(prefix[i] + " "));
			else
			{
				StringBuilder left = exprStack.pop();
				StringBuilder right = exprStack.pop();				
				exprStack.push(left.append(right).append(new StringBuilder(prefix[i] + " ")));
			}
		}
		
		return exprStack.pop();
	}
}
