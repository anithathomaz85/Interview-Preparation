package gts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q027_ThreadPool {
	
	// Number of threads in the pool
	private static final int THREAD_COUNT = 5;
	
	 private static final int MAX_NUMBER = 100;
	
	public static void main(String[] args) {
		 // Create a fixed thread pool with THREAD_COUNT threads 
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
        // Submit tasks to the executor service
        for (int i = 1; i <= MAX_NUMBER; i++) {
            final int number = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " - Number: " + number);
            });
        }
        
        // Shut down the executor service
        executorService.shutdown();
	}

}
