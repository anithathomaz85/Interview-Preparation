package gts;

/*
*  Write a program for Reverse a string without affecting special characters 
*  (Input:   str = "Wal@ma&rt"  Output:  str = "tra@ml&aW")
*/
public class Q031_ReverseString {
	 
	public static void main(String[] args) { 
		String str = "Wal@ma&rt"; 
		String result = reverseStringWithoutSpecialChar(str); 
		System.out.println("Reversed String : " + result);
	}
 
	public static String reverseStringWithoutSpecialChar(String str) {
 		char[] arr = str.toCharArray(); 
		int left = 0; 
		int right = arr.length - 1;
 
		while (left < right) {
 
			if (!Character.isLetter(arr[left])) {
				left++;
			}else if (!Character.isLetter(arr[right])) {
				right--;
			}else {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
 		return new String(arr);
	}
}
