
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            LongTask.timeConsumingTask();

        });

        thread.start();

        System.out.println("Main method continues execution");
        try {
            Thread.sleep(700); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main method still works");

    }
}

class LongTask {

    public static void timeConsumingTask() {
        System.out.println("TimeConsumingTask Started");
        // Simulate a long-running task
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TimeConsumingTask completed");

    }
}
