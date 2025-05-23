package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Write a program find middle element of list (not using inbuilt function)
 * **/
public class Q030_MiddleElementOfArrayList {
	public static void main(String[] args) {
		
		
		int middle=0;
		List<Integer> list= new ArrayList<Integer>(Arrays.asList(10,20,30,40,50));
		middle = findMiddle(list);
		System.out.println("Middle element: " + middle);
		middle = findMiddleElementUsing2PointerApproch(list);
		System.out.println("Middle element using 2 pointer: " + middle);
	}

	private static int findMiddle(List<Integer> list) {
		int size = getSize(list);
		int middleIndex = size/2;
		int index=0;
		int middleElement=0;
		for(int element:list) {
			if(index==middleIndex) {
				middleElement= element;
				break;			
			}
		index++;
		}
		return middleElement;
	}

	private static int getSize(List<Integer> list) {
		int count = 0;
		for(int i:list) {
			count++;
		}
		return count;
	}
	
	private static Integer findMiddleElementUsing2PointerApproch(List<Integer> list) {
		
        if (list == null || !list.iterator().hasNext()) {
            return null; // Return null if the list is empty
        }

        Iterator<Integer> slow = list.iterator();
        Iterator<Integer> fast = list.iterator();

        // Move fast iterator two steps and slow iterator one step at a time
        while (fast.hasNext()) {
            fast.next(); // Move fast one step
            if (fast.hasNext()) {
                fast.next(); // Move fast a second step
                slow.next(); // Move slow one step
            }
        }
       
        return slow.next();
    }

}
