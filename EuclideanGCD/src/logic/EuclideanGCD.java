package logic;

public class EuclideanGCD {
	
	public static Integer GCD(Integer x, Integer y) {
		
		if(x == y)
			return x;
		
		if(x > y)
			return GCD(x - y, y);
		else
			return GCD(y - x, x);
	}

}
