public class GenericCalculator {

    // Generic method to divide two numbers of type T
    public static <T extends Number> void divide(T a, T b) {
        try {
            double num1 = a.doubleValue();
            double num2 = b.doubleValue();

            if (num2 == 0.0) {
                throw new Exception("Cannot divide by zero!");
            }

            double result = num1 / num2;
            System.out.println("Result: " + result);

            // Simulated "else" logic after successful try
            System.out.println("Division successful!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Main method to test different cases
    public static void main(String[] args) {
        // Test 1: Valid division
        divide(20, 4); // Output: Result: 5.0

        // Test 2: Division by zero
        divide(10, 0); // Output: Error: Cannot divide by zero!

        // Test 3: Using Double types
        divide(15.0, 3.0); // Output: Result: 5.0

        // Test 4: Division with float and int mix
        divide(10.5f, 2); // Output: Result: 5.25
    }
}
