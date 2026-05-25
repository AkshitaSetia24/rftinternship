import java.util.Scanner;

class EvenRunnable implements Runnable {
    int limit;

    EvenRunnable(int limit) {
        this.limit = limit;
    }

    public void run() {
        for (int i = 2; i <= limit; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(400); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class OddRunnable implements Runnable {
    int limit;

    OddRunnable(int limit) {
        this.limit = limit;
    }

    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(400); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Day16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter limit: ");
        int limit = sc.nextInt();

        EvenRunnable evenTask = new EvenRunnable(limit);
        OddRunnable oddTask = new OddRunnable(limit);

        Thread t1 = new Thread(evenTask);
        Thread t2 = new Thread(oddTask);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Printing Completed ");
    }
}