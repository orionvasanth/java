package logic;
import java.util.*;

public class TowerOfHanoi {
	private Stack<Integer> A = new Stack<Integer>();
	private Stack<Integer> B = new Stack<Integer>();
	private Stack<Integer> C = new Stack<Integer>();
	private Integer disk = 0;

	public TowerOfHanoi(Integer disk) {
		this.disk = disk;
		for(int i = disk; i > 0; i--) {
			A.push(i);
		}
	}

	public void itrerativeSltn() {
		if(disk % 2 == 0) {
			while(C.size() < disk) {
				makeValidMove(A, B);
				makeValidMove(A, C);
				makeValidMove(B, C);
			}
		} else {
			while(C.size() < disk) {
				makeValidMove(A, C);
				makeValidMove(A, B);
				makeValidMove(B, C);
			}
		}
		
		System.out.println("Peg A");
		print(A.iterator());
		System.out.println("Peg B");
		print(B.iterator());
		System.out.println("Peg C");
		print(C.iterator());
	}
	
	public void recursiveSltn() {
		recursiveSltn(A, B, C, A.size());
		System.out.println("Peg A");
		print(A.iterator());
		System.out.println("Peg B");
		print(B.iterator());
		System.out.println("Peg C");
		print(C.iterator());
	}
	
	private void recursiveSltn(Stack<Integer> src, Stack<Integer> axlry, Stack<Integer> trgt, Integer size) {
		if(size > 1) {
			recursiveSltn(src, trgt, axlry, size - 1);
			trgt.push(src.pop());
			recursiveSltn(axlry, src, trgt, size - 1);
		} else {
			trgt.push(src.pop());
		}
	}

	private void makeValidMove(Stack<Integer> a, Stack<Integer> b) {
		if(a.isEmpty() || b.isEmpty()) {
			if(a.isEmpty()) {
				a.push(b.pop());
			} else {
				b.push(a.pop());
			}
		} else {
			if(a.peek() < b.peek()) {
				b.push(a.pop());
			} else {
				a.push(b.pop());
			}
		}
	}
	
	private void print(Iterator<Integer> itr) {
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
}
