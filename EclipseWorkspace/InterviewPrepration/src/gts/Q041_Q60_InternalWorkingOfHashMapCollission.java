package gts;

import java.util.HashMap;
import java.util.Map;

/**
 * Internal working of hash map
 * 
 * */
public class Q041_Q60_InternalWorkingOfHashMapCollission {
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
 
		map.put("dog", "Barks");
		map.put("cat", "Meows");
		map.put("god", "Divine"); // might collide with "dog"
 
		// Display the map
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
 
		// Retrieving a value
		System.out.println("Get Dog: " + map.get("dog"));
 
		// Check hashCode and index simulation
		int hash = "dog".hashCode();
		int index = Math.abs(hash) % 16; // assuming default capacity 16
		System.out.println("\"dog\" hash: " + hash + ", Bucket index: " + index);
		System.out.println("--------------------------");
		int hash1 = "god".hashCode();
		int index1 = Math.abs(hash1) % 16; // assuming default capacity 16
		System.out.println("\"god\" hash: " + hash1 + ", Bucket index: " + index1);
 
		int hash2 = "cat".hashCode();
		int index2 = Math.abs(hash2) % 16; // assuming default capacity 16
		System.out.println("\"cat\" hash: " + hash2 + ", Bucket index: " + index2);
	}

}
