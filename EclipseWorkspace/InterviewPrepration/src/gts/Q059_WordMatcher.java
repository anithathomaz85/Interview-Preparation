package gts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/***
	Sentence : “Hi my name is Sandeep Kumar My nick Name is Sandy”
	InputWord : “m”
	Examples:
	m / mM / mmM ->  Kumar My Name
	an / na /nah / Nan -> Sandeep Name Sandy
	Ea / ae / eaEEae               -> Sandeep Name
	Output: List<String>
	
	               distinct words from sentence that matches input word.
	
	               Matching criteria : word should contain all the distinct characters of inputword irrespective of order of characters and irrespective of case
	
	               Ordering of autosuggestion result should be in the occurrence order
	
	                              [m] -> [my name Kumar Sandy]
	
	               For empty/null inputWord all words are matching
	Regex : [a-zA-Z0-9]+"
 * */

public class Q059_WordMatcher {

	public static List<String> findMatchingWords(String sentence, String inputWord) {
		if (sentence == null || sentence.isEmpty())
			return Collections.emptyList();

		Set<Character> requiredChars = new HashSet<>();
		if (inputWord != null) {
			for (char c : inputWord.toLowerCase().toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					requiredChars.add(c);
				}
			}
		}

		String[] words = sentence.split("[^a-zA-Z0-9]+");
		LinkedHashSet<String> result = new LinkedHashSet<>();

		for (String word : words) {
			String lowerWord = word.toLowerCase();
			boolean matches = true;

			for (char c : requiredChars) {
				if (!lowerWord.contains(String.valueOf(c))) {
					matches = false;
					break;
				}
			}

			if ((requiredChars.isEmpty() || matches)) {
				result.add(word);
			}
		}

		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		String sentence = "Hi my name is Sandeep Kumar My nick Name is Sandy";

		System.out.println(findMatchingWords(sentence, "m")); // [my, name, Kumar, My]
		System.out.println(findMatchingWords(sentence, "na")); // [name, Sandeep, Sandy]
		System.out.println(findMatchingWords(sentence, "Ea")); // [name, Sandeep]
		System.out.println(findMatchingWords(sentence, "")); // [Hi, my, name, is, Sandeep, Kumar, My, nick, Name, Sandy]
	}
}