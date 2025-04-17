package gts;

/*
* 112. Write a sample code for Thread implementation?
	Method 2 : By Implementing Runnable interface
*/
class MyRunnable implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("RunnableThread: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class Q112_ThreadSecondMethod {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable); // pass Runnable to Thread
		t1.start();

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
