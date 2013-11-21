package logic;
import java.util.Stack;
import java.util.Iterator;

public class StackProblems {
	private Stack<Integer> stk = new Stack<Integer>();

	public void push(Integer[] input) {
		for(Integer data : input) 
			stk.push(data);
	}

	public void print() {
		Iterator<Integer> itr = stk.iterator();
		System.out.println();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
	}

	public void reverse() {
		Integer data = stk.pop();
		if(stk.isEmpty())
			stk.push(data);
		else {
			reverse();
			insertLast(data);
		}
	}

	public void insertLast(Integer data) {
		Integer curr = stk.pop();
		if(stk.isEmpty()) 
			stk.push(data);
		else 
			insertLast(data);
		stk.push(curr);
	}
	
	public void sort() {
		Integer data = stk.pop();

		if(stk.isEmpty())
			stk.push(data);
		else {
			sort();
			insert(data);
		}
	}

	public void insert(Integer data) {
		if(data > stk.peek()) {
			Integer curr = stk.pop();
			if(stk.isEmpty()) {
				stk.push(data);
				stk.push(curr);
			} else {
				insert(data);
				stk.push(curr);
			}
		} else stk.push(data);
	}
}
