package geeksforgeeks.set36;

import java.util.Arrays;

public class MaximumProductCutting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumProductCutting cutting = new MaximumProductCutting();
		System.out.println(cutting.findMaxProduct(2));
	}

	private int[] product;

	public int findMaxProduct(int length) {
		product = new int[length + 1];
		Arrays.fill(product, Integer.MIN_VALUE);
		product[1] = 1;
		product[2] = 1;
		return findMax(length);
	}

	private int findMax(int length) {
		if(product[length] != Integer.MIN_VALUE)
			return product[length];
		for (int i = 1; i < length; i++) {
			product[length] = Math.max(product[length], i * (length - i));
			product[length] = Math.max(product[length], product[i] * findMax(length - i));
		}
		return product[length];
	}

}
