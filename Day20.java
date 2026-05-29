import java.util.concurrent.*;
import java.util.*;

class Request implements Runnable {
    private int requestId;

    public Request(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Request " + requestId + " started by " + Thread.currentThread().getName());

            
            int processingTime = new Random().nextInt(3000) + 1000;
            Thread.sleep(processingTime);

            System.out.println("Request " + requestId + " completed in " + processingTime + " ms by " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Request " + requestId + " interrupted");
        }
    }
}

public class Day20 {

    public static void main(String[] args) {

        
        int maxThreads = 3;

        
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                maxThreads,        
                maxThreads,        
                0L,
                TimeUnit.MILLISECONDS,
                queue,
                new ThreadPoolExecutor.AbortPolicy() 
        );

        System.out.println("🚀 Server Started...\n");

        
        for (int i = 1; i <= 10; i++) {
            Request req = new Request(i);
            try {
                executor.execute(req);
                System.out.println("Request " + i + " submitted");
            } catch (RejectedExecutionException e) {
                System.out.println(" Request " + i + " rejected (Queue Full)");
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Server interrupted");
        }

        System.out.println("\n Server Stopped.");
    }
}