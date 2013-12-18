package geeksforgeeks.set29;

import java.util.Arrays;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSubstring commonSubstring = new LongestCommonSubstring();
		commonSubstring.findCommonSuffixLengthofAllPrefixes("ABAB", "BABA");
		commonSubstring.findCommonSuffixLengthofAllPrefixes("GeeksforGeeks",
				"GeeksQuiz");
	}

	private int[][] dp;

	private void printAllLongestCommonSubstring(char[] str1, char[] str2) {
		int max = getLongestSuffix();
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (dp[i][j] == max) {
					printSubstring(str1, i, max);
				}
			}
		}
	}

	private void printSubstring(char[] str, int index, int length) {
		StringBuilder substring = new StringBuilder();
		for (int i = 0; i < length; i++) {
			substring.append(str[index - length + 1 + i]);
		}
		System.out.println(substring);
	}

	private int getLongestSuffix() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		return max;
	}

	public void findCommonSuffixLengthofAllPrefixes(String str1, String str2) {
		findCommonSuffixLengthofAllPrefixes(str1.toCharArray(),
				str2.toCharArray());
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

	private void findCommonSuffixLengthofAllPrefixes(char[] str1, char[] str2) {
		dp = new int[str1.length][str2.length];
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				dp[i][j] = getCommonSuffixLength(str1, i, str2, j);
			}
		}
		printAllLongestCommonSubstring(str1, str2);
	}

	private int getCommonSuffixLength(char[] str1, int prefix1, char[] str2,
			int prefix2) {
		int suffix = 0;
		int loop = prefix1 < prefix2 ? prefix1 : prefix2;

		for (int i = 0; i <= loop; i++) {
			if (str1[prefix1 - i] == str2[prefix2 - i])
				suffix++;
			else
				break;
		}

		return suffix;
	}

}
