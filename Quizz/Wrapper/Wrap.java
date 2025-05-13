import java.util.ArrayList;

public class Wrap {

    public static void main(String[] args) {
        Integer x = 123;
        System.out.println(x.toString());// "123"
       
        // nullable
        double a = null; // hata
        Double b = null;

        double testint = 5.0;
        Double wraptest = testint; // autoboxing
        double unwrap = wraptest; // unboxing

        Integer nullpointer = null;
        int y = nullpointer; // nullpointer error


        ArrayList<int> list = new ArrayList<>(); 
        ArrayList<Integer> list = new ArrayList<>();

    }
}