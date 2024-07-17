
public class Runner {
    public String name;

    public Runner(String isim) {
        this.name = isim;
        System.out.println("merhaba ben " + this.name + ",  olustum");
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println(args[0]);
        }

        salut();
        salut("ali");
        Runner test = new Runner("Alp");
        test.selam();

        Runner test2 = new Runner("Deniz");
        test2.selam();
    }

    public static void salut() {
        System.out.println("merhaba");
    }

    public static void salut(String ad) {
        System.out.println("nasilsin " + ad);
    }

    public void selam() {
        System.out.println("MERHABA " + this.name);
    }

}
