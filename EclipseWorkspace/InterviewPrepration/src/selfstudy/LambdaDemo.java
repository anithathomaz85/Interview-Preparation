package selfstudy;

@FunctionalInterface
interface A1{
	void show();		
}


class Xyx implements A1{
	@Override
	public void show() {	
		System.out.println("Hello");
	}
}

public class LambdaDemo {	
	public static void main(String args[]) {		
		A1 obj;/*
		
		obj = new A() {
			public void show() {	
				System.out.println("Hello");
			}
		};*/
		
		obj = ()->System.out.println("Hello");
		obj.show();
		
	}
}

