package gts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Find the flight paths between source to destination airport.
/*
	 List of airports {A, B, C, D, E}
	 Flight path list {A-C, B-D, B-C, B-E, A-B, C-D}
	 Available paths to go from A to D -> A-B-D, A-B-C-D, A-C-D
*/

public class Q036_FlightPath {
	 
		// Method to add flight connections
		private static void addFlight(Map<String, List<String>> graph, String from, String to) {
			graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
		}
	 
		// Recursive DFS to find all paths
		private static void findAllPaths(Map<String, List<String>> graph, String current, String destination,
			
			List<String> path, List<List<String>> allPaths) {
			if (current.equals(destination)) {
				allPaths.add(new ArrayList<>(path));
				return;
			}
	 
			if (!graph.containsKey(current))
				return;
	 
			for (String neighbor : graph.get(current)) {
				if (!path.contains(neighbor)) { // Avoid cycles
					path.add(neighbor);
					findAllPaths(graph, neighbor, destination, path, allPaths);
					path.remove(path.size() - 1); // Backtrack
				}
			}
		}
	 
		
		public static void main(String[] args) {
			// Step 1: Define the graph (flight map)
			Map<String, List<String>> graph = new HashMap<>();
			addFlight(graph, "A", "C");
			addFlight(graph, "B", "D");
			addFlight(graph, "B", "C");
			addFlight(graph, "B", "E");
			addFlight(graph, "A", "B");
			addFlight(graph, "C", "D");
	 
			String source = "A";
			String destination = "D";
	 
			List<String> currentPath = new ArrayList<>();
			List<List<String>> allPaths = new ArrayList<>();
	 
			currentPath.add(source);
	 
			// Step 2: Find all paths
			findAllPaths(graph, source, destination, currentPath, allPaths);
	 
			// Step 3: Print all valid paths
			System.out.println("Available paths from " + source + " to " + destination + ":");
			for (List<String> path : allPaths) {
				System.out.println(path);
			}
		}
}


