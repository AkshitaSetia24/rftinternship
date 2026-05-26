import java.util.*;
import java.util.concurrent.*;

class TaskSchedulerSystem {

    
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    
    private Map<Integer, ScheduledFuture<?>> taskMap = new HashMap<>();
    private int taskId = 1;

    
    public void addTask(String taskName, int delay) {
        int id = taskId++;

        ScheduledFuture<?> future = scheduler.schedule(() -> {
            System.out.println("Task " + id + " (" + taskName + ") executed after " + delay + " sec");
        }, delay, TimeUnit.SECONDS);

        taskMap.put(id, future);
        System.out.println("Task " + id + " scheduled!");
    }

    
    public void addRepeatingTask(String taskName, int initialDelay, int period) {
        int id = taskId++;

        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating Task " + id + " (" + taskName + ") running...");
        }, initialDelay, period, TimeUnit.SECONDS);

        taskMap.put(id, future);
        System.out.println("Repeating Task " + id + " scheduled!");
    }

    
    public void cancelTask(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.get(id).cancel(true);
            System.out.println("Task " + id + " cancelled!");
        } else {
            System.out.println("Task ID not found!");
        }
    }

    
    public void shutdown() {
        scheduler.shutdown();
        System.out.println("Scheduler stopped.");
    }
}

public class Day17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskSchedulerSystem system = new TaskSchedulerSystem();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Add Repeating Task");
            System.out.println("3. Cancel Task");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter delay (seconds): ");
                    int delay = sc.nextInt();

                    system.addTask(name, delay);
                    break;

                case 2:
                    System.out.print("Enter task name: ");
                    String rname = sc.nextLine();

                    System.out.print("Initial delay: ");
                    int init = sc.nextInt();

                    System.out.print("Repeat every (seconds): ");
                    int period = sc.nextInt();

                    system.addRepeatingTask(rname, init, period);
                    break;

                case 3:
                    System.out.print("Enter Task ID to cancel: ");
                    int id = sc.nextInt();
                    system.cancelTask(id);
                    break;

                case 4:
                    system.shutdown();
                    System.exit(0);
            }
        }
    }
}