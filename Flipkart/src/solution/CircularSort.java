package solution;

public class CircularSort {
	/*
	 * Get the circular sorted array
	 */
	public void circularSort(Integer[] input) {
		Integer[] output = new Integer[input.length];
		int tail, elementCount = 1;
		int head = tail = (input.length / 2);

		output[head] = input[0];

		for (int i = 1; i < input.length; i++) {
			if (input[i] <= output[head]) {
				output[head % output.length] = input[i];
				head--;
			} else {
				if (input[i] >= output[tail]) {
					output[tail % output.length] = input[i];
					tail++;
				} else {

				}
			}
		}
	}
}
