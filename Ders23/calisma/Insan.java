public class Insan {
    private int kimlikNo;
    private String isim;

    public Insan(int kimlikNo, String isim){
        this.isim = isim;
        this.kimlikNo = kimlikNo;
        }

    public Insan(Insan insan){
        this.isim = insan.isim;
        this.kimlikNo = insan.kimlikNo;
    }

    public String getIsim(){
        return isim;
    }
    public void setIsim(String isim){
        this.isim = isim;
    }
    public int getKimlikNo(){
        return kimlikNo;
    }
    public void setKimlikNo(int kimlikNo){
        this.kimlikNo = kimlikNo;
    }

}
