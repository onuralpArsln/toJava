import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // java stream api ile bir stream oluşturmak

        // List yapısından streama geçmek
        // girdiler ile bir liste yapısı oluştur, listeler arraydan çok daha dinamik
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");
        // bir string streamı oluştur, ve listeyi streama çevir
        Stream<String> stream = names.stream();

        // arraydan stream
        String[] nameArray = { "John", "Alice", "Bob" };
        Stream<String> arrayStream = Arrays.stream(nameArray);

        // direkt stream oluşturmak
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4);

        // sonsuz bir stream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);

        // streamler ile ne yapıyoruz?

        System.out.println("stream filitrelenebilir");
        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        System.out.println("üzerinde işlemler yapılabilir");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(nameLengths);

        System.out.println("üzerinde sıralama yapılabilir");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNames);

        System.out.println("üzerinde döngüler yapılabilir");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("farklı işlemler kolaylıkla arka arkaya yapılabilir");
        List<String> sorted = names.stream()
                .filter(name -> name.length() > 3)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

    }

}