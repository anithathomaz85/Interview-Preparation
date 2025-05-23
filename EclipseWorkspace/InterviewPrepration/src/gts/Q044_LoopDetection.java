package gts;

/**
 * Write a program to detect a loop in a custom singly linked list. 
 * The program should determine if there is a loop in the linked list and output the result?
 * */

public class Q044_LoopDetection {

	static class CustomLinkedList {
		 
        Node head;
 
        class Node {
            int value;
            Node next;
 
            public Node(int value) {
                this.value = value;
                this.next = null;
            }
        }
 
        // Add node
        void add(int value) {
            Node newNode = new Node(value);
 
            if (head == null) {
                head = newNode;
                return;
            }
 
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
 
            temp.next = newNode;
        }
 
        // Create a loop (for testing)
        void createLoop(int position) {
            if (position < 0) return;
 
            Node loopNode = head;
            for (int i = 1; i < position && loopNode != null; i++) {
                loopNode = loopNode.next;
            }
 
            if (loopNode == null) return;
 
            Node end = head;
            while (end.next != null) {
                end = end.next;
            }
 
            end.next = loopNode; // create the loop
        }
 
        // Detect loop using Floyd’s Algorithm
        
        boolean detectLoop() {
            Node slow = head;
            Node fast = head;
 
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
 
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
 
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
 
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
 
        
         list.createLoop(2);
 
        if (list.detectLoop()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop");
        }
    }
}