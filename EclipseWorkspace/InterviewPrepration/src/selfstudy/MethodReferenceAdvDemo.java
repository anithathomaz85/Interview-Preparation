package selfstudy;

interface Parser{
	String parse(String s);
}

class StringParser{	
	public static String conert(String s) {
		if(s.length()>3){
			s = s.toUpperCase();
		}else {
			s=s.toLowerCase();
		}
		return s;
	}	
}

class MyPrinter{	
	public void print(String s,Parser p) {
		s=p.parse(s);
		System.out.println(s);
	}
}

public class MethodReferenceAdvDemo {
	public static void main(String[] args) {	
		
/*	
		Parser parser =new Parser() {
			public String parse(String s) {
				return StringParser.conert(s);
			}
		};
		
		MyPrinter p = new MyPrinter();
		p.print("Anitha Thomas",parser);	
*/	
		
/*
		MyPrinter p = new MyPrinter();
		p.print("Anitha Thomas",new Parser() {
			public String parse(String s) {
				return StringParser.conert(s);
			}
		});
		//Inside the parser, we are converting string using convert()
		
*/
		
/*
		MyPrinter p = new MyPrinter();
		p.print("Anitha Thomas", s-> StringParser.conert(s));
*/		
		

		MyPrinter p = new MyPrinter();
		p.print("Anitha Thomas",StringParser::conert);
		p.print("Ani",StringParser::conert);// passing a method
		
		
		//effectively becomes equivalent to writing
		//p.print("Anitha Thomas", (s) -> StringParser.conert(s));
		
		/*Why This Works:
		/A functional interface can be implemented using a method reference 
		 * if the referenced method's signature [String conert(String s) ]
		 * matches 
		 * the interface's method signature.[String parse(String s)]
		*/
		
	}
}
