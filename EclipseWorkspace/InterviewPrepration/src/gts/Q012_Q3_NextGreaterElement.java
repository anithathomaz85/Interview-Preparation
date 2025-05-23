package gts;

import java.util.Arrays;
import java.util.Stack;
/**
 * Find the next big element in a give array 
 * and explain time complexity
 * */
public class Q012_Q3_NextGreaterElement {
	public static void main(String[] args) {
		
		int[] inputArr = {2,6,3,4,9,1,10}; // O/P {6,9,4,9,10,10,-1}
		int[] resultArr = nextGreaterElement(inputArr);
		System.out.println(Arrays.toString(resultArr));
	}

	private static int[] nextGreaterElement(int[] inputArr) {
		int[] result = new int[inputArr.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=inputArr.length-1;i>=0;i--) { 
			int element = inputArr[i];
			
			while (!stack.isEmpty() && stack.peek() < element) {
                stack.pop();
            }
             result[i] = stack.isEmpty() ? -1 : stack.peek();
             stack.push(element);			
		}
		return result;
	}

}
