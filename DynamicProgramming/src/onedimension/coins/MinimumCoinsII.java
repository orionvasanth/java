package onedimension.coins;

import java.util.Arrays;

public class MinimumCoinsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] denomination = { 1, 3, 5 };

		MinimumCoinsII coinsII = new MinimumCoinsII();
		System.out.println(coinsII.findMinimumCoins(denomination, 15));

	}

	public int[] dp;

	public int findMinimumCoins(int[] denomination, int sum) {
		dp = new int[sum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		findMinimumCoins(denomination);

		return dp[sum];
	}

	private void findMinimumCoins(int[] denomination) {
		for (int i = 0; i < denomination.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if (dp[j] < Integer.MAX_VALUE) { // sums already found
					int state = denomination[i] + j;
					if (state < dp.length) {
						int coins = dp[j] + 1;
						dp[state] = Math.min(dp[state], coins);
					}
				}
			}
		}
	}

}
