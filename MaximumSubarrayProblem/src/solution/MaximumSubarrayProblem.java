package solution;

public class MaximumSubarrayProblem {

	public static void main(String[] args){
		Integer[] input = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		solve(input);
	}

	//http://en.wikipedia.org/wiki/Maximum_subarray_problem - cheers, what i implemented is right!!
	public static void solve(Integer[] input){

		Integer maxSoFar = input[0], maxEndingHere = input[0];
		Integer tempBegin = 0;
		Integer begin = 0;
		Integer end = 0;

		for(int i = 1; i < input.length; i++){
			maxSoFar = maxSoFar + input[i];
			
			if(input[i] > maxSoFar){
				maxSoFar = input[i];
				tempBegin = i;
			}
			
			if(maxSoFar > maxEndingHere){
				maxEndingHere = maxSoFar;
				begin = tempBegin;
				end = i;
			}
		}

		for(int i = begin; i <= end; i++){
			System.out.print(input[i] + "  ");
		}
	}
}
