
public class Main {

    public static void main(String[] args) {

        MegaHunter hunter = new MegaHunter();
        hunter.CatchHunter();
        hunter.yell("fredrick");

    }
}

abstract class AbstractBaseHunter {

    public int health = 100;

    public abstract void CatchHunter();

    public void yell(String name) {
        System.out.println("vuaahh ben " + name);
    }

}

class MegaHunter extends AbstractBaseHunter {

    public void CatchHunter() {
        System.out.println("cathing survivors");
    };

}