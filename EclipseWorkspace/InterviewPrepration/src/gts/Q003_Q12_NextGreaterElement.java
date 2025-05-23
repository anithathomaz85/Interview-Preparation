package gts;

import java.util.Arrays;
import java.util.Stack;

/**
 * Program to find the next big element in a given list and explain time/space complexity
   Input : {2,4,1,3,5};
   Output : [4,5,3,5,-1]
 * 
 * */

/**
 * Time Complexity: O(n)
		Each element is pushed once and popped at most once from the stack → O(n) overall.

   Space Complexity: O(n) (in worst case)
		The stack stores at most n elements if the array is strictly decreasing.
 * 
 * */

class Q003_Q12_NextGreaterElement {
	
	public static void main(String[] args) {
		
		approch1();
		approch2();
		attempt2();
	}

	private static void approch1() {
		
		int[] nums = {4,12,5,3,1,2,5,3,1,2,4,6};
		int[] nextGreaterElements = new int[nums.length];
		Stack<Integer> helperStack=new Stack<Integer>();
		
		for(int i=nums.length-1;i>=0;i--) {
			
			int element = nums[i];
			
			if(helperStack.isEmpty()) {
				helperStack.push(element);
				nextGreaterElements[i]=-1;
				continue;
			}			
			
			if(helperStack.peek()>element) {
				nextGreaterElements[i]=helperStack.peek();
				helperStack.push(element);
				continue;
			}
			
			while(!helperStack.isEmpty() && helperStack.peek()<=element) {
				helperStack.pop();
			}
			
			if(helperStack.isEmpty()) {
				nextGreaterElements[i]=-1;
			}
			else {
				nextGreaterElements[i] = helperStack.peek();
			}
			
			helperStack.push(element);
		}		
		System.out.println("Approch1: "+Arrays.toString(nextGreaterElements)); 
	}
	
	private static void approch2() {
		int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6}; //[Output: [12,-1,6,5,2,5,6,4,2,4,6,-1]
		 int n = arr.length;
	        int[] result = new int[n];  
	        Stack<Integer> stack = new Stack<>(); 

	        for (int i = n - 1; i >= 0; i--) {
	            // Pop smaller elements from the stack
	            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
	                stack.pop();
	            }

	            // If stack is empty, no greater element
	            result[i] = stack.isEmpty() ? -1 : stack.peek();
	            
	            // Push current element to stack
	            stack.push(arr[i]);
	        } 
		System.out.println("Approch2: "+Arrays.toString(result));
		
	}
	

	private static void attempt2() {
		int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6};
		 int n = arr.length;
	        int[] result = new int[n];  
	        Stack<Integer> stack = new Stack<>(); 

	        for (int i = n - 1; i >= 0; i--) {
	            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
	                stack.pop();
	            }
	            result[i] = stack.isEmpty() ? -1 : stack.peek();
	            stack.push(arr[i]);
	        }
	        System.out.println("Attempt2.2: "+Arrays.toString(result)); 
		
	}
}


