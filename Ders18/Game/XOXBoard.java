package Game;

public class XOXBoard implements Runnable {
    String[][] spaces = new String[3][3];
    Player[] playerList = new Player[2];

    public static void main(String[] args) {
        System.out.println("Board Init Test");
        Player player1 = new Player("x");
        Player player2 = new Player("o");
        XOXBoard testBoard = new XOXBoard(player1, player2);
        testBoard.displayBoard();

    }

    public XOXBoard(Player player1, Player player2) {
        playerList[0] = player1;
        playerList[1] = player2;

        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spaces[i][j] = Integer.toString(counter);
                counter++;
            }
        }
    }

    public void run() {
        int currentTurn = 0;
        String currentInput;
        int currentMove;
        int validMoveCount = 0;
        boolean isGameOn = true;
        while (isGameOn) {
            this.displayBoard();
            System.out.println("Oyuncu " + (currentTurn + 1) + " sırası " + playerList[currentTurn].mark);
            currentInput = playerList[currentTurn].getInput();
            currentMove = this.move(currentInput);
            if (this.isMoveValid(currentMove)) {
                this.playMove(currentMove, playerList[currentTurn]);
                currentTurn = currentTurn == 0 ? 1 : 0;
                validMoveCount++;
                System.out.println(validMoveCount);
                if (this.endDetect(validMoveCount)) {
                    isGameOn = false;

                }

            } else {
                System.err.println("Hatalı Hamle tekrar oyna");
            }
        }

    }

    public Boolean endDetect(int moveCount) {
        if (moveCount < 5) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (spaces[i][j] != "x" && spaces[i][j] != "o") {
                    System.out.println("yer var");
                    return false;
                }

            }
        }
        System.out.println("Tahta Doldu");
        return true;

    }

    public int move(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 0;
        }

    }

    public void playMove(int move, Player player) {
        move--;

        int x = move % 3;

        int y = move / 3;

        this.spaces[y][x] = player.mark;

    }

    public Boolean isMoveValid(int move) {

        if (move > 9) {
            return false;
        }
        if (move < 1) {
            return false;
        }
        move--;

        int x = move % 3;

        int y = move / 3;

        if (this.spaces[y][x] == "x") {
            return false;
        }
        if (this.spaces[y][x] == "o") {
            return false;
        }

        return true;
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(this.spaces[i][j] + " ");

            }
            System.out.println(" ");
        }

    }

}
