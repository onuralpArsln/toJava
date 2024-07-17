
public class main {
    public static void main(String[] args) {

        telefon myTelefon = new telefon();

        System.out.println(myTelefon.brand);

        myTelefon.brand = "samsung";
        System.out.println(myTelefon.brand);

        telefon2 benimTelefonum = new telefon2(12345, "nokia");
        System.out.println(benimTelefonum.brand);
        benimTelefonum.brand = "iphone";
        System.out.println(benimTelefonum.brand);
        telefon2.message();

        // final brand olduğu için brand değişmez
        telefon3 seninTelefon = new telefon3(12345, "nokia");
        seninTelefon.whatsap();

        // method returnunun değerini yeni bildirimSayisi değişkenine atar
        int bildirimSayisi = seninTelefon.gelenBildrim();
        System.out.println(bildirimSayisi);

        String sonGelenMesaj = seninTelefon.gelenMesaj();
        System.out.println(sonGelenMesaj);

        seninTelefon.gelenBildrim();
    }

}

class telefon {
    public int serialNum;
    public String brand;
}

class telefon2 {
    public int serialNum;
    public String brand;

    public telefon2(int num, String brand) {
        this.serialNum = num;
        this.brand = brand;
    }

    public static void message() {
        System.out.println("sms attim");
    }
}

class telefon3 {
    public final int serialNum;
    public final String brand;

    public telefon3(int num, String brand) {
        this.serialNum = num;
        this.brand = brand;
    }

    // void return yapmama durumudur
    public void whatsap() {
        System.out.println("wpden mesaj attim");
    }

    // burada String returnlenir
    public String gelenMesaj() {
        System.out.println("wp bildirim sesi");
        return "Akşama halı saha gelcen mi?";
    }

    // burada int returnlenir
    public int gelenBildrim() {
        System.out.println("wp bildirim sesi");
        return 17;
    }

}