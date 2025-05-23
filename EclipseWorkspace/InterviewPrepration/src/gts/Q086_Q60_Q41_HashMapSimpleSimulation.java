package gts;

import gts.SimpleHashMap.Entry;

/**
 * HashMap Internal working
 * */
public class Q086_Q60_Q41_HashMapSimpleSimulation {
		
		public static void main(String[] args) {
			Q060_Q41_Q86_HashMapSimpleSimulation<String, String> map = new Q060_Q41_Q86_HashMapSimpleSimulation<>();

		    map.put("One", "1");
		    map.put("Two", "2");
		    map.put("Two", "22");
		    map.put("Three", "3");

		    System.out.println("One → " + map.get("One"));      // 1
		    System.out.println("Two → " + map.get("Two"));      // 22
		    System.out.println("Three → " + map.get("Three"));  // 3
		    System.out.println("Four → " + map.get("Four"));    // null
		}
	}


	