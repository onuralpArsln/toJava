import java.util.ArrayList;

public class ArrList {

    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        people.add("Mahmut");
        people.add("Mehmet");
        people.add("Ahmet");
        people.add("Samet");
        System.out.println(people);

        System.out.println(people.getFirst());
        System.out.println(people.getLast());
        System.out.println(people.get(2));
        System.out.println(people.size());

        people.set(0, "tumham");
        System.out.println(people);

        people.remove(0);
        System.out.println(people);

        for (String i : people) {
            System.out.println(i);
        }

        people.clear();
        System.out.println(people);

    }
}
