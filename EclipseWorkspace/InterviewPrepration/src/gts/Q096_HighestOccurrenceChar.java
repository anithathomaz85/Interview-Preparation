package gts;

/**
 * Find highest occurrence character in you name?
 * */
public class Q096_HighestOccurrenceChar {

	public static void main(String[] args) {
		String name = "Ananya";
		name = name.toLowerCase();

		int[] freq = new int[256];

		// Count frequency of each character
		for (int i = 0; i < name.length(); i++) {
			freq[name.charAt(i)]++;
		}
		// Find the character with the highest frequency
		int max = -1;
		char result = ' ';

		for (int i = 0; i < name.length(); i++) {
			if (freq[name.charAt(i)] > max) {
				max = freq[name.charAt(i)];
				result = name.charAt(i);
			}
		}

		System.out.println("Character with highest occurrence: " + result);
		System.out.println("Number of occurrences: " + max);
	}
}