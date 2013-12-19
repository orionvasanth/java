package geeksforgeeks;

import java.util.Arrays;

public class MinimumNumberofJumps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumNumberofJumps jumps = new MinimumNumberofJumps();
		int[] input = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(jumps.getMinimumNumberofJumps(input));

	}

	private int[] dp;

	public int getMinimumNumberofJumps(int[] input) {
		dp = new int[input.length - 1];

		int end = input.length - 1;

		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = input.length - 2; i >= 0; i--) {
			if (i + input[i] >= end)
				dp[i] = 1; // can't be lesser than 1.
			else {
				int current = Integer.MAX_VALUE;
				for (int j = i + 1; j <= i + input[i]; j++) {
					current = Math.min(current, dp[j]);
				}
				dp[i] = current + 1;
			}
		}

		return dp[0];
	}

}
