package solution;

public class Subarray {
	public Integer leftBound;
	public Integer rightBound;
	public Integer sum;
	
	public Subarray(){
		this.leftBound = -1;
		this.rightBound = -1;
		this.sum = 0;
	}
	
	public Subarray(Integer leftBound, Integer rightBound, Integer sum){
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.sum = sum;
	}
}
