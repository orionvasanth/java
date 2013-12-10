package maxvaluesubsequence;

import java.util.Arrays;

public class MaximumValueContiguousSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-20, -1, 15, 1, -100, 40};
		findMaximumValueContiguousSubsequence(input);

	}

	public static void findMaximumValueContiguousSubsequence(int[] input) {
		int[] dp = new int[input.length];
		Arrays.fill(dp, Integer.MIN_VALUE);		
		dp[0] = input[0];
		
		int max = dp[0];
		
		for(int i = 1; i < input.length; i++){
			dp[i] = Math.max(dp[i-1] + input[i], input[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
