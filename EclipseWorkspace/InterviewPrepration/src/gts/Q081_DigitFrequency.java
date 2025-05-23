package gts;

/*
*  Integer num = 5412324321;
	Count each repeated number in above integer without using built-in java functions
*/
public class Q081_DigitFrequency {
	public static void main(String[] args) {
		long num = 5412324321L; // Use long if the number is large
 
		int[] freq = new int[10]; // For digits 0-9
 
		while (num > 0) {
			int digit = (int) (num % 10); // Extract last digit
			freq[digit]++; // freq[digit] = freq[digit] + 1;
			num = num / 10; // Remove last digit
		}
 
		System.out.println("Repeated digits and their counts:");
		for (int i = 0; i < 10; i++) {
			if (freq[i] > 1) {
				System.out.println("Digit " + i + " = " + freq[i] + " times");
			}
		}
	}
}