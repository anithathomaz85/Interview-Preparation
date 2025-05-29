package evaluation;
/**
 * Write a program for Reverse a string without affecting special characters 
 * (Input:   str = "Wal@ma&rt"  Output:  str = "tra@ml&aW")
 * 
 * */
public class ReverseStringWithSpecialChars {
	public static void main(String[] args) {
		String str = "Wal@ma&rt";
		StringBuilder lettersOnly = new StringBuilder();
		char[] inputStr=str.toCharArray();
		for(int i=inputStr.length-1;i>=0;i--) {
			if(Character.isLetter(inputStr[i])) {
				lettersOnly.append(inputStr[i]);
			}
		}
		
		int index = 0;
		for(int i=0;i< inputStr.length;i++) {
			if(Character.isLetter(inputStr[i])) {
				inputStr[i] = lettersOnly.charAt(index++);
			}
		}
				
		System.out.println(new String(inputStr));
		
		System.out.println("=======================================");
		

	      
	      
	      char[] charArr = str.toCharArray();
	      int left=0; int right = charArr.length-1;
	      
	      while(left<right) {
	    	  if(!Character.isLetter(charArr[left])) {
	    		  left++;
	    	  }else if(!Character.isLetter(charArr[right])) {
	    		  right--;
	    	  }else {
	    		  char temp = charArr[left];
	    		  charArr[left] = charArr[right];
	    		  charArr[right] = temp;
	    		  left++;
	    		  right--;
	    	  }
	      }
	      System.out.println("Reversed: "+new String(charArr));
	      
	}
}
