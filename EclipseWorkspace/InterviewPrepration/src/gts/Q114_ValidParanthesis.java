package gts;

import java.util.Stack;

/*
* 
114. (3+4) - valid
(a+g)+d) - invalid
{d+(a+e)+[x+y]} - valid, write a program to check given String have valid paranthesis ?
*/

public class Q114_ValidParanthesis {

	public static boolean isValid(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}

			else if (ch == ')' || ch == '}' || ch == ']') {

				if (stack.isEmpty()) {
					return false;
				}

				char top = stack.pop();

				// Check if the popped element matches with current closing
				if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
					return false;
				}
			}
		}

		// If stack is empty, all brackets matched
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		String input = "(3+4)"; // valid
		// String input = "(a+g)+d)"; // invalid
		// String input = "{d+(a+e)+[x+y]}"; // valid

		// String input = "[(])"; // invalid

		// String input = "((a+b)*c)"; // valid

		// String input = "[(a+b]*(c+d))"; // invalid

		if (isValid(input)) {
			System.out.println("Paranthesis are valid.");
		} else {
			System.out.println("Paranthesis are NOT valid.");
		}
	}
}
