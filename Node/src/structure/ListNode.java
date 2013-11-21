package structure;

public class ListNode extends Node {
	
	private ListNode next;
	private ListNode previous;
	
	public ListNode(Integer data){
		super(data);
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getPrevious() {
		return previous;
	}

	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}
}
