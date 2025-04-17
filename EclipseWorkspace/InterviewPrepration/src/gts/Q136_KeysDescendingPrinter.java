 package gts;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.TreeMap;

 /**
  * Program in descending we need to group the keys in ascending order and print.
  * 
  * The requirement is to 
  * take a map (like a HashMap) as input, where the keys might be in any order. 
  * 
  * The program needs to:
	Group the keys in ascending order internally. 
	This implies some form of sorting or using a data structure that maintains keys in sorted order.
	Print the key-value pairs in descending order of the keys. 
	This means that even though the keys were internally handled in ascending order, 
	the final output should show the key-value pairs starting from the largest key down to the smallest key.
  * */
 public class Q136_KeysDescendingPrinter { 
     public static void main(String[] args) {
    	 
         // Example Usage 1: HashMap with String keys and String values
         HashMap<String, String> map1 = new HashMap<>();
         map1.put("zebra", "black and white");
         map1.put("antelope", "brown");
         map1.put("baboon", "various");
         map1.put("cheetah", "spotted");
         map1.put("elephant", "grey");

         System.out.println("--- Example 1 (String Keys): ---");
         printKeysDescending(map1);
         System.out.println();

         // Example Usage 2: HashMap with Integer keys and String values
         HashMap<Integer, String> map2 = new HashMap<>();
         map2.put(5, "five");
         map2.put(1, "one");
         map2.put(3, "three");
         map2.put(2, "two");
         map2.put(4, "four");

         System.out.println("--- Example 2 (Integer Keys): ---");
         printKeysDescending(map2); 
         System.out.println();

         // Example Usage 3: HashMap with String keys and Integer values
         HashMap<String, Integer> map3 = new HashMap<>();
         map3.put("x", 24);
         map3.put("b", 2);
         map3.put("a", 1);
         map3.put("y", 25);
         map3.put("c", 3);

         System.out.println("--- Example 3 (String Keys, Integer Values): ---");
         printKeysDescending(map3);
     }

     // Generic method to handle Maps with Comparable keys and any type of values
     public static <K extends Comparable<? super K>, V> void printKeysDescending(Map<K, V> inputMap) { 
         // Use TreeMap to automatically sort keys in ascending order
         TreeMap<K, V> sortedMap = new TreeMap<>(inputMap);

         // Extract the sorted keys into a List
         List<K> sortedKeys = new ArrayList<>(sortedMap.keySet());

         // Iterate through the sorted keys in descending order
         for (int i = sortedKeys.size() - 1; i >= 0; i--) {
             K key = sortedKeys.get(i);
             V value = sortedMap.get(key);
             System.out.println("Key: " + key + ", Value: " + value);
         }
     }
 }
