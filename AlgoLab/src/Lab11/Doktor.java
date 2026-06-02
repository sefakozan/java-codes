package Lab11;

class Doktor extends Personel {
    private String uzmanlik;
    private String diplomaNo;

    public Doktor(String ad, String tcKimlik, String sicilNo, String bolum, String uzmanlik, String diplomaNo) {
        super(ad, tcKimlik, sicilNo, bolum); // Personel constructor cagirilir
        this.uzmanlik = uzmanlik;
        this.diplomaNo = diplomaNo;
    }

    @Override
    void bilgileriGoster() {
        super.bilgileriGoster(); // Personel sinifinin bilgileriGoster() metodunu cagirir, Personel ciktisi + Kisi ciktisi
        System.out.println("Uzmanlik: " + uzmanlik + " | " + "Diploma No: " + diplomaNo); // Doktor ciktisi
    }
}
