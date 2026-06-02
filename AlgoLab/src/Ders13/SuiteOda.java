package Ders13;

// ============================================================
// ÇOK BICIMLILIK (Polymorphism) — Suite Oda
// ============================================================
class SuiteOda extends Oda {

    private static final double TABAN_UCRET = 1800.0;

    private boolean jakuzi;
    private int salonMetrekare;

    public SuiteOda(int odaNo, int kat, int kapasite, boolean jakuzi, int salonMetrekare) {
        super(odaNo, kat, kapasite);
        this.jakuzi = jakuzi;
        this.salonMetrekare = salonMetrekare;
    }

    @Override
    public String getTip() {
        return "Suite" + (jakuzi ? " (Jakuzi)" : "") + " | Salon: " + salonMetrekare + "m²";
    }

    @Override
    public double gecelikUcret() {
        // Suite: metrekare + jakuzi durumuna gore artis
        double ek = (salonMetrekare > 25) ? 300.0 : 0.0;
        if (jakuzi) ek += 400.0;
        return TABAN_UCRET + ek;
    }
}
