package Lab11;

public class Hasta {
    private String ad;
    private String tcKimlik;
    private String telefon;
    private String kanGrubu;
    public static int sayac1Param = 0;   // Hasta(ad)
    public static int sayac2Param = 0;   // Hasta(ad, tc)
    public static int sayac4Param = 0;   // Hasta(ad, tc, tel, kan)

    // this(...) çağrısı constructor’ın ilk satiri olmak zorundadir; aksi halde derleme hatasi alinir.
    // Bir constructor icinde hem this(...) hem super(...) birlikte kullanilamaz.
    public Hasta(String ad) {
        // sayac++; --> derleme hatasi
        this(ad, "Bilinmiyor"); // 2 parametreli constuructor'i calistirir
        sayac1Param++;
    }

    public Hasta(String ad, String tcKimlik) {
        this(ad, tcKimlik, "Bilinmiyor", "Bilinmiyor"); // 4 parametreli constuructor'i calistirir
        sayac2Param++;
    }

    public Hasta(String ad, String tcKimlik, String telefon, String kanGrubu) {
        this.ad = ad; // this.ad -> instance, ad -> parametre
        this.tcKimlik = tcKimlik;
        this.telefon = telefon;
        this.kanGrubu = kanGrubu;
        sayac4Param++;
    }

    void bilgileriGoster() {
        System.out.println("Ad: " + ad + " | " + "TC: " + tcKimlik + " | " + "Telefon: " + telefon + " | " + "Kan Grubu: " + kanGrubu);
    }

    /* Analiz Sorulari

    1. this.ad = ad; satirinda sol taraftaki this.ad ile sag taraftaki ad farkli seyleri mi ifade ediyor?
       - Evet. Sol taraftaki this.ad, nesnenin kendisine ait (instance) alan degiskenini ifade eder.
         Sag taraftaki ad ise constructor'a gecirilen yerel parametredir. Java, ayni isimli alan ve
         parametre cakistiginda parametreyi öncelikli olarak ele alir; this anahtar sözcüğü sayesinde
         nesnenin alanina erisim saglanir.

    2. Tek parametreli constructor icinde this(ad, "Bilinmiyor", "Bilinmiyor", "Bilinmiyor")
       yazdiginizda aslinda hangi constructor calisiyor? Neden bu yaklasim kod tekrarini onluyor?
         - Tek parametreli constructor icinde this(ad, "Bilinmiyor", "Bilinmiyor", "Bilinmiyor") ifadesi,
            dort parametreli constructor'i cagirir. Bu yaklasim, tek parametreli constructor'in
            dort parametreli constructor'in kodunu tekrar etmesini onler. Dort parametreli constructor,
            tum alanlari doldurmakla sorumlu oldugu icin, tek parametreli constructor sadece ad'i
            alir ve diger alanlar icin varsayilan degerleri dort parametreli constructor'a gonderir.
     */
}
