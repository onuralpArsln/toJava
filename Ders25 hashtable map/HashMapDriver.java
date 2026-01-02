import java.util.HashMap;
import java.util.Map;

public class HashMapDriver {
    public static void main(String[] args) {
        // Ürün Adı (String) -> Fiyatı (Double)
        HashMap<String, Double> urunFiyatlari = new HashMap<>();

        // Veri ekleyelim
        urunFiyatlari.put("Laptop", 25000.0);
        urunFiyatlari.put("Mouse", 450.50);
        
        // ÖNEMLİ FARK: HashMap null değer kabul eder.
        // Örneğin: "Klavye" stoğa girdi ama fiyatı henüz belli değil.
        urunFiyatlari.put("Klavye", null); 
        
        // Hatta null bir anahtar bile olabilir (Genelde önerilmez ama mümkündür)
        urunFiyatlari.put(null, 0.0); 

        System.out.println("--- Market Fiyat Listesi (HashMap) ---");
        for (Map.Entry<String, Double> urun : urunFiyatlari.entrySet()) {
            System.out.println("Ürün: " + urun.getKey() + " | Fiyat: " + urun.getValue());
        }
        
        // Çıktıda hata almayız, null değerler "null" olarak yazılır.
    }
}