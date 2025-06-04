// A generic class with two type parameters
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void display() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        // String-Integer pair
        Pair<String, Integer> studentAge = new Pair<>("Alice", 20);
        studentAge.display();

        // Integer-String pair
        Pair<Integer, String> idName = new Pair<>(101, "Bob");
        idName.display();
    }
}
