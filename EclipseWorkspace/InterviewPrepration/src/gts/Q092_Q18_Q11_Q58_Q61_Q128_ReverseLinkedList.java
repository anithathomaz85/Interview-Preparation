package gts;

/**
 * Reverse the Linked List
 * */
public class Q092_Q18_Q11_Q58_Q61_Q128_ReverseLinkedList {
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
	
	 private static void printList(Node node) {
			while(node!=null) {
				System.out.print(node.data+(node.next!=null?" -> ":""));
				node=node.next;
			}
			  System.out.println();		
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
	 
		
		private static Node reverseUsingRecursion(Node head) {
		    if (head == null || head.next == null) return head; //Base Case

		    Node newHead = reverse(head.next); //Recursive case
		    
		    head.next.next = head;
		    head.next = null;

		    return newHead;
		}
		
}
