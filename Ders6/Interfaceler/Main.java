
public class Main {

    public static void main(String[] args) {

    }

}

class Fish implements IWaterCreature {
    boolean canBreatheUnderWater = true;

    private int mass;
    private int length;
    private int baseHealth = 10;
    private int baseStamina = 10;
    private int Health;
    private int Stamina;

    public Fish(int mass, int length) {
        this.mass = mass;
        this.length = length;
        this.Stamina = this.calculateStamina(this.length);
        this.Health = this.calculateHealth(this.mass);

    }

    public int calculateStamina(int creatureLength) {
        return this.baseStamina + (4 * creatureLength);
    };

    public int calculateHealth(int creatureMass) {
        return this.baseHealth + (creatureMass);
    }

    public void breathe() {
        System.out.println(this.canBreatheUnderWater);
        System.out.println("blob blob");
    }

    public void moveUnderWater() {
        System.out.println("fish fish");
    };
}

class Dolphin implements IWaterCreature {

    boolean canBreatheUnderWater = false;

    private int mass;
    private int length;
    private int baseHealth = 10;
    private int baseStamina = 10;
    private int Health;
    private int Stamina;

    public Dolphin(int mass, int length) {
        this.mass = mass;
        this.length = length;
        this.Stamina = this.calculateStamina(this.length);
        this.Health = this.calculateHealth(this.mass);

    }

    public int calculateHealth(int creatureMass) {
        return this.baseHealth + 20 * (creatureMass);
    }

    public int calculateStamina(int creatureLength) {
        return this.baseStamina + (2 * creatureLength) + (3 * this.mass);
    };

    public void breathe() {
        System.out.println(this.canBreatheUnderWater);
        System.out.println("need to surface");
    }

    public void moveUnderWater() {
        System.out.println("vouv vouv dolpin radar vouv vouv");
    };

}

interface IWaterCreature {
    public int calculateStamina(int creatureLength);

    public int calculateHealth(int creatureMass);

    public void breathe();

    public void moveUnderWater();
}