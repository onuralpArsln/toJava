
public class main {

    public static void main(String[] args) {

        Player test = new Player();

        test.getStates();

        test.setRunning();

        System.out.println("after bleed");

        test.setBleeding();

        test.getStates();
        test.setRunning();
    }

}

class Player {

    private Boolean isSlowed = false;
    private Boolean isStunned = false;
    private Boolean isBleeding = false;
    private Boolean isChanneling = false;
    private Boolean isRunning = false;

    private String name = "mahmut";
    private String surname = "mehmut";

    public void setBleeding() {
        this.isBleeding = true;
        this.isSlowed = true;
        this.isRunning = false;

    }

    public void setRunning() {
        if (this.isSlowed) {
            this.isRunning = false;
            System.err.println("koşamıyorum");
        } else {
            this.isRunning = true;
            System.err.println("koşuyorum");
        }

    }

    public void getStates() {
        System.err.println(this.isRunning);
        System.err.println(this.isBleeding);
        System.err.println(this.isSlowed);

    }

}