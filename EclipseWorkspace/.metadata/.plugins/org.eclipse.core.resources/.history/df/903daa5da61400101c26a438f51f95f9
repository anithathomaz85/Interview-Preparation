package evaluation;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountChars {
	public static void main(String[] args) {
		//["a", "bb", "ccc", "dd"]
		//{1=[a], 2=[bb, dd], 3=[ccc]}
		
		List<String> list = List.of("a", "bb", "ccc", "dd");
		
		
		Map<Integer,List<String>> result = list.stream()
				.collect(Collectors.groupingBy(str->str.length()));
		System.out.println(result);
		
		//second highestS
		List<Integer> list2 = List.of(2,4,3,1,6,7,10,9,5,8);
		int sencondLargest = list2.stream()
									.filter(n->n%2!=0)
									.map(n->n*10)
									.sorted(Comparator.reverseOrder())
									.skip(1)
									.findFirst()
									.orElse(null);	
		
		
		System.out.println("sencond Largest:"+sencondLargest);
		
		//apple a=1 p=2 l=1 e=1
		//orange o=1 r=1 a=1 n=1 g=1 e =1
		
		List<String> list3 = List.of("apple", "orange");
		System.out.println(list3.stream()				
				.collect(Collectors.groupingBy(word->(int)word.chars().count())));
		
	}

}
