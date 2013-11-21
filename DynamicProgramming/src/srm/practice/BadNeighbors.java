package srm.practice;

import java.util.Arrays;

public class BadNeighbors {

	public static void main(String[] args) {

	}

	private int[][] cache;

	public int maxDonations(int[] donations) {
		cache = new int[2][donations.length];
		Arrays.fill(cache[0], -1);
		Arrays.fill(cache[1], -1);

		return Math.max(max(donations, 2, true) + donations[0],
				max(donations, 2, false));
	}

	/*
	 * onegave - to identify
	 */
	private int max(int[] donations, int where, boolean onegave) {
		if (where == donations.length)
			return 0;
		if (where == donations.length - 1 && onegave)
			return 0;
		else if (where == donations.length - 1)
			return donations[where];
		if (cache[onegave ? 1 : 0][where] != -1)
			return cache[onegave ? 1 : 0][where];
		return cache[onegave ? 1 : 0][where] = Math.max(
				max(donations, where + 1, onegave),
				max(donations, where + 2, onegave) + donations[where]);
	}
}
