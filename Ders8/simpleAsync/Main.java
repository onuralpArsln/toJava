
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            LongTask.timeConsumingTask();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(700);
                    System.out.println("yan thread sayaci" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("for 1 bitti");

        });

        thread.start();

        System.out.println("Main method continues execution");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(700);
                System.out.println("main thread sayaci " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("for 1 bitti");

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
