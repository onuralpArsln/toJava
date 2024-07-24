
public class main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("bana arguman ver");
        } else if (args.length > 0) {
            System.out.println(args[0]);
            for (String kelime : args) {
                System.out.println(kelime);
            }

        }

    }

}