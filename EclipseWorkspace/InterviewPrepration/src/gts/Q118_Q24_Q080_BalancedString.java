package gts;

import java.util.Stack;

/**
 *  Given String is balanced string or not
 * */
public class Q118_Q24_Q080_BalancedString {

	public static boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {

			switch (ch) {

			case '(': case '{': case '[':			
				stack.push(ch);
				break;

			case ')':
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
				break;

			case '}':
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
				break;

			}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String input = "{][()}";
		// String input = "({})";
		// String input = "({}";
		// String input = "({})";
		// String input = "({}";

		if (isBalanced(input)) {
			System.out.println("Balanced String");
		} else {
			System.out.println("Not Balanced");
		}
	}


}
