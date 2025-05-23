package gts;

import java.util.HashMap;
import java.util.Map;

public class Q025_CountStringCharacters {
	public static void main(String[] args) {
		String str = "Hello World";
		countCharacter(str);
	}

	private static void countCharacter(String str) {
		Map<Character, Integer> map = new HashMap();
		
		for(char ch:str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		System.out.println(map);
	}
}
