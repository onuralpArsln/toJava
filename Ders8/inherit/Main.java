public class Main {
    public static void main(String[] args) {

        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();
        genericAnimal.eat();

        Dog dog = new Dog();
        dog.makeSound();
        dog.eat();
        dog.fetch();

        System.out.println(NoteGenerator.categoryNotes(700));
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

class Dog extends Animal {
    // Override olmazsa da çalışır ancak override best practice sayılır
    // 1- eğer method adını yanlış yazarsan override sana bunu fark ettirir
    // 2- method imzasındaki hataları fark ettirir
    // 3- insan okumasını kolaylaştırır
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }

    // yeni methodlar yazabilirsin
    public void fetch() {
        System.out.println("The dog is fetching the ball");
    }
}

class NoteGenerator {

    public static String categoryNotes(int note) {
        // kullanıcı hatası önleme
        if (note > 100) {
            throw new java.lang.Error("Cok yuksek not");
        } else if (0 > note) {
            throw new java.lang.Error("Cok duşuk not");
        }

        // doğru çalışma mantığı
        if (note > 70) {
            return "Basarili";
        } else if (note > 50) {
            return "Zayif";
        } else {
            return "kaldi";
        }

    }

}