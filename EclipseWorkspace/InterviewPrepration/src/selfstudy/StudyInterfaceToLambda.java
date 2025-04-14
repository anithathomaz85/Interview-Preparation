package selfstudy;

@FunctionalInterface
interface A{
	void show();
}

class Xyz implements A{

	@Override
	public void show() {
		System.out.println("Implementing Xyz show().");		
	}
	
}

public class StudyInterfaceToLambda {
	public static void main(String[] args) {
		
		
		A obj;
		
		//Scenario 1: Classic
		System.out.println("--------------------------------------------");
		obj = new Xyz();
		obj.show();
		System.out.println("--------------------------------------------");
		
			
		//Scenario 2: Anonymous Inner class
		System.out.println("--------------------------------------------");	
		obj = new A() {			
			@Override
			public void show() {
				System.out.println("Implementing Anonymous Inner class show().");
				
			}
		};
		obj.show();
		System.out.println("--------------------------------------------");
		
		
		//Scenario 3: Lambda exp
		System.out.println("--------------------------------------------");		
		obj = () ->
				System.out.println("Implementing Lambda  show().");
		obj.show();		
		System.out.println("--------------------------------------------");
		
	}

}

