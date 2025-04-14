package evaluation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Output: {1=[a], 2=[bb, dd], 3=[ccc]}
public class CountChars2 {
		public static void main(String[] args) {
						
		List<String> test = Arrays.asList("a", "bb", "ccc", "dd");
		Map<Integer,List<String>> mapResult = test.stream().collect(Collectors.groupingBy(str->str.length()));
		System.out.println(mapResult);
	}
}