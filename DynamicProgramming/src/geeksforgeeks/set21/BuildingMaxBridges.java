package geeksforgeeks.set21;

import java.util.Arrays;

public class BuildingMaxBridges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] south = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] north = { 8, 1, 4, 3, 5, 2, 6, 7 };

		System.out.println(new BuildingMaxBridges()
				.findMaxBridges(south, north));

	}

	public int findMaxBridges(int[] south, int[] north) {
		sequence = new int[south.length];
		for (int i = 0; i < south.length; i++) {
			for (int j = 0; j < north.length; j++) {
				if (south[i] == north[j]) {
					sequence[i] = j;
					break;
				}
			}
		}
		return findLongestIncreasingSubsequence(sequence);
	}

	private int[] sequence;
	private int[] dp;

	private int findLongestIncreasingSubsequence(int[] input) {
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
