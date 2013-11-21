package rodcutting;

import java.util.Arrays;

public class RodCutting {

	private int[] dp;
	private int[] cost;

	public static void main(String[] args) {
		RodCutting cutting = new RodCutting();
		int[] cost = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		System.out.println(cutting.findMaximum(cost, 10));
	}

	public int findMaximum(int[] cost, int inch) {
		dp = new int[cost.length + 1];
		this.cost = new int[cost.length + 1];
		this.cost[0] = 0;
		for (int i = 0; i < cost.length; i++)
			this.cost[i + 1] = cost[i];

		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		return findMax(this.cost, inch);
	}

	public int findMax(int[] cost, int inch) {
		if (dp[inch] != Integer.MIN_VALUE)
			return dp[inch];
		
		for(int i = 1; i <= inch; i++){
			dp[inch] = Math.max(dp[inch], cost[i] + findMax(cost, inch - i));
		}
		return dp[inch];
	}

}
