package geeksforgeeks.set33;

import java.util.Arrays;

public class InterleavedStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterleavedStrings interleavedStrings = new InterleavedStrings();
		System.out.println(interleavedStrings.isInterleaved("aabcc", "dbbca",
				"aadbbcbcac"));
		System.out.println(interleavedStrings.isInterleaved("aabcc", "dbbca",
				"aadbbbaccc"));
		System.out.println(interleavedStrings.isInterleaved("101", "01",
				"10011"));
		System.out.println(interleavedStrings.isInterleaved("XXY", "XXZ", "XXZXXXY"));
		System.out.println(interleavedStrings.isInterleaved("", "", ""));
	}

	private Boolean[][] dp;

	public boolean isInterleaved(String str1, String str2, String interleavedStr) {
		if (!(interleavedStr.length() == str1.length() + str2.length()))
			return false;
		dp = new Boolean[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], null);
		}
		dp[0][0] = Boolean.TRUE;

		return isInterleaved(str1, str2, interleavedStr, str1.length(),
				str2.length());
	}

	private Boolean isInterleaved(String str1, String str2,
			String interleavedString, int i, int j) {
		if (dp[i][j] != null)
			return dp[i][j];
		char last = interleavedString.charAt(i + j - 1);
		if (last == str1.charAt(i - 1)) {
			/*if (last == str2.charAt(j - 1))
				return isInterleaved(str1, str2, interleavedString, i - 1, j)
						|| isInterleaved(str1, str2, interleavedString, i,
								j - 1);*/

			return isInterleaved(str1, str2, interleavedString, i - 1, j);
		} else {
			if (last == str2.charAt(j - 1)) {
				return isInterleaved(str1, str2, interleavedString, i, j - 1);
			} else {
				return dp[i][j] = Boolean.FALSE;
			}
		}
	}
}
