package gts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Q133_CityCountSorterTest {

    @Test
    public void testCityCountSorted() {
        // Test case 1: Default cities
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Delhi", "Chennai", "Mumbai", "Delhi", "Pune");

        // Expected result
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("Delhi", 3L);
        expected.put("Mumbai", 2L);
        expected.put("Chennai", 1L);
        expected.put("Pune", 1L);

        // Get the sorted result from the method
        Map<String, Long> actual = Q133_CityCountSorter.getCityCountSorted(cities);

        // Assert that the expected result matches the actual result
        assertEquals(expected, actual, "The city counts should be sorted by count descending and city name ascending.");
    }

    @Test
    public void testEmptyList() {
        // Test case 2: Empty list of cities
        List<String> cities = new ArrayList<>();

        // Expected result: an empty map
        Map<String, Long> expected = new LinkedHashMap<>();

        // Get the sorted result from the method
        Map<String, Long> actual = Q133_CityCountSorter.getCityCountSorted(cities);

        // Assert that the result is empty
        assertEquals(expected, actual, "The city count for an empty list should be an empty map.");
    }

    @Test
    public void testSingleCity() {
        // Test case 3: List with a single city
        List<String> cities = Arrays.asList("Delhi");

        // Expected result: Delhi with count 1
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("Delhi", 1L);

        // Get the sorted result from the method
        Map<String, Long> actual = Q133_CityCountSorter.getCityCountSorted(cities);

        // Assert that the result matches the expected result
        assertEquals(expected, actual, "The city count for a single city should be 1.");
    }

    @Test
    public void testCitiesWithSameCount() {
        // Test case 4: Cities with the same count
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Chennai", "Pune");

        // Expected result: cities sorted alphabetically
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("Chennai", 1L);
        expected.put("Delhi", 1L);
        expected.put("Mumbai", 1L);
        expected.put("Pune", 1L);

        // Get the sorted result from the method
        Map<String, Long> actual = Q133_CityCountSorter.getCityCountSorted(cities);

        // Assert that the result matches the expected result
        assertEquals(expected, actual, "Cities with the same count should be sorted alphabetically.");
    }
}
