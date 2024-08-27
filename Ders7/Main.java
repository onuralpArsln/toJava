
// bu imports sana ArrayListi verir
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Stringlerden Oluşan bir arraylist oluşturd
        ArrayList<String> names = new ArrayList<>();

        // .add methodu ile yeni eleman eklemek mümkün
        names.add("Alice");
        names.add("Bob");

        // index kullanarak elemanlara ulaşabilirsin bunu .get methodu ile yapacaksın
        System.out.println("First name: " + names.get(0));

        // for döngüsü yap
        for (String name : names) {
            System.out.println(name);
        }

        // Seçtiğin ismi silebilirsin
        names.remove("Alice");

        // for döngüsü yap
        for (String name : names) {
            System.out.println(name);
        }
    }
}
