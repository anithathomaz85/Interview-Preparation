package gts;
/**
 * 
 * Given an array which contains multiple 0,1 & 2. How to sort this array (time complexity).
 * */
public class Q085_Q13_DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0,1,0,1,0};
        sort012(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    public static void sort012(int[] arr) {
    	int low = 0, mid = 0;
		int high = arr.length - 1;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high--);
				break;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
