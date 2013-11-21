package onedimension.coins;

import java.util.Arrays;

public class MinimumCoinsIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] denomination = { 1, 3, 5 };
		MinimumCoinsIII coinsIII = new MinimumCoinsIII();
		System.out.println(coinsIII.findMininum(denomination, 4));
	}

	private int[] dp;

	public int findMininum(int[] denomination, int sum) {
		dp = new int[sum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		findMinimumIII(denomination, sum);
		return dp[sum];
	}

	private int findMinimumIII(int[] denomination, int sum) {
		if (dp[sum] != Integer.MAX_VALUE)
			return dp[sum];

		int coins = dp[sum];
		for (int i = 0; i < denomination.length; i++) {
			// sum can be obtained from each state i eg., for 15 - 14, 12, 10
			if (sum - denomination[i] >= 0)
				coins = Math.min(coins,
						findMinimumIII(denomination, sum - denomination[i]));
			else
				break;
		}

		return dp[sum] = coins + 1;
	}

}
