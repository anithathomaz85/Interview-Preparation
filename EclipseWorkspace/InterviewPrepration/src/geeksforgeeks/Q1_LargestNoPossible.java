package geeksforgeeks;

/**
 * Given two numbers n and s , find the largest number that can be formed with n
 * digits and whose sum of digits should be equals to s. Return -1 if it is not
 * possible.
 * 
 * Input: n = 2, s = 9 Output: 90
 * 
 * Input: n = 3, s = 20 Output: 992
 * 
 * Input: n = 1, s = 0 Output: 0
 **/
public class Q1_LargestNoPossible {
	public static void main(String[] args) {
		int n = 2, s = 9;
		String largestNo = findLargest(n, s);
		System.out.println("Largest No Possible: " + largestNo);
	}

	static String findLargest(int n, int s) {

		if (s == 0) {
			return (n == 1) ? "0" : "-1";
		}

		if (s > 9 * n) {
			return "-1";
		}

		StringBuilder result = new StringBuilder();

		for (int i = 0; i <= n; i++) {
			int digit = Math.min(9, s);
			result.append(digit);
			s -= digit;
		}

		return result.toString();
	}
}