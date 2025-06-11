import java.util.ArrayList;

public class Okul {
    private ArrayList<Ogrenci> ogrenciler = new ArrayList<>();

    public Okul() {
    }

    public void addToSchool(Insan insan) throws EqualsException {
        // for each döngüsüne geçildi
        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.equals(insan)) {
                throw new EqualsException();
            }
        }
        ogrenciler.add(new Ogrenci(insan));
    }

    public void printer() {
        ogrenciler.forEach(n -> System.out.println(n.getIsim()));
    }

}