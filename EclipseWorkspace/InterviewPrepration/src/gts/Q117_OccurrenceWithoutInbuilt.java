package gts;

/*
* 117. integer number 12312 find occurrence without using build in method.
*/
public class Q117_OccurrenceWithoutInbuilt {
 
	public static void main(String[] args) {
		
		int number = 12312;
		int[] freq = new int[10];
		
		while(number>0) {
			int digit = number%10;
			freq[digit]++;
			number /= 10;
		}
		System.out.println("Occurrence of elements");
		for(int i = 0; i<10 ; i++) {
			if(freq[i]>0) {
				System.out.println(i +" -> " +freq[i]);
			}
		}
		
	}
	
}