package logic;

public class Quick extends ReadWrite implements SortingInterface {

	@Override
	public void sort(Integer[] input) {
		// TODO Auto-generated method stub
		sort(input, 0, input.length - 1);
		
		print(input);
	}
	
	private void sort(Integer[] input, int p, int r) {
		if(p < r) {
			int q = partition(input, p, r);
			sort(input, p, q - 1);
			sort(input, q + 1, r);
		}		
	}

	private int partition(Integer[] input, int p, int r) {
		// TODO Auto-generated method stub
		int key = input[r];
		int x = p - 1;
		int i = p;
		
		for( ; i < r; i++) {
			if(input[i] <= key) {
				x++;
				int temp = input[i];
				input[i] = input[x];
				input[x] = temp;
			}
		}
		
		int temp = input[i];
		input[i] = input[x + 1];
		input[x + 1] = temp;
		
		return x + 1;
	}

}
