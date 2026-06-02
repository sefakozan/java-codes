package Ders13;

// ============================================================
// Rezervasyon: Oda + Musteri iliskisi
// - Ic sinif: OdemeBilgisi (sadece rezervasyon baglaminda anlamli)
// - Durum: check-in / check-out kontrolu
// ============================================================
class Rezervasyon {

    private static int sonRezNo = 1000;

    private int rezervasyonNo;
    private Musteri musteri;
    private Oda oda;
    private int geceSayisi;

    private boolean checkInYapildi;
    private boolean checkOutYapildi;

    private OdemeBilgisi odeme; // ic sinif nesnesi

    public Rezervasyon(Musteri musteri, Oda oda, int geceSayisi, String odemeYontemi) {
        this.rezervasyonNo = ++sonRezNo;
        this.musteri = musteri;
        this.oda = oda;
        this.geceSayisi = geceSayisi;
        this.checkInYapildi = false;
        this.checkOutYapildi = false;

        // Ic sinif: sadece Rezervasyon icinde olusturulur
        this.odeme = new OdemeBilgisi(odemeYontemi);
    }

    public int getRezervasyonNo() {
        return rezervasyonNo;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public Oda getOda() {
        return oda;
    }

    public int getGeceSayisi() {
        return geceSayisi;
    }

    public boolean isCheckInYapildi() {
        return checkInYapildi;
    }

    public boolean isCheckOutYapildi() {
        return checkOutYapildi;
    }

    public double toplamTutar() {
        return oda.gecelikUcret() * geceSayisi;
    }

    public void checkIn() {
        if (checkInYapildi) {
            System.out.println("⚠ Zaten check-in yapilmis.");
            return;
        }
        if (!oda.isMusait()) {
            System.out.println("⚠ Oda dolu gorunuyor. Check-in yapilamadi.");
            return;
        }
        checkInYapildi = true;
        oda.setMusait(false);
        System.out.println("✓ Check-in tamamlandi. Oda #" + oda.getOdaNo());
    }

    public void checkOut() {
        if (!checkInYapildi) {
            System.out.println("⚠ Check-in yapilmadan check-out yapilamaz.");
            return;
        }
        if (checkOutYapildi) {
            System.out.println("⚠ Zaten check-out yapilmis.");
            return;
        }
        checkOutYapildi = true;
        oda.setMusait(true);
        System.out.println("✓ Check-out tamamlandi. Oda #" + oda.getOdaNo());
    }

    public void faturaGoster() {
        System.out.println("\n========= FATURA =========");
        System.out.println("Rezervasyon No: " + rezervasyonNo);
        System.out.println("Musteri       : " + musteri.getAdSoyad());
        System.out.println("Oda           : #" + oda.getOdaNo() + " (" + oda.getTip() + ")");
        System.out.println("Gece          : " + geceSayisi);
        System.out.println("Gecelik Ucret : " + oda.gecelikUcret());
        System.out.println("Toplam Tutar  : " + toplamTutar());
        System.out.println("Odeme         : " + odeme.odemeYontemi + " | Durum: " + odeme.getDurum());
        System.out.println("==========================\n");
    }

    // -------------------------------------------------------
    // IC SINIF (Inner Class) — OdemeBilgisi
    // Bu yapi sadece Rezervasyon icinde anlamlidir.
    // -------------------------------------------------------
    class OdemeBilgisi {
        private String odemeYontemi; // Kart / Nakit / Havale
        private boolean odendi;

        OdemeBilgisi(String odemeYontemi) {
            this.odemeYontemi = odemeYontemi;
            this.odendi = false;
        }

        public void odemeAl() {
            odendi = true;
        }

        public String getDurum() {
            return odendi ? "Odendi" : "Beklemede";
        }
    }
}
