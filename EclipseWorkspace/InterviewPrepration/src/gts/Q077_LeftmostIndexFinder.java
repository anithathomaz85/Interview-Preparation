package gts;
/**
 * {1,1,1,2,2,2,4,4,5,5,8,8,9,9} find index of the leftmost 5 , in this case is 8
 * 
 * */
/**
 * 	Index			0	1	2	3	4	5	6	7	8	9	10	11	12	13
	Value	Left	1	1	1	2	2	2	4	4	5	5	 8	 8	 9	 9	Right
	
	Leftmost 5 is at index 8 ✅
	Rightmost 5 is at index 9 ✅
 * */
public class Q077_LeftmostIndexFinder {
	public static void main(String[] args) {
       int[] arr = { 1, 1, 1, 2, 2, 2, 4, 4, 5, 5, 8, 8, 9, 9 };
        //int[] arr = { 1, 2, 2, 5, 5, 5 }; //R
        int target = 5;

        int leftLinear = findLeftmostLinear(arr, target);
        int leftBinary = findLeftmostBinary(arr, target);

        System.out.println("Leftmost index of " + target + " (Linear Search): " + leftLinear);
        System.out.println("Leftmost index of " + target + " (Binary Search): " + leftBinary);
    }

    // Linear Search: O(n) time, O(1) space
    public static int findLeftmostLinear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    // Binary Search: O(log n) time, O(1) space
    public static int findLeftmostBinary(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result; 
    }
}
