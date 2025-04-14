package gts;

/**
 * Given a linked list:
	1 -> 2 -> 3 -> 4 -> 5 -> 6
	K = 2 (means delete the 2nd node from the end, which is 5)
	Expected Output: 1 -> 2 -> 3 -> 4 -> 6
 * */

public class Q009_DeleteKthFromEnd {
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		 printList(head); 
		 
		 int k = 2;
	     head = deleteKthFromEnd(head, k);
	     printList(head);
	}
	
	private static void printList(Node node) {
		while(node!=null) {
			System.out.print(node.data+(node.next!=null?" -> ":""));
			node=node.next;
		}
		  System.out.println();		
	}

	public static Node deleteKthFromEnd(Node head, int k) {	
		//Create a dummy node to handle edge cases (like deleting the first node).
		Node dummy = new Node(0);
		dummy.next = head;
		
        Node fast = dummy;
        Node slow = dummy;
        
        
        // Move fast k+1 steps ahead
        for (int i = 0; i <= k; i++) {
            if (fast != null) fast = fast.next;
        }

        // Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the k-th node from end
        slow.next = slow.next.next;

        return dummy.next;
	}
}
