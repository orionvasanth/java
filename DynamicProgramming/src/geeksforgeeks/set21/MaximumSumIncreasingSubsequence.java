package geeksforgeeks.set21;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println(new MaximumSumIncreasingSubsequence()
				.findMaximumSumIncreasingSubsequence(input));

	}

	private int[] dp;

	public int findMaximumSumIncreasingSubsequence(int[] input) {
		dp = new int[input.length];
		Arrays.fill(dp, 0);
		dp[0] = input[0];

		findMaxSum(input);
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	private void findMaxSum(int[] input) {
		for (int i = 1; i < input.length; i++) {
			dp[i] = findLast(input, i) + input[i];
		}
	}

	private int findLast(int[] input, int index) {
		int max = 0;
		for (int i = 0; i < index; i++) {
			if (input[i] < input[index]) {
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}

}
