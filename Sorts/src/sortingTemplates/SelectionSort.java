package sortingTemplates;

public class SelectionSort extends Sort {
	
	@Override
	public void sort(Integer[] input){
		for(int i = 0; i < input.length - 1; i++){
			int key = i;
			for(int j = i + 1; j < input.length; j++){
				if(input[j] < input[key])
					key = j;
			}
			
			int temp = input[key];
			input[key] = input[i];
			input[i] = temp;
		}
	}

}
