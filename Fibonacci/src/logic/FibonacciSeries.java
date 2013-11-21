package logic;

public class FibonacciSeries {

	/**
	 * @param args
	 */

	public Integer generate(Integer fi) {
		if(fi <= 1) 
			return fi;
		else
			return generate(fi - 1) + generate(fi - 2);
	}

	public void generate(Integer fx, Integer fr, Integer fq, Integer fp) {
		if(fr <= fx) {
			if(fr == 2) 
				System.out.print("0, 1, ");
			System.out.print(fp + fq);
			System.out.print(", ");
			generate(fx, fr + 1, fp + fq, fq);
		}			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciSeries fs = new FibonacciSeries();
		System.out.println(fs.generate(10));
		fs.generate(10, 2, 1, 0);
	}

}