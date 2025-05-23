package gts;

/**
 * Given a LinkedList
		1-4-2-8-10-null
	Update value of node with following condition -
		If value is even put 0
		If value is odd put 1
	
	Ans - 1-0-0-0-0-null
 * */
public class Q039_UpdateLinkedList {

	Node head;
	
	public static void main(String[] args) {
		
		Q039_UpdateLinkedList obj = new Q039_UpdateLinkedList();
	
		// 1->4->2->8->10->null
		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(2);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(10);

		 
		// Call the function to update values
		updateList(head);
 
		// Print the updated list
		printList(head);
	}
	
    
	public static void updateList(Node head) {
		Node current = head;
 
		while (current != null) {
			if (current.data % 2 == 0) {
				current.data = 0; // Even
			} else {
				current.data = 1; // Odd
			}
			current = current.next;
		}
	}
	
	private void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }
    
    private static void printList(Node node) {
		while (node.next != null) {		
			System.out.print(node.data + (node.next!=null?" -> ":""));
			node = node.next;
		}
		System.out.println("null");
	}
}
