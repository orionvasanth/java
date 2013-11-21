package sortingTemplates;

public class QuickSort extends Sort {

	public void sort(Integer[] input){
		quickSort(input, 0, input.length - 1);
	}

	public void quickSort(Integer[] input, int p, int r){
		if(p < r){
			int q = partition(input, p ,r);
			quickSort(input, p, q-1);
			quickSort(input, q+1, r);
		}
	}

	private int partition(Integer[] input, int p, int r) {
		// TODO Auto-generated method stub

		int key = input[r];
		int q = p-1;

		for(int i = p; i < r; i++){
			if(input[i] <= key){

				int temp = input[q + 1];
				input[q + 1] = input[i];
				input[i] = temp;
				q++;
			}
		}

		int temp = input[q + 1];
		input[q + 1] = key;
		input[r] = temp;
		q++;

		return q;
	}
}
