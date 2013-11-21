package onedimension.sequence;

public class NonDecreasingSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sequence = { 5, 3, 4, 8, 6, 7 };
		NonDecreasingSequence decreasingSequence = new NonDecreasingSequence();
		decreasingSequence.initializeAndfindNonDecreasingSequence(sequence);
	}

	State[] dp;

	public void initializeAndfindNonDecreasingSequence(int[] sequence) {
		dp = new State[sequence.length];
		State initialState = new State();
		initialState.length = 1;
		initialState.start = 0;
		initialState.end = 0;
		dp[0] = initialState;
		findNonDecreasingSequence(sequence);
		int longest = 0;
		for (int i = 0; i < sequence.length; i++) {
			if(dp[i].length > longest)
				longest = dp[i].length;
		}
		System.out.println(longest);
	}

	public void findNonDecreasingSequence(int[] sequence) {
		for (int i = 1; i < sequence.length; i++) {
			dp[i] = new State();
			if (sequence[i] >= sequence[i - 1]) {
				dp[i].length = dp[i - 1].length + 1;
				dp[i].start = dp[i - 1].start;
				dp[i].end = i;
			} else {
				dp[i].length = 1;
				dp[i].start = i;
				dp[i].end = i;
			}
		}
	}

	class State {
		public int length = Integer.MIN_VALUE;

		public int start;
		public int end;
	}

}
