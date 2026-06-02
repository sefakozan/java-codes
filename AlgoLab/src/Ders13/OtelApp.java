package Ders13;

import java.util.ArrayList;
import java.util.Scanner;

// ============================================================
// ANA UYGULAMA — CLI + ArrayList
// ============================================================
public class OtelApp {
    // ALTIN KURAL: Statik metotlar (nesneye ihtiyac duymayan metotlar), sadece statik degiskenlere erisebilir.
    // Eger bu listeleri static yapmasaydik, programı derleyemezdik (hata verirdi).
    // Cunku bilgisayar, henuz sinifin nesnesi uretilmeden
    // bellekte yer ayirmamis oldugu bir listeye static olan bir metottan ulasmaya calistiginizi dunusunurdu
    // private -> Kapsulleme (Encapsulation)
    private static ArrayList<Oda> odalar = new ArrayList<>(); // cok bicimlilik: StandartOda + SuiteOda
    private static ArrayList<Musteri> musteriler = new ArrayList<>();
    private static ArrayList<Rezervasyon> rezervasyonlar = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ornekVerilerYukle();
        hosgeldinEkrani();

        boolean calisiyorMu = true;
        while (calisiyorMu) {
            anaMenuGoster();
            int secim = secimAl();
            switch (secim) {
                case 1 -> odaListesi();
                case 2 -> musteriEkle();
                case 3 -> musteriListesi();
                case 4 -> rezervasyonOlustur();
                case 5 -> checkInIslemi();
                case 6 -> checkOutIslemi();
                case 7 -> faturaGoster();
                case 0 -> { calisiyorMu = false; cikis(); }
                default -> System.out.println("⚠ Gecersiz secim.");
            }
        }
    }

    static void hosgeldinEkrani() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║               " + Oda.OTEL_ADI + "              ║");
        System.out.println("║           Otel Yönetim Sistemi (CLI)         ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();
    }

    static void anaMenuGoster() {
        System.out.println("\n===== ANA MENU =====");
        System.out.println("1) Oda Listesi");
        System.out.println("2) Musteri Ekle");
        System.out.println("3) Musteri Listesi");
        System.out.println("4) Rezervasyon Olustur");
        System.out.println("5) Check-in Yap");
        System.out.println("6) Check-out Yap");
        System.out.println("7) Fatura Goster");
        System.out.println("0) Cikis");
        System.out.print("Seciminiz: ");
    }

    // 1 — ODA LISTESI
    static void odaListesi() {
        System.out.println("\n🏨 ODA LISTESI (" + odalar.size() + " kayit)");
        System.out.println("Toplam oda: " + Oda.getToplamOda());

        for (Oda o : odalar) {
            o.bilgiGoster();
        }
    }

    // 2 — MUSTERI EKLE
    static void musteriEkle() {
        System.out.println("\n👤 MUSTERI EKLE");
        System.out.print("Ad Soyad: ");
        String ad = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefon: ");
        String tel = scanner.nextLine();

        Musteri m = new Musteri(ad, email, tel);
        musteriler.add(m);
        System.out.println("✓ Musteri eklendi: #" + m.getMusteriId());
    }

    // 3 — MUSTERI LISTESI
    static void musteriListesi() {
        System.out.println("\n👥 MUSTERILER (" + musteriler.size() + " kayit)");
        if (musteriler.isEmpty()) {
            System.out.println("Henuz musteri yok.");
            return;
        }
        for (Musteri m : musteriler) m.bilgiGoster();
    }

    // 4 — REZERVASYON OLUSTUR
    static void rezervasyonOlustur() {
        System.out.println("\n📝 REZERVASYON OLUSTUR");

        if (musteriler.isEmpty()) {
            System.out.println("⚠ Önce musteri eklemelisiniz.");
            return;
        }

        // Musteri sec
        musteriListesi();
        System.out.print("Musteri ID girin: ");
        int mid = secimAl();

        Musteri secilen = null;
        for (Musteri m : musteriler) {
            if (m.getMusteriId() == mid) {
                secilen = m; break;
            }
        }
        if (secilen == null) {
            System.out.println("⚠ Musteri bulunamadi.");
            return;
        }

        // Uygun oda sec
        ArrayList<Oda> uygunOdalar = new ArrayList<>();
        for (Oda o : odalar) {
            if (o.isMusait()) {
                uygunOdalar.add(o);
            }
        }

        if (uygunOdalar.isEmpty()) {
            System.out.println("⚠ Musait oda yok.");
            return;
        }

        System.out.println("\nMusait odalar:");
        for (int i = 0; i < uygunOdalar.size(); i++) {
            System.out.println("[" + (i + 1) + "] Oda #" + uygunOdalar.get(i).getOdaNo()
                    + " | " + uygunOdalar.get(i).getTip()
                    + " | ₺" + uygunOdalar.get(i).gecelikUcret());
        }

        // Oda secimi
        int odaIdx;
        do {
            System.out.print("\nOda sec (1-" + uygunOdalar.size() + "): ");
            odaIdx = secimAl() - 1; // index'ten dolayi -1 yapildi

            if (odaIdx < 0 || odaIdx >= uygunOdalar.size()) {
                System.out.println("⚠ Gecersiz oda secimi.");;
            }
        } while (odaIdx < 0 || odaIdx >= uygunOdalar.size());

        // Secilen uygun oda
        Oda oda = uygunOdalar.get(odaIdx);

        // Gece sayisi al
        int gece;
        do {
            System.out.print("\nKac gece kalinacak?: ");
            gece = secimAl();

            if (gece <= 0) {
                System.out.println("⚠ Gece sayısı 1 veya daha buyuk olmali.");
            }
        } while (gece <= 0);

        System.out.print("\nOdeme yöntemi (Kart/Nakit/Havale): ");
        String odemeYontemi = scanner.nextLine();

        Rezervasyon r = new Rezervasyon(secilen, oda, gece, odemeYontemi);
        rezervasyonlar.add(r);

        System.out.println("✓ Rezervasyon olusturuldu. Rez No: " + r.getRezervasyonNo());
        System.out.println("Not: Check-in icin menuden check-in secin.");
    }

    // 5 — CHECK-IN
    static void checkInIslemi() {
        System.out.println("\n🟢 CHECK-IN");
        Rezervasyon r = rezervasyonSec("Check-in yapilacak rezervasyon no: ");
        if (r == null) return;
        r.checkIn();
    }

    // 6 — CHECK-OUT
    static void checkOutIslemi() {
        System.out.println("\n🔴 CHECK-OUT");
        Rezervasyon r = rezervasyonSec("Check-out yapilacak rezervasyon no: ");
        if (r == null) return;
        r.checkOut();
    }

    // 7 — FATURA
    static void faturaGoster() {
        System.out.println("\n💳 FATURA");
        Rezervasyon r = rezervasyonSec("Faturasi gosterilecek rezervasyon no: ");
        if (r == null) return;
        r.faturaGoster();
    }

    // Yardimci: rezervasyon bul
    static Rezervasyon rezervasyonSec(String prompt) {
        if (rezervasyonlar.isEmpty()) {
            System.out.println("⚠ Rezervasyon yok.");
            return null;
        }

        System.out.println("Mevcut rezervasyonlar:");
        for (Rezervasyon r : rezervasyonlar) {
            System.out.println("- Rez No: " + r.getRezervasyonNo()
                    + " | Oda #" + r.getOda().getOdaNo()
                    + " | " + (r.isCheckInYapildi() ? "Check-in" : "Bekliyor")
                    + (r.isCheckOutYapildi() ? " / Check-out" : ""));
        }

        System.out.print(prompt);
        int rezNo = secimAl();
        for (Rezervasyon r : rezervasyonlar) {
            if (r.getRezervasyonNo() == rezNo) return r;
        }

        System.out.println("⚠ Rezervasyon bulunamadı.");
        return null;
    }

    static int secimAl() {
        // Eger scanner.nextInt() kullanilirsa, Java sadece sayiyi okur
        // ancak kullanıcinin klavyede bastigi Enter tusunu (yeni satir karakteri - \n) hafizada (buffer'da) birakir.
        // Bir sonraki adimda scanner.nextLine() ile kelime okumaya calisilirsa,
        // hafizada kalan bu Enter yuzunden program kullanicidan girdi beklemeden o adimi direkt atlar
        try { // asagidaki islemi yapmayi dene
            // trim() -> girdideki bosluklari siler
            return Integer.parseInt(scanner.nextLine().trim());
        }
        catch (Exception e) { // denerken hata cikarsa catch calisir
            return -1; // Gecersiz islem
        }
    }

    static void cikis() {
        System.out.print("\n---- " + Oda.OTEL_ADI + " ----");
        System.out.println("\n        Gule Gule..! \n");
    }

    // Baslangic verileri
    static void ornekVerilerYukle() {
        // Odalar (cok bicimlilik: Oda listesine farkli alt tipler ekleniyor)
        odalar.add(new StandartOda(101, 1, 2, true));
        odalar.add(new StandartOda(102, 1, 3, false));
        odalar.add(new SuiteOda(201, 2, 2, true, 30));
        odalar.add(new SuiteOda(202, 2, 4, false, 24));

        // Örnek musteriler
        musteriler.add(new Musteri("Ferhat Ucar", "fucar@firat.edu.tr", "+90 5xx xxx xx xx"));
        musteriler.add(new Musteri("Ayse Demir", "ayse@mail.com", "0532 000 00 00"));
        musteriler.add(new Musteri("Mehmet Kaya", "gecersizemail", "ABC")); // uyari uretir
    }
}
