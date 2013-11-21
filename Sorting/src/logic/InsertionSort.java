package logic;

public class InsertionSort {
	
	public void sort(Integer[] input, Integer left, Integer right) {
		for(int i = left; i <= right; i++) {
			int key = input[i];
			int j = i - 1;
			for( ; j >= 0; j--) {
				if(input[j] < key) {
					swap(input, j, j - 1);
				} else {
					break;
				}
			}
			input[j + 1] = key;
		}
	}
	
	private void swap(Integer[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
