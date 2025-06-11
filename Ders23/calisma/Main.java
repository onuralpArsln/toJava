public class Main {

    public static void main(String[] args) {
        Okul Okul1 = new Okul();
        Insan insan1 = new Insan(123, "Deniz");
        Insan insan2 = new Insan(321, "Onur");
        try {
            Okul1.addToSchool(insan1);
            Okul1.addToSchool(insan2);
            Okul1.addToSchool(insan2);
        } catch (EqualsException e) {
            System.out.println(e);
        }
        Okul1.printer();
    }
}
