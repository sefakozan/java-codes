package Ders13;

// ============================================================
// ÇOK BICIMLILIK (Polymorphism) — Standart Oda
// ============================================================
class StandartOda extends Oda {

    // final: bu sınıf icin sabit bir katsayi
    private static final double TABAN_UCRET = 900.0;

    private boolean kahvaltiDahil;

    public StandartOda(int odaNo, int kat, int kapasite, boolean kahvaltiDahil) {
        super(odaNo, kat, kapasite); // Oda sinifinin constructor'i cagirilir
        this.kahvaltiDahil = kahvaltiDahil;
    }

    @Override
    public String getTip() {
        return "Standart" + (kahvaltiDahil ? " (Kahvaltı Dahil)" : "");
    }

    @Override
    public double gecelikUcret() {
        // Kahvaltı dahilse ufak bir ek ucret
        return kahvaltiDahil ? (TABAN_UCRET + 150.0) : TABAN_UCRET;
    }
}
