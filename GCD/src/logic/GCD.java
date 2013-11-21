package logic;

public class GCD {
	
	public static void main(String[] args) {
		GCD gcd = new GCD();
		gcd.byBruteForce(96, 120);
		gcd.byEuclidMethod(96, 120);
		gcd.byDijkstraMethod(96, 120);
	}
	
	public void byBruteForce(Integer x, Integer y) {
		byBruteForce(x, y, y);
	}
	
	public void byBruteForce(Integer x, Integer y, Integer gcd) {
		if((x % gcd == 0) && (y % gcd == 0))
			System.out.println(gcd);
		else
			byBruteForce(x, y, gcd - 1);			
	}
	
	public void byEuclidMethod(Integer x, Integer y) {
		if(x > y) {
			Integer mod = x % y;
			if(mod == 0)
				System.out.println(y);
			else
				byEuclidMethod(y, mod);
		} else {
			Integer mod = y % x;
			if(mod == 0)
				System.out.println(x);
			else
				byEuclidMethod(x, mod);
		}
	}
	
	public void byDijkstraMethod(Integer x, Integer y) {
		if( x == y)
			System.out.println(x);
		else {
			if(x > y) {
				byDijkstraMethod(x - y, y);
			} else {
				byDijkstraMethod(y - x, x);
			}
		}
	}

}
