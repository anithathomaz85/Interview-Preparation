package gts;

import java.util.HashMap;
import java.util.Map;

/*116. Alpha numeric string a123b23c. 
* find occurrence of each element (time complexity and space complexity)
*/

public class Q116_OccurrenceOfElement {
	public static void occurrenceOfElement(String str) {
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : str.toCharArray()) {
			if(ch!=' ') {
				map.put(ch, map.getOrDefault(ch, 0) +1);
			}
		}
		System.out.println("Occurrence Of Element");
		for(Map.Entry<Character, Integer> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey() + " -> " + entrySet.getValue());
		}
	}
public static void main(String[] args) {
	String str = "a123b23c";
	occurrenceOfElement(str);
}
}

/*
* Time Complexity: O(n)
* Space Complexity: O(k)
*/