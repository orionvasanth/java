package logic;
import java.util.Stack;

public class GetMinimum {

	private Stack<Integer> stk = new Stack<Integer>();
	private Stack<Integer> minStk = new Stack<Integer>();

	public Integer pop() {
		if(minStk.peek() == stk.peek())
			minStk.pop(); //min
		return stk.pop();
	}

	public void push(Integer data) {
		if(stk.isEmpty()) {
			minStk.push(data);
			stk.push(data); //Min
		} else {
			Integer min = minStk.peek();
			stk.push(data);
			if(data < min)
				minStk.push(data);
		}
	}

	public Integer getMinimum() {
		return minStk.peek();
	}

	public void push(Integer[] input) {
		for(Integer data : input) 
			push(data);
	}
}
