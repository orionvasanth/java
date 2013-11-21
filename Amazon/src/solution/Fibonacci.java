package solution;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNthFib(1));
		System.out.println(getNthFib(3));
		System.out.println(getNthFib(20));
	}
	
	static int getNthFib(int n) {
		if(n == 1)
			return 0;
		
		if(n == 2)
			return 1;
		
		return getNthFib(n - 1) + getNthFib(n - 2);
	}

}
