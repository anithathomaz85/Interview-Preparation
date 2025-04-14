package selfstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UnModifiableList {
	public static void main(String[] args) {
	
		Integer i = new Integer(1);
		int h = i.hashCode();
		System.out.println(h);
		
		List<Integer> al = new ArrayList<>(List.of(4, 1, 5, 2, 4));
		
		Collections.sort(al);
		System.out.println(al);
		
		List<Integer> list1 = List.of(3,2,8,4);
		//list1.add(10);
		List<Integer> list1_again_unmodifiable = Collections.unmodifiableList(list1);
		//list1_again_unmodifiable.add(10);
		List<Integer> list1_again_using_stream = list1.stream()
													.collect(Collectors.toUnmodifiableList());
		list1_again_using_stream.add(10);
	}
}

