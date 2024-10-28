public class LinearTimeExample {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of elements: " + sum);
    }
}

// girdi boyutu arttıkça lineer artan bir işlem
// Constant Time - O(n)