package sortingTemplates;

public class HeapSort extends Sort {
	
	private Integer heapSize = 0;

	@Override
	public void sort(Integer[] input) {
		heapSort(input);
	}
	
	
	public void heapSort(Integer[] input){
		buildMaxHeap(input);
		Integer temp;
		
		for(int i = input.length - 1; i > 0; i--){
			temp = input[i];
			input[i] = input[0];
			input[0] = temp;
			heapSize--;
			maxHeapify(input, 0);
		}
	}
	
	
	private void buildMaxHeap(Integer[] input){
		heapSize = input.length;
		for(int i = (input.length)/2; i >= 0; i--){
			maxHeapify(input, i);
		}
	}
	
	private void maxHeapify(Integer[] input, Integer index){
		int leftChildIndex = (index * 2 ) + 1;
		int rightChildIndex = (index * 2) + 2;
		int largestNodeIndex;
		
		if((leftChildIndex < heapSize) && (input[leftChildIndex] > input[index])){
			largestNodeIndex = leftChildIndex;
		}else{
			largestNodeIndex = index;
		}
		
		if((rightChildIndex < heapSize) && (input[largestNodeIndex] < input[rightChildIndex])){
			largestNodeIndex = rightChildIndex;
		}
		
		if(largestNodeIndex != index){
			int temp = input[index];
			input[index] = input[largestNodeIndex];
			input[largestNodeIndex] = temp;
			maxHeapify(input, largestNodeIndex);
		}
	}

}
