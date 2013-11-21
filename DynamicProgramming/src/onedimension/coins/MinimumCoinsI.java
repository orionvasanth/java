package onedimension.coins;

import java.util.Arrays;

public class MinimumCoinsI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] denomination = { 1, 3, 5 };
		MinimumCoinsI coins = new MinimumCoinsI();
		System.out.println();
		/*for(int i = 0; i <= 15; i++){
			System.out.println(coins.findMinimumCoins(denomination, i));
		}*/
		System.out.println(coins.findMinimumCoins(denomination, 15));

	}

	public int findMinimumCoins(int[] denomination, int sum) {
		// create an array to save all the states.
		int[] dp = new int[sum + 1]; // 0 will be the first state
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // 0 coins for sum 0.

		for (int i = 1; i <= sum; i++) {
			int res = i;
			int dpCoins = dp[i - 1] + 1;
			int coins = 0;
			for (int j = denomination.length - 1; j >= 0 || res > 0; j--) {
				int currDenomCoins = res/denomination[j];
				if(currDenomCoins != 0){
					res = res % denomination[j] ;
					coins += currDenomCoins;
				} 
			}
			dp[i] = Math.min(dpCoins, coins);
		}
		return dp[dp.length - 1];
	}

}
