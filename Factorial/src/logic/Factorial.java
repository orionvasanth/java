package logic;

public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial f = new Factorial();
		System.out.println(f.factorial(5));
	}

	public Integer factorial(Integer n) {
		if(n == 0)
			return 1;
		else
			return n * factorial(n -1);
	}

}
