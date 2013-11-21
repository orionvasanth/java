package sortingTemplates;

public class BubbleSort extends Sort {

	@Override
	public void sort(Integer[] input){
		bubbleSort(input);
	}
	
	public void bubbleSort(Integer[] input){
		for(int i = 0; i < input.length - 1; i++){
			for(int j = input.length - 1; j > i; j--){
				if(input[j] < input[j - 1]){
					int temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
	}
}
