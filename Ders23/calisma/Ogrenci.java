public class Ogrenci extends Insan {

    public Ogrenci(int kimlikNo, String isim) {
        super(kimlikNo, isim);
    }

    public Ogrenci(Insan insan) {
        super(insan);
    }

    @Override
    public boolean equals(Object ogrenci) {
        if (ogrenci == null) {
            return false;
        }
        if (ogrenci instanceof Insan) {
            Insan temp = (Insan) ogrenci;
            if (this.getIsim().equals(temp.getIsim()) && this.getKimlikNo() == temp.getKimlikNo()) {
                return true;
            }
        }
        return false;
    }
}
