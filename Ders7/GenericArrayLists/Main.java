
public class Main {
    public static void main(String[] args) {
        // Create a GenericArray for Integers
        GenericArray<Integer> intArray = new GenericArray<>(5);
        intArray.set(0, 10);
        System.out.println(intArray.get(0));
    }
}

class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        // Create a new generic array of type T
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index) {
        return array[index];
    }
}