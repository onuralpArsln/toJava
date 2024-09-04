import java.util.concurrent.CompletableFuture;

public class MainAsync {
    public static void main(String[] args) {
        System.out.println("Start");

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> task1());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> task2());

        CompletableFuture.allOf(future1, future2).join(); // Wait for both tasks to complete

        System.out.println("End");
    }

    public static void task1() {
        try {
            Thread.sleep(2000); // Simulating a blocking operation
            System.out.println("Task 1 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task2() {
        System.out.println("Task 2 completed");
    }
}
