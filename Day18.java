import java.util.LinkedList;
import java.util.Queue;


class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer full, Producer waiting...");
            wait();
        }

        queue.add(item);
        System.out.println("Produced: " + item);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer empty, Consumer waiting...");
            wait();
        }

        int item = queue.poll();
        System.out.println("Consumed: " + item);

        notifyAll();
        return item;
    }
}


class Producer extends Thread {
    private Buffer buffer;
    private int maxItems;

    public Producer(Buffer buffer, int maxItems) {
        this.buffer = buffer;
        this.maxItems = maxItems;
    }

    public void run() {
        try {
            for (int i = 1; i <= maxItems; i++) {
                buffer.produce(i);
                Thread.sleep(300);
            }
            System.out.println("Producer finished producing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Consumer extends Thread {
    private Buffer buffer;
    private int maxItems;

    public Consumer(Buffer buffer, int maxItems) {
        this.buffer = buffer;
        this.maxItems = maxItems;
    }

    public void run() {
        try {
            for (int i = 1; i <= maxItems; i++) {
                buffer.consume();
                Thread.sleep(500);
            }
            System.out.println("Consumer finished consuming.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Day18 {
    public static void main(String[] args) {

        int totalItems = 10; 
        Buffer buffer = new Buffer(3); 
        Producer producer = new Producer(buffer, totalItems);
        Consumer consumer = new Consumer(buffer, totalItems);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program finished successfully!");
    }
}