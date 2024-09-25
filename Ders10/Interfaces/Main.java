
public class Main {
    public static void main(String[] args) {

        Basic basicTest = new Basic();
        Complex complexTest = new Complex();
        complexTest.value = 132;

        complexTest.run();

        Evaluater.runElement(complexTest);
        // Evaluater.runElement(basicTest);

    }
}

interface MySpecialInterface {

    void run();
}

class Basic {
    int value;
}

class Complex implements MySpecialInterface {
    int value;

    @Override
    public void run() {
        System.out.println("This has value of " + this.value);
    }
}

class Evaluater {

    static void runElement(MySpecialInterface element) {
        element.run();
    }
}