package Ders13;

// ============================================================
// SOYUTLAMA (Abstraction)
// Oda: Oteldeki her oda icin ortak sablon.
// Nesne uretilemez, alt siniflar detaylari doldurur.
// ============================================================
abstract class Oda {
    // DEGISTIRICILER (Modifiers)
    // public static final: sabit, tum sistemde ortak
    public static final String OTEL_ADI = "Kozan Suite Hotel";

    // private static: siniff duzeyinde sayac (encapsulation)
    private static int toplamOda = 0;

    // KAPSULLEME: private alanlar
    private int odaNo;
    private int kat;
    private boolean musait;   // true: bos / false: dolu

    // protected: alt siniflar erisebilir (kutuphane ornegindeki mantık)
    protected int kapasite;

    public Oda(int odaNo, int kat, int kapasite) {
        this.odaNo = odaNo;
        this.kat = kat;
        this.kapasite = kapasite;
        this.musait = true;
        toplamOda++;
    }

    // Getter'lar (Kapsulleme)
    public int getOdaNo() {
        return odaNo;
    }

    public int getKat() {
        return kat;
    }

    public int getKapasite() {
        return kapasite;
    }

    public boolean isMusait() {
        return musait;
    }

    public static int getToplamOda() {
        return toplamOda;
    }

    // Kontrollu setter (Kapsulleme)
    public void setMusait(boolean musait) {
        this.musait = musait;
    }

    // SOYUT METOTLAR: alt siniflar dolduracak
    public abstract String getTip();

    public abstract double gecelikUcret(); // oda tipine gore ucret farkli

    // Normal metot: tum odalar icin ortak bilgi
    public void bilgiGoster() {
        System.out.println("---------------------------------------");
        System.out.println("Otel      : " + OTEL_ADI);
        System.out.println("Oda No    : " + odaNo);
        System.out.println("Kat       : " + kat);
        System.out.println("Tip       : " + getTip());
        System.out.println("Kapasite  : " + kapasite);
        System.out.println("Durum     : " + (musait ? "✓ Musait" : "✗ Dolu"));
        System.out.println("Gecelik ₺ : " + gecelikUcret());
    }
}
