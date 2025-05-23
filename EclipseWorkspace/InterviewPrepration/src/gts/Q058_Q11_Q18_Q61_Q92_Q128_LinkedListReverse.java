package gts;

/***
 * Reverse the Linked List.
 * 
 */
public class Q058_Q11_Q18_Q61_Q92_Q128_LinkedListReverse {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printList(head);
		head = reverse(head);
		printList(head);

	}

	private static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node temp;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	private static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + (node.next != null ? " -> " : ""));
			node = node.next;
		}
		System.out.println();
	}
}
