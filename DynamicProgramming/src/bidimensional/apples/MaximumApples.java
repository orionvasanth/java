package bidimensional.apples;

import java.util.Arrays;

public class MaximumApples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] apples = { { 1, 0, 10 }, { 0, 1, 0 }, { 0, 0, 1 } };
		MaximumApples maximumApples = new MaximumApples();
		System.out.println(maximumApples.findMaximumApples(apples));
	}

	private int[][] dp;

	public int findMaximumApples(int[][] apples) {

		dp = new int[apples.length][];
		for (int i = 0; i < apples.length; i++) {
			dp[i] = new int[apples[i].length];
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}

		// lower right corner is the initial state.
		/*
		 * dp[apples.length - 1][dp[apples.length - 1].length - 1] =
		 * apples[apples.length - 1][apples[apples.length - 1].length - 1];
		 */
		dp[0][0] = apples[0][0];

		return findMaximum(apples, apples.length - 1,
				apples[apples.length - 1].length - 1);
	}

	private int findMaximum(int[][] apples, int row, int column) {
		if (dp[row][column] != Integer.MIN_VALUE)
			return dp[row][column];
		else {
			int left = 0;
			int above = 0;

			// same row - (row, column - 1)
			if (column > 0) {
				left = findMaximum(apples, row, column - 1);
			}

			// same column - (row - 1, column)
			if (row > 0) {
				above = findMaximum(apples, row - 1, column);
			}

			return dp[row][column] = Math.max(above, left)
					+ apples[row][column];
		}
	}

}
