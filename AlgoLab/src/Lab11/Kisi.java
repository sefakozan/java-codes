package Lab11;

public class Kisi {
    protected String ad;
    protected String tcKimlik;

    public Kisi(String ad, String tcKimlik) {
        this.ad = ad;
        this.tcKimlik = tcKimlik;
    }

    void bilgileriGoster() {
        System.out.println("Ad: " + ad + " | " + "TC: " + tcKimlik); // Kisi ciktisi
    }
}
