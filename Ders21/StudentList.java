import java.util.ArrayList;

public class StudentList<T> {

    // Internal list to store student data
    private ArrayList<T> students = new ArrayList<>();

    // Method to add a student
    public void addStudent(T student) {
        students.add(student);
        System.out.println("Added: " + student);
    }

    // Method to remove a student by index
    public void removeStudent(int index) {
        try {
            T removed = students.remove(index);
            System.out.println("Removed student: " + removed);
            // Simulating an "else" block by only printing this if no exception
            System.out.println("Student removed successfully!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. No student removed.");
        }
    }

    // Method to print all students
    public void printStudents() {
        System.out.println("\nAll students:");
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (T student : students) {
                System.out.println("- " + student);
            }
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        StudentList<String> list = new StudentList<>();

        // Adding students
        System.out.println("Adding students...");
        list.addStudent("Alice");
        list.addStudent("Bob");
        list.addStudent("Charlie");

        // Removing a student (valid index)
        System.out.println("\nRemoving student at index 1:");
        list.removeStudent(1); // Should remove "Bob"

        // Removing a student (invalid index)
        System.out.println("\nTrying to remove student at index 5:");
        list.removeStudent(5); // Should cause error

        // Print all remaining students
        list.printStudents();
    }
}
