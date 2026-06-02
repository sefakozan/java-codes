package Lab16;

    class Doktor implements Raporlanabilir {
    private String ad;
    private String uzmanlik;

    public Doktor(String ad, String uzmanlik) {
        this.ad = ad;
        this.uzmanlik = uzmanlik;
    }

    // Interface Metodlari
    @Override
    public void raporOlustur() {
        System.out.println("−−− Doktor Raporu −−−");
        System.out.println("Ad: " + ad);
        System.out.println("Uzmanlik: " + uzmanlik);
    }

    @Override
    public String raporOzeti() {
        return "Ozet: " + ad + " - " + uzmanlik + " Uzmani";
    }
}
