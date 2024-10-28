public class ConstantTimeExample {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int element = arr[2]; // Accessing the third element
        System.out.println("Element at index 2: " + element);
    }
}

// girdi farketmeksizin aynı işlem yapılıyor
// Constant Time - O(1)