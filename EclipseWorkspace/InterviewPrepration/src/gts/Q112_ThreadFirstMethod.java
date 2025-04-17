package gts;

/*
*  Write a sample code for Thread implementation?
	Method 1 : By Extending Thread class
*/
class MyThread extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("MyThread: " + i);
			try {
				Thread.sleep(500); // pause for 0.5 seconds
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class Q112_ThreadFirstMethod {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start(); // starts the thread

		// Main thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("MainThread: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
