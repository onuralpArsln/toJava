import java.util.Hashtable;
import java.util.Map;

public class BestPractice {
    public static void main(String[] args) {

        // 1. Hashtable Oluşturma
        // Key: Integer (Personel ID), Value: String (Personel Adı)
        // easily switch to a different type of Map later without breaking the rest of their code.
        Map<Integer, String> personelListesi = new Hashtable<>();

        // 2. Veri Ekleme (put)
        System.out.println("--- Veriler Ekleniyor ---");
        personelListesi.put(101, "Ali Yılmaz");
        personelListesi.put(102, "Ayşe Demir");
        personelListesi.put(103, "Mehmet Çelik");
        
        // Hashtable null kabul etmez! Aşağıdaki satır hata verir:
        // personelListesi.put(104, null); // HATA: NullPointerException

        // 3. Veri Okuma (get)
        System.out.println("ID'si 102 olan personel: " + personelListesi.get(102));

        // 4. Veri Güncelleme (Aynı key ile tekrar put yaparsan üzerine yazar)
        personelListesi.put(102, "Ayşe Kaya"); // Soyadı değişti
        System.out.println("102 nolu ID güncellendi: " + personelListesi.get(102));

        // 5. Veri Silme (remove)
        personelListesi.remove(101);
        System.out.println("101 nolu personel silindi.");

        // 6. Kontrol İşlemleri (containsKey / containsValue)
        if (personelListesi.containsKey(103)) {
            System.out.println("103 nolu ID listede mevcut.");
        }

        System.out.println("\n--- Tüm Listeyi Yazdırma (Döngü) ---");
        
        // Map üzerinde döngü kurmanın en yaygın yolu (Entry Set)
        for (Map.Entry<Integer, String> kayit : personelListesi.entrySet()) {
            System.out.println("ID: " + kayit.getKey() + " | İsim: " + kayit.getValue());
        }
    }
}