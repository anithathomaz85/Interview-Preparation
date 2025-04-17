package gts;

import java.util.Stack;

/**
 * ({}) -> correct syntax.
   ({} -> syntax is wrong because ) is missing. 
   How can we detect if the syntax is wrong due to missing parentheses )
 * */
public class Q080_Q24_Q118_BalancedString {
	 
	public static boolean isBalanced(String str) {
		
		Stack<Character> stack = new Stack<>();		
		for(char ch : str.toCharArray()) {			
			switch(ch) {			
			case '(' : case '{' : case '[' :
				stack.push(ch);
				break;				
			case ')' :
				if(stack.isEmpty() || stack.pop() != '(') return false;
				break;				
			case '}' :
				if(stack.isEmpty() || stack.pop() != '{') return false;
				break;
			 case ']':
                if (stack.isEmpty() || stack.pop() != '[') return false;
                break;			
			}			
		}		
		return stack.isEmpty();
	}
	
	public static boolean isLooselyBalanced(String str) {
       int roundOpen = 0, roundClose = 0;
       int curlyOpen = 0, curlyClose = 0;
       int squareOpen = 0, squareClose = 0;

       for (char ch : str.toCharArray()) {
           switch (ch) {
               case '(': roundOpen++; break;
               case ')': roundClose++; break;
               case '{': curlyOpen++; break;
               case '}': curlyClose++; break;
               case '[': squareOpen++; break;
               case ']': squareClose++; break;
           }
       }

       return roundOpen == roundClose &&
              curlyOpen == curlyClose &&
              squareOpen == squareClose;
   }
	
	public static void main(String[] args) {
		//String input = "{][()}";
		//String input = "({})";
		//String input = "({}";
		String input = "({})";

	
		
		 if (isBalanced(input)) {
	            System.out.println("Correct syntax");
	        } else {
	            System.out.println("Wrong syntax");
	        }
		 
		 if (isLooselyBalanced(input)) {
	            System.out.println("Actually, Correct syntax.");//Bracket counts match, but order may be wrong.
	        } else {
	            System.out.println("Actually, Wrong syntax");
	        }
	}
}
