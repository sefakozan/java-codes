// Ana sınıf: Hayvan
public abstract class Hayvan {
    // Static değişken: Toplam hayvan sayısını tutar
    private static int toplamHayvanSayisi = 0;
    private final String tur; // final: değişkenin değeri sonradan değiştirilemez
    protected int yas;
    // Private, protected ve final alanlar
    private String ad;

    // Constructor
    public Hayvan(String ad, int yas, String tur) {
        this.ad = ad;
        this.yas = yas;
        this.tur = tur;
        toplamHayvanSayisi++; // Yeni hayvan oluşturulduğunda sayacı artır
    }

    // Static metod: Toplam hayvan sayısını döndürür
    public static int getToplamHayvanSayisi() {
        return toplamHayvanSayisi;
    }

    // Abstract metod: Alt sınıflar tarafından implement edilmeli
    public abstract void sesCikar();

    // Public metod
    public String getAd() {
        return ad;
    }

    // Protected metod
    protected void bilgiYazdir() {
        System.out.println("Ad: " + ad + ", Yaş: " + yas + ", Tür: " + tur);
    }

    // Final metod: Alt sınıflarda override edilemez
    public final String getTur() {
        return tur;
    }
}