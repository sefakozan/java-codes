package Lab11;

class Personel extends Kisi {
    protected String sicilNo;
    protected String bolum;

    public Personel(String ad, String tcKimlik, String sicilNo, String bolum) {
        super(ad, tcKimlik); // Kisi constructor'i cagirilir
        this.sicilNo = sicilNo;
        this.bolum = bolum;
    }

    @Override
    void bilgileriGoster() {
        super.bilgileriGoster(); // Kisi sinifinin bilgileriGoster() metodunu cagirir, Kisi ciktisi
        System.out.println("Sicil No: " + sicilNo + " | " + "Bolum: " + bolum); // Personel ciktisi
    }
}
