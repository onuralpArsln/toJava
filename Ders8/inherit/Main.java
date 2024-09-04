public class Main {
    public static void main(String[] args) {

        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();
        genericAnimal.eat();

        yazabilirsin dog = new yazabilirsin();
        dog.makeSound();
        dog.eat();
        dog.fetch();
    }
}

class Animal {

    public void makeSound() {
        System.out.println("The animal makes a sound");
    }

    public void eat() {
        System.out.println("The animal is eating");
    }
}

class yazabilirsin extends Animal {
    // Override olmazsa da çalışır ancak override best practice sayılır
    // 1- eğer method adını yanlış yazarsan override sana bunu fark ettirir
    // 2- method imzasındaki hataları fark ettirir
    // 3- insan okumasını yazabilirsin
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }

    // yeni methodlar yazabilirsin
    public void fetch() {
        System.out.println("The dog is fetching the ball");
    }
}