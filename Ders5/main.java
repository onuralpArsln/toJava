public class main {

    public static void main(String[] args) {

        Player test = new Player();
        System.out.println(test.currentClass);
        test.currentClass = PlayerClass.Barbarian;
        System.out.println(test.currentClass);
    }

}

class Player {
    State currentState = State.Normal;
    final PlayerClass currentClass = PlayerClass.Archer;

    public void run() {
        switch (this.currentState) {
            case Normal:
                System.out.println("Kosuyorum");
                break;
            case Slowed:
                System.out.println(" yavas Kosuyorum");
                break;

            case Stunned:
                System.out.println(" duruyorum");
                break;

            default:
                throw new AssertionError();
        }

    }

}

enum State {
    Normal,
    Slowed,
    Stunned
}

enum PlayerClass {
    Barbarian,
    Mage,
    Archer,
    Paladin,
    Knight
}