package geeksforgeeks.set21;

import java.util.Arrays;

public class MaximumLengthChainofPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }
		Pair[] input = new Pair[5];
		input[0] = new Pair(5, 24);
		input[1] = new Pair(39, 60);
		input[2] = new Pair(15, 228);
		input[3] = new Pair(27, 40);
		input[4] = new Pair(50, 90);

		System.out
				.println(new MaximumLengthChainofPairs().findMaxLength(input));
	}

	public int findMaxLength(Pair[] input) {
		dp = new int[input.length];
		Arrays.fill(dp, 0);
		dp[0] = 1;

		findMax(input);
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	private int[] dp;

	private void findMax(Pair[] input) {
		for (int i = 0; i < input.length; i++) {
			dp[i] = findLast(input, i) + 1;
		}
	}

	private int findLast(Pair[] input, int index) {
		int max = 0;
		for (int i = 0; i < index; i++) {
			if (input[i].b < input[index].a)
				max = Math.max(max, dp[i]);
		}
		return max;
	}

}

class Pair {
	public int a;
	public int b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}