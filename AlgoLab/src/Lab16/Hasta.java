package Lab16;

class Hasta implements Raporlanabilir {
    private String ad;
    private String tcKimlik;

    public Hasta(String ad) {
        this(ad, ""); // Hasta constructor'inin diger constructor'ini cagirilir
    }

    public Hasta(String ad, String tcKimlik) {
        this.ad = ad;
        this.tcKimlik = tcKimlik;
    }

    public String getAd() {
        return ad;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    // Interface Metodlari
    @Override
    public void raporOlustur() {
        System.out.println("−−− Hasta Raporu −−−");
        System.out.println("Ad: " + ad);
        System.out.println("TC: " + tcKimlik);
    }

    @Override
    public String raporOzeti() {
        return "Ozet: " + ad + " - Hasta Kaydi";
    }

    // Istenen Ek Metot
    public void bilgileriGoster () {
        System.out.println(tcKimlik + " − " + ad); // Hasta ciktisi
    }
}
