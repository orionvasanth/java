package logic;

public class LinkedList {

	private ListNode head = null;
	private ListNode tail = null;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public void insert(ListNode input) {
		if(tail != null) {
			tail.next = input;
			tail = input;
		} else {
			tail = head = input;
		}
	}

	public void insert(Integer input) {
		insert(new ListNode(input));
	}

	public void insert(Integer[] input) {
		for(Integer x : input)
			insert(x);
	}

	public void makeLoop(Integer mu) {
		ListNode x = head;
		while(x != null) {
			if(x.data == mu) {
				tail.next = x;
				break;
			} else x = x.next;
		}
	}

	public void removeLoop() {

	}

	public void print(ListNode x) {
		System.out.println();
		while(x != null) {
			System.out.print(x.data + " ");
			x = x.next;
		}
	}

	public Boolean hasLoop(ListNode x) {
		if(x == null)
			return false;
		else {
			ListNode tortoise = x, hare = x;
			do {
				tortoise = tortoise.next;
				hare = hare.next;
				if(hare != null)
					hare = hare.next;
			} while(tortoise != null && hare != null && tortoise != hare);

			if(tortoise == null || hare == null)
				return false;
			else {
				tortoise = x;
				while(tortoise != hare) {
					tortoise = tortoise.next;
					hare = hare.next;
				}
				System.out.println("Loop starts at: " + tortoise.data);

				Integer length = 1;
				hare = tortoise.next;
				ListNode end = hare;
				while(tortoise != hare) {
					end = hare;
					hare = hare.next;
					length++;
				}
				end.next = null;
				System.out.println("The length of loop is: " + length);
				System.out.println("Loop removed");
				return true;
			}
		}
	}

	public ListNode recursiveReverse(ListNode x) {
		if(x.next != null) {
			recursiveReverse(x.next).next = x;
			x.next = null;
			return x;
		} else {
			head = x;
			return x;
		}
	}
	
	public void iterativeReverse() {

		ListNode x = head;
		print(x);
		ListNode y = x.next;
		x.next = null;

		while(y != null) {			
			ListNode z = y.next;
			y.next = x;
			x = y;
			y = z;
		}

		print(x);
		head = x;
		recursiveReverse(head);
		print(head);
	}
	
	/* Question
		http://www.geeksforgeeks.org/archives/15663
	*/
	public void deleteNode(ListNode head, ListNode x) {
		if(head.equals(x)) {
			head.data = head.next.data;
			head.next = head.next.next;
		} else {
			while(!head.next.equals(x)) {
				head = head.next;
			}
			head.data = head.next.data;
			head.next = head.next.next;			
		}
	}
}
