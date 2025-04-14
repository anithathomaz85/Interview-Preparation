package selfstudy;

interface I {
	void show();

	default void print() {
		System.out.println("Showing I print()");
	}
}

interface J {
	void show();

	default void print() {
		System.out.println("Showing J print()");
	}

}

class C implements I, J {

	@Override
	public void show() {
		System.out.println("Showing C show()");
	}
	/*
	 * 
	 * public void print(){ System.out.println("Showing C print()"); }
	 */

	@Override
	public void print() {
		I.super.print(); // Call the print() method from interface I
		J.super.print(); // Call the print() method from interface J
	}

}

public class DiamondDemo {

	public static void main(String args[]) {
		I i = new C();
		i.show(); // Showing C show()
		i.print();// Showing C print(), if @Override public void print() is not there

	}
}
