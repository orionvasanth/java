package sortingTemplates;

public class CountingSort extends Sort {

	@Override
	public void sort(Integer[] input){
		Integer[] aux = new Integer[input.length]; // k is assumed to be input.length
		Integer[] output = new Integer[input.length]; // k is assumed to be input.length
		
		for(int i = 0; i < input.length; i++){
			aux[i] = 0;
		}
		
		for(int i = 0; i < input.length; i++){
			aux[input[i]] = aux[input[i]] + 1;
		}
		
		for(int i = 1; i < input.length; i++){
			aux[i] = aux[i] + aux[i - 1];
		}
		
		for(int i = 0; i < input.length; i++){
			output[aux[input[i]]] = input[i];
			aux[input[i]] = aux[input[i]] - 1;
		}
	}
}
