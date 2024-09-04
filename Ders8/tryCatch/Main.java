public class Main {
    public static void main(String[] args) {

        ArrayProblem.createArrayProblem(10000, 0);

    }
}

class MathProblem {

    public static void createMathProblem(int a, int b) {
        try {

            int result = a / b; // use b=0 to test
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            System.out.println("Burasi hep calisir B ye sifir vermeyi dene");
        }

    }

}

class ArrayProblem {
    public static void createArrayProblem(int a, int b) {

        try {
            int[] arr = new int[5];
            arr[a] = 100; // A yı büyük ver burası bozulsun
            System.out.println(arr[a] / b); // b yi sıfır ver bura bozulsun
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }

    }

}
