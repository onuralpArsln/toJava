
public class Main {
    public static void main(String[] args) {
        Map testMap = new Map(3);

        InGameObjects obj1 = new InGameObjects(20, 18);
        NewEngine obj2 = new NewEngine(300, 400);
        InGameObjects obj3 = new InGameObjects(45, 900);

        InGameObjects[] arr = { obj1, obj2, obj3 };

        DependecyInjectedMap betterMap = new DependecyInjectedMap(arr);
    }
}

class Map {
    int width = 1000;
    int height = 100;
    int depth = 1000;

    public Map(int objectCount) {

        for (int i = 0; i < objectCount; i++) {
            InGameObjects temp = new InGameObjects((this.depth / objectCount) * i, (this.depth / objectCount) * i);
            System.out.println("obj create");
            System.out.println(temp);
        }

    }

}

class DependecyInjectedMap {
    int width = 1000;
    int height = 100;
    int depth = 1000;

    public DependecyInjectedMap(InGameObjects[] inGameObj) {
        for (InGameObjects obj : inGameObj) {
            System.out.println(obj);
        }

    }

}

class InGameObjects {
    int repair = 10;
    int width = 5;
    int height = 5;
    int depth = 5;
    final int locX;
    final int locY;

    public InGameObjects(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;
    }

}

class NewEngine extends InGameObjects {
    int requredReparingPerson = 2;

    public NewEngine(int locX, int locY) {
        super(locX, locY);
    }

    public void makeSound() {
        System.out.println("wroom wroom");
    }

}