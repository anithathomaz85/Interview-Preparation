package gts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q133_CityCountSorter {

	    public static void main(String[] args) {

	        // List of cities
	        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Delhi", "Chennai", "Mumbai", "Delhi", "Pune");

	        // Count occurrences using groupingBy + counting
	        Map<String, Long> cityCount = cities.stream()
	                .collect(Collectors.groupingBy(city -> city, Collectors.counting()));

	        // Sort by:
	        // 1. Count descending
	        // 2. City name ascending if counts are same
	        cityCount.entrySet().stream()
	                .sorted(
	                    Comparator.comparing(Map.Entry<String, Long>::getValue).reversed() // sort by count descending
	                            .thenComparing(Map.Entry::getKey)                        // then by city name ascending
	                )
	                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
	    }
	}
