public class Main {
    public static void main(String[] args) {
        // İnteger tutan bir kutu yapmak
        Box<Integer> intBox = new Box<>();
        intBox.setContent(123);
        System.out.println(intBox.getContent());

        // string tutan bir kutu yapmak
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello");
        System.out.println(stringBox.getContent());
    }
}

class Box<T> {
    // T gelecek tip için bir parametredir
    // content tipi t olarak belirlenecek
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    // dönüş tipi T parametre bağımlı
    public T getContent() {
        return content;
    }
}
