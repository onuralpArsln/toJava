public class GeneGeneric {
    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();
        stringBox.set("merhaba");
        System.out.println("String Box" + stringBox.get());

        Box<Integer> intBox = new Box<>(42);
        System.out.println("Integer Box " + intBox.get());

        Box<Car> carBox = new Box<>();
        carBox.set(new Car("volvo", 1985));
        System.out.println("Car Box " + carBox.get());

    }
}

class Box<T> {
    private T value;

    public Box() {
    }

    public Box(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Car {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return model + " (" + year + ")";
    }
}
