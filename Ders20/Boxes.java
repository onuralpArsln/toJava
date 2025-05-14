import java.util.ArrayList;

public class Boxes {

    public static void main(String[] args) {
        BoxHandler handler = new BoxHandler();
        Box<Integer> testBox1 = new Box<>();
        testBox1.value = 5;
        Box<String> testBox2 = new Box<>();
        testBox2.value = "Value";
        handler.getBox(testBox2);
        handler.getBox(testBox1);
        System.out.println(handler.holder);
    }
}

class Box<T> {
    public T value;

    @Override
    public String toString() {
        return value.toString();
    }
}

class BoxHandler {

    public ArrayList<Box<?>> holder = new ArrayList<>();

    public void getBox(Box<?> box) {
        this.holder.add(box);
    }

}