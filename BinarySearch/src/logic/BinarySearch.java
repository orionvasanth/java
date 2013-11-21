package logic;

public class BinarySearch {

	public static void main(String[] args) {
		Integer[] input = { 1, 11, 13, 23, 27, 33, 35, 39, 41};
		System.out.println(BinarySearch.search(input, 0, 8, 41));
	}

	public static Integer search(Integer[] input, Integer p, Integer r, Integer key) {
		if(r < p)
			return null;

		Integer q = (p + r) / 2;
		if(input[q] == key)
			return q;
		else {
			if(key < input[q])
				return search(input, p, q - 1, key);
			else
				return search(input, q + 1, r, key);
		}
	}

}
