package gts;

import java.util.HashSet;
import java.util.Set;

public class Q022_DuplicateNumberInLinkedList {

    Node head;

    public static void main(String[] args) {
        Q022_DuplicateNumberInLinkedList obj = new Q022_DuplicateNumberInLinkedList();

        obj.addNode(12);
        obj.addNode(12);
        obj.addNode(14);
        obj.addNode(15);
        obj.addNode(14);
        obj.addNode(19);

        obj.findDuplicates();
    }


    private void findDuplicates() {
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        boolean found = false;

        while (curr != null) {
            if (!set.add(curr.data)) {
                System.out.println("Duplicate found : " + curr.data);
                found = true;
            }
            curr = curr.next;
        }

        if (!found) {
            System.out.println("No Duplicate found");
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

}
