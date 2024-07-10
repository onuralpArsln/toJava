
public class Runner {

    public static void main(String[] args) {

        System.out.println("Merhaba Dunya");

        if (true) {
            System.out.println("Merhaba Dunya");
        }

        sword.swordBase testSword = new sword.swordBase();
        System.out.println(testSword.weight);
        System.out.println(testSword.damage);

        testSword.damage = 12;

        System.out.println(testSword);

        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("no args given");
        }

        Runner obj = new Runner();
        String a = obj.nameGiver();
        System.out.println(a);

        String b = Runner.betterNameGiver();
        System.out.println(b);

    }

    // statik bir method değil
    // obje üreterek kullanılır
    public String nameGiver() {
        return "name";
    }

    // statik bir method direkt kullanılır
    public static String betterNameGiver() {
        return "name2";
    }

}

// javac Runner.java diyerek compile edersin
// java Runner diyerek yürütürsün
// java Runner arg ile argüman verirsin

// komutları terminalden veriyorsan doğru klasörde olduğundan emin ol

// eğer kodda bir değişiklik yaparsan javac ile derlemeden etki etmez