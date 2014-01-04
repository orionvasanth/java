/**
 * 
 */
package geeksforgeeks;

import java.util.Arrays;

/**
 * @author Vasanth
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
public class CountPathsInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPathsInMatrix countPathsInMatrix = new CountPathsInMatrix();
		countPathsInMatrix.countPaths(3, 3);
	}

	private int[][] dp;

	public void countPaths(int rows, int columns) {
		dp = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		dp[0][0] = 1;
		System.out.println(count(rows - 1, columns - 1));
	}

	private int count(int row, int column) {
		if (dp[row][column] == Integer.MIN_VALUE) {
			dp[row][column] = 0;
			if (column > 0)
				dp[row][column] = count(row, column - 1);
			if (row > 0)
				dp[row][column] += count(row - 1, column);
		}
		return dp[row][column];
	}

}
