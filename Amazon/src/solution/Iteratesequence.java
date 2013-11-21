package solution;

import java.util.Vector;

public class Iteratesequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Integer>a = new Vector<Integer>();
		a.add(5);
		a.add(6);
		a.add(3);
		a.add(9);
		a.add(-1);
		System.out.println(iterateSequence(a, 4));
	}
	
	static int iterateSequence(Vector <Integer>a , int N) {
		
		int vectorSize = a.size();
		for(int j = 1; j <= N; j++){
			for(int i = 0; i < vectorSize - 1; i++) {
				Integer t = a.get(i);
				t = a.get(i + 1) - t;
				a.remove(i);
				a.add(i, t);
			}
			vectorSize--;
		}
		int sum = 0;
		for(int i = 0; i < vectorSize; i++){
			sum = sum + a.get(i);
		}
		
		return sum;
	}

}
