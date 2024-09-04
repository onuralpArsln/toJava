
// bu imports sana ArrayListi verir
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Stringlerden Oluşan bir arraylist oluşturduk
        ArrayList<String> names = new ArrayList<>();

        // .add method ile yeni eleman eklemek mümkün
        names.add("Alice");
        names.add("Bob");
        names.add("Calvin");
        names.add("Yoda");
        names.add("Benedict");

        // index kullanarak elemanlara ulaşabilirsin bunu .get methodu ile yapacaksın
        System.out.println("First name: " + names.get(0));

        // for döngüsü yap
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println(names);
        // Seçtiğin ismi silebilirsin
        names.remove("Alice");
        System.out.println(names);

        // bir elementi değiştirme
        names.set(0, "James");
        System.out.println(names);

        names.remove(1);
        System.out.println(names);
        System.out.println(names.size());

    }
}
