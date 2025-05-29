package practice;

import java.util.ArrayList;
import java.util.List;

public class LinkedListOperations {
	static Node head;
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		print();
		addNodeToHead(0);
		print();
		addNodeToTail(5);	
		print();
		reverse();
		print();
		
		//Cycle
		System.out.println("Cycle detected: "+hasCycle());
		//head.next.next.next = head.next;
		System.out.println("Cycle detected: "+hasCycle());
		
		//mid
		System.out.println("Mid element: "+findMid());
	}
	
	
	static void addNodeToHead(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
	}
	
	static void addNodeToTail(int value) {
		Node node = new Node(value);
		Node current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next=node;
	}
	
	static void print() {
		Node current = head;
		while(current!=null) {
			System.out.print(current.value+(current.next!=null?" -> ":" -> null"));
			current = current.next;
		}
		System.out.println();
	}
	
	static void reverse() {
		
		Node current = head;
		Node prev = null;
		Node temp;
		
		while(current!=null ) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		head = prev;
	}
	
	
	static boolean hasCycle() {
		
		List<Node> visited = new ArrayList();
		Node current = head;
		
		while(current!=null) {
			if(visited.contains(current)) {
				return true; //cycle detected
			}
			visited.add(current);
			current = current.next;			
		}
		return false;		
		
	}
	
	static int findMid() {
		Node current = head;
		Node slow = current;
		Node fast = current;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.value;
	}
	

}
