package Game;

import java.util.Scanner;

public class Player {

    Scanner myScanner;
    String mark;

    public Player(String mark) {
        this.myScanner = new Scanner(System.in);
        this.mark = mark;
    }

    public String getInput() {
        return this.myScanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Input Testi");
        Player testPlayer = new Player("x");
        System.out.println(testPlayer.mark + " İşaretçisi için hamle girin");
        System.out.println(testPlayer.getInput());
    }
}
