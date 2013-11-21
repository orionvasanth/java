package logic;

public class Insertion extends ReadWrite implements SortingInterface{

	@Override
	public void sort(Integer[] input) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < input.length; i++ ) {
			int key = input[i];
			int j = i - 1;
			for( ; j >= 0; j--) {
				if(key < input[j]) {
					input[j + 1] = input[j];
				} else 
					break;
			}
			
			input[j + 1] = key;
		}
		
		print(input);
	}
	
}
