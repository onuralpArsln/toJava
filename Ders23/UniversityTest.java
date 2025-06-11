class Staff {
    private int id;
    private String name;
    private String department;
    private double baseSalary;
    private String role;

    public Staff(int id, String name, String department, double baseSalary, String role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.role = role;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double addBonus() {
        return baseSalary + 250;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department +
                ", Role: " + role + ", Salary with Bonus: $" + addBonus());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Staff))
            return false;
        Staff s = (Staff) other;
        return this.role.equals(s.role);
    }
}

class Professor extends Staff {
    public Professor(int id, String name, String department, double baseSalary) {
        super(id, name, department, baseSalary, "Professor");
    }

    @Override
    public double addBonus() {
        return getBaseSalary() + 500;
    }
}

class Assistant extends Staff {
    public Assistant(int id, String name, String department, double baseSalary) {
        super(id, name, department, baseSalary, "Assistant");
    }

    @Override
    public double addBonus() {
        return getBaseSalary() + 150;
    }
}

// Main method to test
public class UniversityTest {
    public static void main(String[] args) {
        Professor p1 = new Professor(1, "Dr. Smith", "Computer Science", 6000);
        Assistant a1 = new Assistant(2, "Jane Doe", "Mathematics", 3500);
        Staff s1 = new Staff(3, "Mark Lee", "Physics", 4000, "Staff");

        p1.display();
        a1.display();
        s1.display();

        System.out.println(p1.equals(a1)); // false
        System.out.println(a1.equals(new Assistant(4, "Amy", "Biology", 3600))); // true
    }
}
