import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    public static void main(String[] args) {
        // Create a HashMap to store student names and their grades
        HashMap<String, Integer> grades = new HashMap<>();

        // Adding entries to the HashMap
        grades.put("Alice", 85);
        grades.put("Bob", 90);
        grades.put("Charlie", 78);

        // Accessing a value using the key
        System.out.println("Grade of Alice: " + grades.get("Alice"));

        // Iterating through the HashMap
        System.out.println("All student grades:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Checking if a key or value exists
        if (grades.containsKey("Bob")) {
            System.out.println("Bob's grade is available.");
        }

        if (grades.containsValue(100)) {
            System.out.println("Someone scored 100!");
        } else {
            System.out.println("No one scored 100.");
        }

        // Removing a student
        grades.remove("Charlie");

        System.out.println("After removal:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
