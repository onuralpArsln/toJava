import java.util.ArrayList;

public class Wrap {

    public static void main(String[] args) {
        Integer x = 123;
        System.out.println(x.toString());// "123"

        // nullable
        int a = null; // hata
        Integer b = null;

        int testint = 5;
        Integer wraptest = testint; // autoboxing
        int unwrap = wraptest; // unboxing

        Integer nullpointer = null;
        int y = nullpointer; // nullpointer errorr


        ArrayList<int> list = new ArrayList<>(); 
        ArrayList<Integer> list = new ArrayList<>();

    }
}