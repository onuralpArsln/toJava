
public class Main {
    public static void main(String[] args) {
        // generic bir array oluşturduk
        GenericArray<Integer> intArray = new GenericArray<>(5);
        intArray.set(0, 10);
        System.out.println(intArray.get(0));
        System.out.println(intArray);
        intArray.set(1, 20);
        intArray.set(2, 30);
        intArray.set(3, 40);
        intArray.set(4, 50);
        System.out.println(intArray);
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

    // clasının printe tepkisini değiştiri
    @Override
    public String toString() {
        String result = "[";
        for (T element : this.array) {
            result = result + " " + element;

        }
        result += "]";
        return result;

    }
}
