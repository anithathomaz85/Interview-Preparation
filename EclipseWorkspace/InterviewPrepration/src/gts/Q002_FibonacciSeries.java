package gts;

/**
 * Given a Number print Fibonacci till given n number  
   num = 6 output - 0,1,1,2,3,5 
 * 
 * */
public class Q002_FibonacciSeries {
	public static void main(String[] args) {		
		attempt1();	
	}

	private static void attempt1() {
		 int num = 6;
		 int first=0,second=1,next;
		 
		 //System.out.print(first+" "+second);
		 StringBuilder result = new StringBuilder();
	     result.append(first).append(" ").append(second);
		 for(int i=2;i<num;i++) {
			 next=first+second;
			 first=second;
			 second=next;
			 //System.out.print(" "+next);
			 result.append(" ").append(next);
		 }
	     System.out.println(result);		
	}
}
