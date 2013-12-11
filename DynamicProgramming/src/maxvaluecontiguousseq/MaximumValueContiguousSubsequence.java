/**
 * 
 */
package maxvaluecontiguousseq;

/**
 * @author Vasanth
 * 
 */
public class MaximumValueContiguousSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {11, 1, -12, 13, -10};
		System.out.println(new MaximumValueContiguousSubsequence().findMax(numbers));

	}

	public int findMax(int[] numbers) {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			max = Math.max(numbers[i - 1] + max, numbers[i]);
		}
		return max;
	}

}
