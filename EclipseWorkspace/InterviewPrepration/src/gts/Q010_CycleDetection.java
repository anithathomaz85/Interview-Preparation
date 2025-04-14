package gts;

import java.util.ArrayList;
import java.util.List;

/**
 * 
	 1 -> 2 -> 3 -> 4
	         ↑    ↓
	         ←←←←←
 * */
public class Q010_CycleDetection {
	public static void main(String[] args) {
		
		Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;  // Creating cycle: 3 -> 2
        
        System.out.println("Cycle Detected: " + hasCycle(head));
		
	}	
	
	public static boolean hasCycle(Node head) {
		
        List<Node> visited = new ArrayList<>();

        Node current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true;  // Cycle detected
            }
            visited.add(current);  // Mark current node as visited
            current = current.next;
        }

        return false;  // No cycle found
    }
}
