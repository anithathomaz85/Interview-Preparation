package selfstudy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceDemo {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("nitha","anitha","lal");
		
		
		Consumer<String> c = new Consumer<String>() {
			public void accept(String str) {
				System.out.println(str);
			}
		};
		
		names.forEach(c);
		
		//call by value
		names.forEach(str->System.out.println(str));
		
		//call by method - high order programming
		names.forEach(System.out::println); //method reference
		
	}

}
