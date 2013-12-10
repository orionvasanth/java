package srm.practice;

import java.util.Arrays;

public class BadNeighborsV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] dp;
	
	public void max(int[] donations) {
		dp = new int[donations.length];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = donations[0];
		
		max(donations, 0);
	}
	
	private void max(int[] donations, int index) {
		max(donations, true, index+1);
	}
	
	private void max(int[] donations, boolean neighbor, int index) {
		if(neighbor) {
			
		} else {
			
		}
	}

}
