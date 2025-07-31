// Alt sınıf: Kedi
public class Kedi extends Hayvan {
    private String cins;

    // Constructor: super ile üst sınıfın constructor'ını çağırıyoruz
    public Kedi(String ad, int yas, String cins) {
        super(ad, yas, "Kedi"); // super ile Hayvan sınıfının constructor'ını çağır
        this.cins = cins;
    }

    // Abstract metodun implementasyonu
    @Override
    public void sesCikar() {
        System.out.println(getAd() + ": Miyav!");
    }

    // Bilgi yazdırma metodu: super ile üst sınıfın metodunu çağırıyoruz
    public void bilgiYazdir() {
        super.bilgiYazdir(); // Üst sınıfın bilgiYazdir metodunu çağır
        System.out.println("Cins: " + cins);
    }
}