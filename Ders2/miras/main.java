public class main {

    public static void main(String[] args) {
        System.out.println("test");
    }

}

class Parent {
    String name;
    String surname;

    public Parent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String GetFullName() {
        return this.name + " " + this.surname;
    }

    public void introduce() {
        System.out.println(" Merhaba, ben " + this.GetFullName());
    }

    public void dinner() {
        System.out.println("yemek hazır");

    }
}

class Child extends Parent {
    String favGame;

    public Child(String name, String surname, String favGame) {
        super(name, surname);
        this.favGame = favGame;
    }

    // overloaded
    public Child(String name, String surname) {
        super(name, surname);
        this.favGame = "fortnite";
    }

    @Override
    public void dinner() {
        System.out.println(this.favGame + " oynuyorum bitsin gelcem");
    }

}