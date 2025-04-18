package gts;

class ReverseLinkedList {
	private Node head;

	public void addNode(int data) {
		Node Node = new Node(data);
		if (head == null) {
			head = Node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = Node;
		}
	}

	public void reverseList() {
		Node prev = null;
		Node current = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data);
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println();
	}

}

public class Q128_LinkedListAddReverse {
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);

		System.out.println("Original List : ");
		list.printList();

		list.reverseList();

		System.out.println("Reverse List : ");
		list.printList();
	}
}
