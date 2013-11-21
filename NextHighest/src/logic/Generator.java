package logic;
import java.util.Arrays;
import java.util.Vector;

public class Generator {
	private Integer highest = 0;
	private Vector<Integer> digits = new Vector<Integer>();
	
	public Generator(Integer seed) {
		getHighest(seed);
		//System.out.println(highest);
	}
	
	public Integer getNext() {
		int i = findIndex();
		int j = findMaxDigit(i);
		int temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
		
		reverse(j);
		return getNumberfrmDigits();
	}

	private void reverse(int j) {
		// TODO Auto-generated method stub
		int size = digits.size();
		int count = (size -j - 1) / 2;
		
		for(int i = 0; i <= count; i++) {
			int temp = digits.get(size - 1 - i);
			digits.set(size -1 -i, digits.get(j));
			digits.set(j, temp);
		}
		
	}

	private int findMaxDigit(int index) {
		// TODO Auto-generated method stub
		int size = digits.size(), max = index + 1;
		
		for(int i = index + 1; i < size; i++) {
			if(digits.get(i) > digits.get(max))
				max = i;
		}
		
		return max;
	}
	
	public void getAll() {
		int num;
		
		do {
			num = getNext();
			System.out.println(num);
		} while(num < highest);
	}
	
	private int findIndex() {
		// TODO Auto-generated method stub
		int size = digits.size();
		for(int i = size - 2; i >= 0; i--) {
			if(digits.get(i) < digits.get(i + 1))
				return i;
		}
		
		return 0;
	}

	private void getHighest(Integer seed) {
		// TODO Auto-generated method stub
		Integer temp = seed / 10;
		while (temp > 0) {
			digits.add(seed % 10);
			seed = temp;
			temp = seed / 10;
		}
		digits.add(seed);
		
		//reverse
		int size = digits.size();
		for(int i = 0, count = (size / 2); i < count; i++ ) {
			temp = digits.get(i);
			digits.set(i, digits.get(size - i - 1));
			digits.set(size - i - 1, temp);
		}
		
		sort();
	}
	
	private Integer getNumberfrmDigits() {
		int count = digits.size();
		int num = 0;
		for(int i = 0; i < count; i++) {
			num += (int) (Math.pow(10, count - 1 - i) * digits.get(i));
		}
		
		return num;
	}

	private void sort() {
		// TODO Auto-generated method stub
		Object[] digits = this.digits.toArray();
		Arrays.sort(digits);
		
		for(int i = 0; i < digits.length; i++) {
			highest += (int) (Math.pow(10, i) * (Integer)digits[i]);
		}		
	}
}
