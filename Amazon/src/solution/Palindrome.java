package solution;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrom("casablanca"));
	}
	
	static int isPalindrom(String a) {

		if(a == null)
			return 0;
		a = a.toLowerCase();
		StringBuilder text = new StringBuilder("");
		
		for(int i = 0; i < a.length(); i++) {
			if(Character.isLetter(a.charAt(i)))
				text.append(a.charAt(i));
		}
		int rightBound = text.length() / 2;
		
		if(rightBound == 0)
			return 1;

		for(int i = 0; i < rightBound; i++){
			if(text.charAt(i) != text.charAt(text.length() - i - 1))
				return 0;
		}
		return 1;

	}

}
