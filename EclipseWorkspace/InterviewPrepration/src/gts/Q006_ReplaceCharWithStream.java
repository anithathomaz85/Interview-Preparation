package gts;

import java.util.stream.Collectors;

/**
 * Replace character 'a' with 'n' in a given string using stream.
 * */
public class Q006_ReplaceCharWithStream {
	public static void main(String[] args) {
		
		attempt1();
		attempt2();
		attempt3();
		attempt4();
	}

	private static void attempt4() {
		String input ="Java Stream API";
		String result =  input.chars()
							.mapToObj(c->(char)c)
							.map(ch -> (ch == 'a' || ch == 'A') ? 'n' : ch)
							.map(String::valueOf)
							.collect(Collectors.joining());
		System.out.println(result);;
		
	}

	private static void attempt3() {
		String input ="Java Stream API";
		String result = input.chars()
							.mapToObj(c->(char)c)
							.map(ch-> {
			                    if (ch == 'a' || ch == 'A') {
			                        return 'n';
			                    } else if (ch == 'e') {
			                        return 'X';
			                    }
			                    return ch;
			                })
							.map(String::valueOf)
							.collect(Collectors.joining());
		System.out.println("Attempt3: "+result);
	}

	private static void attempt2() {
		String input ="java stream example";
		String result = input.chars()
							.mapToObj(c->(char)c)
							.map(ch -> (ch == 'a' || ch == 'A') ? 'n' : ch)
							.map(String::valueOf)
							.collect(Collectors.joining());
		
		System.out.println("Attempt2: "+result);	
	}

	private static void attempt1() {
		String input = "Hello n";
		String result = input.chars()
							.mapToObj(c->(char)c)
							.map(ch->ch=='a'?'n':ch)
							.map(String::valueOf)
							.collect(Collectors.joining());
		System.out.println("Attempt1: "+result);
	
		
	}
}
/**
	input.chars() 
		→ Converts the string into a stream of ASCII values.
	.mapToObj(c -> (char) c) 
		→ Converts each ASCII int back to a char.
	.map(ch -> ch == 'a' ? 'n' : ch) 
		→ Applies the replacement logic.
	.collect(Collectors.joining()) 
		→ Joins all characters back into a single string.
**/
