package logic;

public class Merge extends ReadWrite implements SortingInterface {

	@Override
	public void sort(Integer[] input) {
		// TODO Auto-generated method stub
		sort(input, 0, input.length - 1);		
		print(input);		
	}
	
	public void sort(Integer[] input, Integer p, Integer r) {
		if(p < r) {
			Integer q = (p + r) / 2;
			sort(input, p, q);
			sort(input, q + 1, r);
			merge(input, p, q, r);
		}		
	}
	
	private void merge(Integer[] input, Integer p, Integer q, Integer r) {
		
		Integer[] left = new Integer[q - p + 1];
		Integer[] right = new Integer[r - q];
		
		for(int i = 0; i < left.length; i++) {
			left[i] = input[i + p];
		}
		
		for(int i = 0; i < right.length; i++) {
			right[i] = input[i + q + 1];
		}
		
		int lidx = 0, ridx = 0;
		
		for(int i = p; i <= r; i++) {
			if(left[lidx] < right[ridx]) {
				input[i] = left[lidx];
				lidx++;
				
				if(lidx == left.length) {
					while(ridx != right.length) {
						input[++i] = right[ridx++];
					}
				}
				
			} else {
				input[i] = right[ridx];
				ridx++;
				
				if(ridx == right.length) {
					while(lidx != left.length) {
						input[++i] = left[lidx++];
					}
				}
			}			
		}
		
	}

}
