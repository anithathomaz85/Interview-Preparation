package gts;

/*
* A base class has both default and arg constructor as private. Now a child
* class is extending it. THe child class has a public default constructor. Now
* from another class create an new Child object, var obj = new Child(); -->
* what will be the output."
* 
*/
public class Q053_InheritanceScenario {
	public static void main(String[] args) {
		var obj = new Child();
	}
}

class Child extends Base {
    public Child() {
        System.out.println("Public constructor of Child");
    }
}
class Base {
    /*private Base() {
        System.out.println("Private default constructor of Base");
    }*/
    
    protected Base() {
        System.out.println("Private default constructor of Base");
    }

    private Base(int x) {
        System.out.println("Private parameterized constructor of Base");
    }
}
