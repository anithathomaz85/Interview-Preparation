package gts;

public class Q135_SequentialThreads {

    public static void main(String[] args) {
        // Create the first thread
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: Count - " + i);
                try {
                    Thread.sleep(500); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread 1 finished.");
        });

        // Create the second thread
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: Count - " + i);
                try {
                    Thread.sleep(750); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread 2 finished.");
        });

        // Execute the first thread
        System.out.println("Starting Thread 1...");
        thread1.start();

        // Wait for the first thread to complete before starting the second
        try {
            thread1.join(); // The main thread will wait here until thread1 finishes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Execute the second thread after the first one has finished
        System.out.println("\nStarting Thread 2...");
        thread2.start();

        // Optionally, wait for the second thread to complete as well
        try {
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nBoth threads have finished executing sequentially.");
    }
}