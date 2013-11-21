/**
 * 
 */
package tweakedBinarySearch;

/**
 * @author Vasanth Kumar Vadivelu(vavadive)
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] input = { 0, 0, 0, 0, 0, 0, 0 };
		//Integer[] input = { 0, 0, 0, 0, 0, 0, 1 };
		//Integer[] input = { 1, 1, 1, 1, 1, 1, 1 };
		Integer[] input = { 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(getFirstOccurence(input, 0, input.length -1, 1));

	}

	private static Integer getFirstOccurence(Integer[] input, int p, int r, int key) {
		if(p > r)
			return -1;
		int q = (p + r) / 2;
		if (input[q] == key) {
			int x = getFirstOccurence(input, p, q - 1, key);
			if (x == -1)
				return q;
			else
				return x;
		} else {
			return getFirstOccurence(input, q + 1, r, key);
		}
	}

}
