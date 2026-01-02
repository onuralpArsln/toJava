import java.util.Hashtable;

public class HashTableDriver {
    public static void main(String[] args) {
        // SessionID (String) -> Kullanıcı Adı (String)
        Hashtable<String, String> aktifKullanicilar = new Hashtable<>();

        // Normal veri ekleme
        aktifKullanicilar.put("SESS_101", "Ahmet Yılmaz");
        aktifKullanicilar.put("SESS_102", "Zeynep Kaya");

        System.out.println("--- Banka Oturum Sistemi (Hashtable) ---");

        try {
            // ÖNEMLİ FARK: Hashtable'a null eklemeye çalışalım.
            // Senaryo: Sistem hatası oluştu ve kullanıcı adı null geldi.
            System.out.println("Hatalı veri eklenmeye çalışılıyor...");
            
            aktifKullanicilar.put("SESS_103", null); // BURASI PATLAR!
            
        } catch (NullPointerException e) {
            System.out.println("!!! HATA YAKALANDI !!!");
            System.out.println("Hashtable null değer kabul etmez: " + e);
        }

        // Program çalışmaya devam eder, listeyi görelim
        System.out.println("\nListede Sadece Geçerli Kullanıcılar Var:");
        System.out.println(aktifKullanicilar);
    }
}