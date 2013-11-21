package sortingTemplates;

public class MergeSort extends Sort {

	@Override
	public void sort(Integer[] input){
		int adjustedLeftBound = 0;
		int adjustedRightBound = input.length - 1;
		
		mergeSort(input, adjustedLeftBound, adjustedRightBound);
	}

	private void mergeSort(Integer[] input, int adjustedLeftBound,
			int adjustedRightBound) {
		// TODO Auto-generated method stub
		int splitIndex = (adjustedLeftBound + adjustedRightBound) / 2;
		
		if(splitIndex < adjustedRightBound){
			mergeSort(input, adjustedLeftBound, splitIndex);
			mergeSort(input, splitIndex + 1, adjustedRightBound);
			merge(input, adjustedLeftBound, splitIndex, adjustedRightBound);
		}
		
	}

	private void merge(Integer[] input, int adjustedLeftBound, int splitIndex,
			int adjustedRightBound) {
		// TODO Auto-generated method stub
		Integer leftArrayLength = splitIndex - adjustedLeftBound + 2;
		Integer[] leftArray = new Integer[leftArrayLength];
		
		Integer rightArraylength = adjustedRightBound - (splitIndex + 1) + 2;
		Integer[] rightArray = new Integer[rightArraylength];
		
		int i;
		for(i = 0; (adjustedLeftBound + i) <= splitIndex; i++){
			leftArray[i] = input[adjustedLeftBound + i];
		}		
		leftArray[i] = Integer.MAX_VALUE;
		
		for(i = 0; (splitIndex + 1 + i) <= adjustedRightBound; i++){
			rightArray[i] = input[splitIndex + 1 + i];
		}
		rightArray[i] = Integer.MAX_VALUE;
		
		int rightIndex = 0, leftIndex = 0;		
		for( i = adjustedLeftBound; i <= adjustedRightBound; i++){
			if(leftArray[leftIndex] < rightArray[rightIndex]){
				input[i] = leftArray[leftIndex];
				leftIndex++;
			}else{
				input[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
}
