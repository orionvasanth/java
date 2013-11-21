package logic;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue {

	private LinkedList<Integer> list = new LinkedList<Integer>();

	public void enqueue(Integer data) {
		list.addLast(data);
	}

	public Integer dequeue() {
		if(isEmpty())
			return null;
		return list.removeFirst();
	}

	public void enqueue(Integer[] input) {
		for(Integer data : input)
			enqueue(data);
	}

	public void print() {
		Iterator<Integer> itr = list.iterator();
		System.out.println();
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
	}

	public void sort() {
		if(!isEmpty()) {
			Integer data = dequeue();
			if(isEmpty())
				enqueue(data);
			else {
				sort();
				insert(data);
				rotate();
			}
		}
	}

	private void rotate() {
		if(!isEmpty()) {
			for(int i = size(); i > 0; i--) {
				Integer top = dequeue();
				if(top > peek()) {
					enqueue(top);
					break;
				}
				enqueue(top);
			}
		}
	}

	public Integer size() {
		return list.size();
	}

	private void insert(Integer data) {
		if(isEmpty())
			enqueue(data);
		else {
			if(peek() > data)
				enqueue(data);
			else {
				for(int i = size(); i > 0; i--) {
					if(peek() > data) 
						break;
					else enqueue(dequeue());
				}
				enqueue(data);
			}
		}
	}

	public Integer peek() {
		if(isEmpty())
			return null;
		return list.peekFirst();
	}

	public Boolean isEmpty() {
		return list.isEmpty();
	}

	public void reverse() {
		if(!isEmpty()) {
			Integer data = dequeue();
			if(isEmpty())
				enqueue(data);
			else {
				reverse();
				enqueue(data);
			}
		}
	}
}
