package gts;

import java.util.Stack;

//https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
/**
 * Calculates the minimum number of chairs needed in a waiting room.
 * 'E' means a person enters and occupies a chair.
 * 'L' means a person leaves and frees a chair.
 */
public class Q007_WaitingRoomChairs {
	public static void main(String[] args) {
		
		approch1();
		approch2UsingStack();
		attempt();
	
	}

	private static void attempt() {
		String s = "ELELEEL";
		int currentChair=0;
		int maxChairs=0;
		
		for(char c:s.toCharArray()) {
			
			if(c=='E') {
				currentChair++;
				maxChairs = Math.max(currentChair, maxChairs);
			}else if(c=='L') {
				currentChair--;
			}
		}
		System.out.println(maxChairs);
		
	}

	
	private static void approch1() {
	   //String s = "ELEELEELLL"; 
	   //String s = "EEEEEEE";
		 String s = "ELELEEL";
		 
		    int currentChairs = 0;
		    int maxChairs = 0;
		    
		    for(char c:s.toCharArray()) {
		    	if(c=='E') {
		    		currentChairs++;
		    	    maxChairs = Math.max(maxChairs, currentChairs);
		    	}  else if (c == 'L') {
		            currentChairs--;
		    	}
		    }
		    System.out.println("Min chairs= "+maxChairs);
	}
	
	private static void approch2UsingStack() {
		String s = "ELELEEL";
		 
		Stack<Character> stack = new Stack<>();
	    int maxChairs = 0;
	    
	    for(char c:s.toCharArray()) {
	    	 if (c == 'E') {
	    		 stack.push(c);
	    		 maxChairs = Math.max(maxChairs, stack.size());
	    	 } else if (c == 'L') {
	                if (!stack.isEmpty()) {
	                    stack.pop(); 
	                }
	    	 }
	    }
	    System.out.println("Min chairs= "+maxChairs);
		
	}


}
