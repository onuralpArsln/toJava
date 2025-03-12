package Game;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("x");
        Player player2 = new Player("o");
        XOXBoard board = new XOXBoard(player1, player2);
        board.run();

    }

}
