
public class loops {

    public static void main(String[] args) {

        int val = 9;

        if (val > 9) {
            System.out.println("val 9 dan büyük");
        } else if (val == 9) {
            System.out.println("val 9 değerine eşittir");

        } else {
            System.out.println("val 9 dan küçük");
        }

        for (int i = 1; i < 16; i = i * 2) {
            System.out.println("current loop is " + i);
        }

        String[] hello = { "hello", "world" };
        int[] numbers = { 1, 2, 3, 4, 2 };

        for (String string : hello) {
            System.out.println(string);

        }

    }
}
