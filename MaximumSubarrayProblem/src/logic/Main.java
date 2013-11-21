package logic;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] input = {100, -1, 10};		
		System.out.println(findMaximumSubarray(input));
		findMaximumSubarrayIndices(input);
	}

	public static Integer findMaximumSubarray(Integer[] input) {
		Integer max_so_far = 0, max_ending_here = 0;

		for(int i = 0; i < input.length; i++) {
			max_ending_here = Math.max(0, max_ending_here + input[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}

		return max_so_far;
	}

	public static void findMaximumSubarrayIndices(Integer[] input) {
		Integer max_so_far = 0, max_ending_here = 0;
		
		Integer max_ending_here_start = -1, max_ending_here_end = -1;
		Integer max_so_far_start = - 1, max_so_far_end = -1;
		
		for(int i = 0; i < input.length; i++) {
			Integer temp =  Math.max(0, max_ending_here + input[i]);
			if(temp > max_ending_here) {
				if(max_ending_here == 0) 
					max_ending_here_start = i;
				max_ending_here_end = i;
			} 
			max_ending_here = temp;
			
			temp = Math.max(max_so_far, max_ending_here);
			if(temp > max_so_far) {
				max_so_far_start = max_ending_here_start;
				max_so_far_end = max_ending_here_end;
			}
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		
		System.out.println("Left: " + max_so_far_start + " right: " + max_so_far_end + 
				" Sum=" + max_so_far);
		
	}

}
