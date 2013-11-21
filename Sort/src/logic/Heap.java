package logic;

public class Heap extends ReadWrite implements SortingInterface {
	
	private int heapSize;
	@Override
	public void sort(Integer[] input) {
		// TODO Auto-generated method stub
		
		buildMaxHeap(input);
		
		for(int i = input.length - 1; i > 0; i--) {
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			heapSize--;
			maxHeapify(input, 0);
		}		
		print(input); 
	}
	
	private void buildMaxHeap(Integer[] input) {
		heapSize = input.length - 1;
		for(int i = input.length / 2; i >= 0; i--) {
			maxHeapify(input, i);
		}
	}
	
	private void maxHeapify(Integer[] input, Integer idx) {
		int left = left(idx);
		int right = right(idx);
		int largest;
		
		if(left <= heapSize && input[left] > input[idx])
			largest = left;
		else 
			largest = idx;
		
		if(right <= heapSize && input[right] > input[largest])
			largest = right;
		
		if(largest != idx) {
			int temp = input[largest];
			input[largest] = input[idx];
			input[idx] = temp;
			maxHeapify(input, largest);
		}
	}
	
	private int left(int idx) {
		return 2 * idx + 1;
	}
	
	private int right(int idx) {
		return 2 * idx + 2;
	}

}
