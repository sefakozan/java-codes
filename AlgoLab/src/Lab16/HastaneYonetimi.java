package Lab16;

import java.util.ArrayList;

public class HastaneYonetimi {
    public static void main(String[] args) {
        // ArrayList olusturulmasi
        ArrayList<Hasta> hastalar = new ArrayList<>();

        // 4 farkli hasta eklenmesi
        hastalar.add(new Hasta("Sirin Sever", "11111111111"));
        hastalar.add(new Hasta("Ayse Demir", "22222222222"));
        hastalar.add(new Hasta("Mehmet Kaya", "33333333333"));
        hastalar.add(new Hasta("Zeynep Ozkan", "44444444444"));

        // Liste boyutunun yazdirilmasi
        System.out.println("Toplam hasta sayisi: " + hastalar.size()); // 4

        // Listeyi dolasip hasta bilgilerinin yazdirilmasi
        for (Hasta h : hastalar) {
            h.bilgileriGoster();
        }

        // 1. indeksteki (2. siradaki) hastanin silinmesi.
        hastalar.remove(1);
        System.out.println("\n--- 2. hasta silindi ---");
        System.out.println("Toplam hasta sayisi: " + hastalar.size()); // 3

        // Listeyi dolasip hasta bilgilerinin yazdirilmasi
        for (Hasta h : hastalar) {
            h.bilgileriGoster();
        }

        // contains() veya get(0).getAd() kullanarak ilk hastanin adini ekrana yazdirilmasi
        // 1. get(0).getAd()
        System.out.println("\nget(0).getAd()");
        System.out.println("Ilk hastanin adi: " + hastalar.get(0).getAd());

        // 2. contains()
        // Önce ilk sıradaki (0. indeks) hastayi gecici bir nesne referansina aliyoruz
        System.out.println("\ncontains()");
        Hasta ilkHasta = hastalar.get(0);

        // contains() ile bu nesnenin listemizde var olup olmadigini (true/false) sorguluyoruz
        if (hastalar.contains(ilkHasta)) {
            // Eger true donerse (ki donecektir), hastanin adini yazdiriyoruz
            System.out.println("Ilk hastanin adi: " + ilkHasta.getAd());
        }

        /** Analiz Sorulari
         * 1. ArrayList<Hasta> yazımındaki <Hasta> ne ise yarıyor? Olmasa ne fark ederdi?
         *    - Bu yapiya Generics (Jenerik) denir ve Tip Guvenligini (Type Safety) saglar.
         *      Listenin sadece Hasta tipinde nesneler kabul edecegini garanti eder.
         *      Olmasaydi, liste Object tipinde calisir, her turlu veriyi kabul ederdi ve
         *      elemanlari geri alirken surekli tip donusumu (casting) yapmak gerekirdi (bu da calisma zamani hatalarina sebep olabilirdi).
         *
         * 2. Ayni listeye ArrayList<Hasta> yerine ArrayList<int> yazsaydik ne olurdu? Neden Java boyle bir kural koymus olabilir?
         *    - Hata alirdik cunku Koleksiyon (Collection) yapilari sadece Referans Tipleri (nesneleri) kabul eder.
         *      Ilkel (primitive) tipler (int, double vb.) kabul edilmez;
         *      yerlerine Sarmalayici (Wrapper) siniflar (Integer, Double vb.) kullanilmalidir.
         *      Java, bellekte referans yöonetimi ve koleksiyon metotlarinin tutarliligi icin bu mimariyi tamamen nesneler uzerine insa etmistir.
         *
         * 3. Diziye göre ArrayList’in temel avantajı nedir? Tek cumleyle yazin
         *    - ArrayList'in temel avantaji, boyutunun bastan sabitlenmek zorunda olmamasi ve
         *      eleman eklendikce veya silindikce kapasitesinin dinamik olarak esneyebilmesidir.
         */
    }
}
