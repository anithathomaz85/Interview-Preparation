package gts;

/**
 * What is thread and  Write the program for simple thread.
 * (just start the thread and print any think in run method)
 * **/


/*
* A Thread in Java is a lightweight process.
* It is the smallest unit of execution within a program.
* Threads allow multiple tasks to run concurrently,
* making applications faster and more responsive.
*/
public class Q029_SimpleThread {
	public static void main(String[] args) {
		SimpleThread thread = new SimpleThread();
		thread.start();		
	}
}

class SimpleThread extends Thread{
	public void run() {
		System.out.println("Hello Threads");
	}
}
