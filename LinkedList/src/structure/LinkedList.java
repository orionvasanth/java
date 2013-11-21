package structure;

public class LinkedList {
	private ListNode head;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public Integer getLength() {
		ListNode node = head;
		int i = 0;
		for (; head != null; i++) {
			node = node.getNext();
		}

		return i;
	}

	public static void printList(ListNode node) {
		System.out.println();
		while (node != null) {			
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
	}

	/*
	 * public static void main(String[] args){ Integer[] input = { 1, 2, 3, 4,
	 * 5, 6, 7, 8, 9, 10 }; buildLinkedListFromArray(input, 0, input.length -
	 * 1); }
	 */

	public static ListNode buildLinkedListFromArray(Integer[] input, int p,
			int r) {
		if (p > r)
			return null;
		ListNode node = new ListNode(input[p]);
		node.setNext(buildLinkedListFromArray(input, p + 1, r));
		return node;
	}
}
