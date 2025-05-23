package gts;

import java.util.LinkedList;

/**
 * Demonstrate how to search for specific values in a list 
 * and calculate the time complexity of the implemented solution.
 * */
public class Q079_SearchLinkedList {
	
	public static boolean searchValue(LinkedList<Integer> list, int target) {
        for (int num : list) {
            if (num == target) {
                return true; 
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);
        numbers.add(60);
        numbers.add(75);

        int target = 45;

       //Linear Search in LinkedList
		/**
		 * Time Complexity: O(n) → traverse node-by-node from head to tail		   			 
		 * */
        if (searchValue(numbers, target)) {
            System.out.println(target + " found in the LinkedList.");
        } else {
            System.out.println(target + " not found in the LinkedList.");
        }
    }

}
