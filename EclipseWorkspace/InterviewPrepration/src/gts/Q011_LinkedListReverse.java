package gts;
/***
 *  Implement linked list and print it in reverse order.
 *  
 * CALL FLOW:
		printReverse(1)
		 └── printReverse(2)
		      └── printReverse(3)
		           └── printReverse(null) → returns
		           ← print 3
		      ← print 2
		 ← print 1
 * 
 * */
public class Q011_LinkedListReverse {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		printReverse1(head);
		 System.out.println("\n");
		printReverse2(head);


	}


	public static void printReverse1(Node head) {
	        if (head == null) {
	            return; //"stop this method and go back to the caller."
	            //In your recursive function, it's used to stop further recursion once you reach the end of the list.
	        }
	        // Once that base case returns, each previous recursive call resumes its next step:
	        /*  printReverse(head.next);  // This has completed
				System.out.print(head.data + " ");  // Now this runs
				So the stack unwinds like this:
				System.out.print(3) → System.out.print(2) → System.out.print(1)
				
			*/
	        printReverse1(head.next);  
	        System.out.print(head.data + "->"); 
	       
	    }
	
	 private static void printReverse2(Node head) {
		
		 if(head == null) {
			 return;
		 }
		 printReverse2(head.next);
	      System.out.print(head.data + " "); 
		
	}
}
