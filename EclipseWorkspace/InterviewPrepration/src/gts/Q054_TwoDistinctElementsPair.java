package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q054_TwoDistinctElementsPair {
	 
    /**
     * Finds all distinct pairs of integers in the array whose sum is 0.
     * Each pair is returned only once in sorted order (e.g., [-3, 3] not [3, -3]).
     *
     * @param arr the input integer array
     * @return a list of pairs whose sum is 0
     */
    public static List<List<Integer>> findZeroSumPairs(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniqueKeys = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
 
        for (int num : arr) {
            int opposite = -num;
 
            if (seen.contains(opposite)) {
                int a = Math.min(num, opposite);
                int b = Math.max(num, opposite);
                String key = a + ":" + b;
 
                if (uniqueKeys.add(key)) {
                    result.add(Arrays.asList(a, b));
                }
            }
 
            seen.add(num);
        }
 
        return result;
    }
 
    public static void main(String[] args) {
        int[] arr = {3, -3, 2, 4, -2, 7, -7, 1};
        List<List<Integer>> pairs = findZeroSumPairs(arr);
 
        System.out.println("Distinct zero-sum pairs:");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
