package evaluation;

@FunctionalInterface
interface MultiplyService{
	int multiplyDigits(int a, int b);
}

public class MultiplicationUsingFP {
	public static void main(String[] args) {
		
		MultiplyService m = ( a,  b) ->	 a*b;		
		System.out.println("Product="+ m.multiplyDigits(10, 5));
		
	}

}
