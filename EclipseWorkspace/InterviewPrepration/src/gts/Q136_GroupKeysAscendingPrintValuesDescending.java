package gts;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Program in descending we need to group the keys in ascending order and print.
 * 
 * */

public class Q136_GroupKeysAscendingPrintValuesDescending {
	public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Banana");
        map.put(1, "Apple");
        map.put(5, "Mango");
        map.put(2, "Grapes");
        map.put(4, "Orange");
 
        // Step 1: Sort by keys (ascending)
        Map<Integer, String> sortedByKeys = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
 
        // Step 2: Get the values and sort in descending order
        List<String> valuesDesc = sortedByKeys.values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
 
        // Step 3: Print results
        System.out.println("Grouped keys in ascending order:");
        System.out.println(sortedByKeys.keySet());
 
        System.out.println("Values in descending order:");
        valuesDesc.forEach(System.out::println);
    }

}
