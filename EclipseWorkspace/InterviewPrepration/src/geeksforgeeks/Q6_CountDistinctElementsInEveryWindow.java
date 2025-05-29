package geeksforgeeks;

/**
 * Given an integer array arr[] and a number k. 
   Find the count of distinct elements in every window of size k in the array.

Examples:
Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q6_CountDistinctElementsInEveryWindow {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		System.out.println(countDistinct(arr, k)); // Output: [3, 4, 4, 3]
	}

	static ArrayList<Integer> countDistinct(int arr[], int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		result.add(map.size());

		for (int i = k; i < arr.length; i++) {
			int outElm = arr[i - k];
			map.put(outElm, map.get(outElm) - 1);
			if (map.get(outElm) == 0) {
				map.remove(outElm);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			result.add(map.size());
		}
		return result;
	}
}
