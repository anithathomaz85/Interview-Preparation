package gts;

import java.util.HashMap;
import java.util.Map;

/**
 * find count of feature passed in each service
	input:	"Service1-Feture1-Passed"
	"Service1-Feture2-Failed"
	"Service2-Feture1-Passed"
	Service2-Feture2-Passed
	Ans- Service1- 1 
         Service2-2
 * 
 * */
public class Q038_FeaturePassed {
	public static void main(String[] args) {
		String[] input = { "Service1-Feture1-Passed", "Service1-Feture2-Failed", "Service2-Feture1-Passed",
				"Service2-Feture2-Passed" };
 
		Map<String, Integer> passCountMap = new HashMap<>();
 
		for (String line : input) {
			String[] parts = line.split("-");
 
			String service = parts[0];
			String status = parts[2];
 
			if (status.equalsIgnoreCase("Passed")) {
				passCountMap.put(service, passCountMap.getOrDefault(service, 0) + 1);
			}
		}
 
		// Print result
		for (Map.Entry<String, Integer> entry : passCountMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
