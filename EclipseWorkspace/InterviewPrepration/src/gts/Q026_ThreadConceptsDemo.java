package gts;

import java.util.Random;

class ThreadExample extends Thread {
    public ThreadExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is starting.");
        try {
            // Simulate work with sleep
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
        System.out.println(getName() + " has finished.");
    }
}

// Class demonstrating thread creation by implementing Runnable
class RunnableExample implements Runnable {
    private String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is starting.");
        try {
            // Simulate work with sleep
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
        System.out.println(name + " has finished.");
    }
}

// Class demonstrating synchronization
class SharedResource {
    public synchronized void synchronizedMethod(String threadName) {
        System.out.println(threadName + " is entering synchronized method.");
        try {
            Thread.sleep(500); // Simulate some work
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted during synchronized method.");
        }
        System.out.println(threadName + " is leaving synchronized method.");
    }
}

public class Q026_ThreadConceptsDemo {
    public static void main(String[] args) {
        // Creating threads using Thread subclass
        Thread thread1 = new ThreadExample("Thread-1");
        Thread thread2 = new ThreadExample("Thread-2");

        // Creating threads using Runnable implementation
        Thread thread3 = new Thread(new RunnableExample("Thread-3"));
        Thread thread4 = new Thread(new RunnableExample("Thread-4"));

        // Starting all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Demonstrating join()
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Demonstrating synchronization
        SharedResource sharedResource = new SharedResource();
        Thread thread5 = new Thread(() -> sharedResource.synchronizedMethod("Thread-5"));
        Thread thread6 = new Thread(() -> sharedResource.synchronizedMethod("Thread-6"));

        thread5.start();
        thread6.start();

        // Demonstrating interrupt()
        thread5.interrupt();
    }
}
