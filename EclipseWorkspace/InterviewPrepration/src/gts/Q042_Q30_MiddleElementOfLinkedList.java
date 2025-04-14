package gts;

/**
 * In linked list how to find middle element
 * */
public class Q042_Q30_MiddleElementOfLinkedList {
	

	public static Node insertAtHead(Node head, int value) {
 		Node newNode = new Node(value);
		newNode.next = head;
		return newNode;
	}
 
	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print("null");
	}
 
	// Find the middle node
	public static Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
 
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		} 
		return slow;
	}
 
	public static void main(String[] args) {
		Node head = null;
		head = insertAtHead(head, 5);
		head = insertAtHead(head, 4);
		head = insertAtHead(head, 3);
		head = insertAtHead(head, 2);
		head = insertAtHead(head, 1);
		System.out.println("Middle node: " + findMiddle(head).data);
 
	}


}
