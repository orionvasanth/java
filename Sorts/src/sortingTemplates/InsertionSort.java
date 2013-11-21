package sortingTemplates;

public class InsertionSort extends Sort {

	@Override
	public void sort(Integer[] input) {
		
		int adjustedRightBound = input.length - 1;
		int adjustedLeftBound = 0;
		
		for(int i = adjustedLeftBound + 1; i <= adjustedRightBound; i++) {
			int cardUnderProcess = input[i];
			
			int j;
			for(j = i - 1; j >= adjustedLeftBound; j--) {
				if(input[j] >= cardUnderProcess) {
					input[j + 1] = input[j];
				}else{
					break;
				}
			}
			input[j + 1] = cardUnderProcess;
			
		}
	}
}
