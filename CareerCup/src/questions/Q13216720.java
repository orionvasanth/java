package questions;

public class Q13216720 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(0, 4, 0);
	}
	
	public static void generate(Integer x, Integer max, Integer current){
		if(current == max){
			System.out.println(x);
		} else {
			for(int i = 1; i <= max; i++){
				Integer y = addTenthDigit(x, max, current, i);
				if(y != null){
					generate(y, max, current + 1);
				} 
			}
		}
	}

	private static Integer addTenthDigit(Integer x, Integer max, Integer current, int digitToAppend) {
		if(x == 0){
			x = digitToAppend;
			return x;
		} else {
			Integer lastDigit = x % 10;
			if(Math.abs(lastDigit.intValue() - digitToAppend) > 1){
				return null;
			} else {
				x = (x * 10) + digitToAppend;
				return x;
			}
		}
		
	}

}
