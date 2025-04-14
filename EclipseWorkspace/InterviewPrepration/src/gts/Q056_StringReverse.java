package gts;

public class Q056_StringReverse {
	
	public static String stringReverse(String str) {
		String result = new StringBuilder(str).reverse().toString();
		return result;
	}
	
	public static String stringReverseSwap(String str) {
		
		char[] ch = str.toCharArray();
		int left=0;
		int right = ch.length - 1;
		while(left<right) {
			char temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			left++;
			right--;
		}
		return new String(ch);
		}
		
	public static String stringReverseStream(String str) {
		return new StringBuilder(str)
				.reverse()
				.toString();
	}
		
	
	public static void main(String[] args) {
		String str = "Hello World";
		
		stringReverse(str);
		System.out.println(stringReverse(str));
		
		System.err.println(stringReverseSwap(str));
		
		System.out.println(stringReverseStream(str));
	}
 
}
