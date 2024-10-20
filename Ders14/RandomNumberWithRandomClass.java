import java.util.Random;

public class RandomNumberWithRandomClass {
    public static void main(String[] args) {
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random integer
        int randomInt = random.nextInt(); // Generates any random integer
        System.out.println("Random integer: " + randomInt);

        // Generate a random integer between 0 (inclusive) and 100 (exclusive)
        int randomIntInRange = random.nextInt(100);
        System.out.println("Random integer between 0 and 99: " + randomIntInRange);

        // Generate a random double between 0.0 and 1.0
        double randomDouble = random.nextDouble();
        System.out.println("Random double between 0.0 and 1.0: " + randomDouble);

        // Generate a random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
    }

    public static void randomWithoutPackage() {
        // this does not require an import
        Random random = new Random();

        // Generate a random integer between 50 and 100
        int min = 50;
        int max = 100;
        int randomIntInRange = random.nextInt(max - min + 1) + min; // Includes max
        System.out.println("Random integer between 50 and 100: " + randomIntInRange);

        // Generate a random double between 1.0 and 10.0
        double randomDoubleInRange = 1.0 + (10.0 - 1.0) * random.nextDouble();
        System.out.println("Random double between 1.0 and 10.0: " + randomDoubleInRange);
    }
}
