import java.util.HashMap;

public class hashExample {

    public static void main(String[] args) {
        HashMap<String, Integer> adresler = new HashMap<>();
        adresler.put("ayse", 6);
        adresler.put("ahmet", 7);
        adresler.put("veli", 8);
        adresler.put("ali", 1);

        System.out.println(adresler);
        System.out.println(adresler.get("ali"));
        System.out.println(adresler.remove("ali"));
        System.out.println(adresler);

    }
}
