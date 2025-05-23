package gts;

/**
 * Find 2nd largest no
   int a[]= {1,2,3,6,5} 2nd largest Ans =5
 * */
public class Q040_SecondLargestNumber {
	public static void main(String[] args) {
		
		int[] a = { 1, 2, 3, 6, 5 };
 
		if (a.length < 2) {
			System.out.println("Array should have at least two elements");
			return;
		}
 
		int first = Integer.MIN_VALUE; 
		int second = Integer.MIN_VALUE;
 
		for (int num : a) { 
			if (num > first) {				
				second = first;
				first = num;
			} else if (num > second && num != first) {
				second = num;
			}
		}
 
		if (second == Integer.MIN_VALUE) { 
			System.out.println("There is no second largest number"); //{5, 5, 5, 5}
		} else {
			System.out.println("Second largest number is: " + second);
		}
	}
}
