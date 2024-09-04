
public class MainSync {
    public static void main(String[] args) {
        System.out.println("Start");
        task1();
        task2();
        System.out.println("End");
    }

    public static void task1() {
        try {
            Thread.sleep(1500);
            System.out.println("Task 1 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task2() {
        try {
            Thread.sleep(900);
            System.out.println("Task 2 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
