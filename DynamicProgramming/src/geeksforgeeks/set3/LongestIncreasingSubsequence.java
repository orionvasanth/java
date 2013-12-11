package geeksforgeeks.set3;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(new LongestIncreasingSubsequence()
				.findLongestIncreasingSubsequence(input));
	}

	private int[] dp;

	// O(n^2) is the complexity of the below code. An efficient solution of 
	// O(nlogn) is possible at
	// http://en.wikipedia.org/wiki/Longest_increasing_subsequence#Efficient_algorithms
	public int findLongestIncreasingSubsequence(int[] input) {
		dp = new int[input.length];
		Arrays.fill(dp, -1);
		dp[0] = 1;

		find(input);
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	private void find(int[] input) {
		for (int i = 1; i < input.length; i++) {
			dp[i] = findLast(input, i) + 1;
		}
	}

	private int findLast(int[] input, int index) {
		int max = 0;
		for (int i = 0; i < index; i++) {
			if (input[i] < input[index])
				max = Math.max(max, dp[i]);
		}
		return max;
	}

}
