package logic;

public class LinkedList {

	private Node head = null;
	private Node tail = null;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insert(Node input) {
		if(tail != null) {
			tail.next = input;
			tail = input;
		} else {
			tail = head = input;
		}
	}

	public void insert(Integer input) {
		insert(new Node(input));
	}

	public void insert(Integer[] input) {
		for(Integer x : input)
			insert(x);
	}
	
	public void makeLoop(Integer mu) {
		Node x = head;
		while(x != null) {
			if(x.data == mu) {
				tail.next = x;
				break;
			} else x = x.next;
		}
	}
	
	public void removeLoop() {
		
	}

	public Boolean hasLoop(Node x) {
		if(x == null)
			return false;
		else {
			Node tortoise = x, hare = x;
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
				Node end = hare;
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
}
