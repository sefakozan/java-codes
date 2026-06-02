package Lab16;

import java.util.HashMap;

public class HastaKayitSistemi {
    public static void main(String[] args) {
        // Anahtar (Key): TC kimlik (String), Deger (Value): Hasta nesnesi
        HashMap<String, Hasta> kayitlar = new HashMap<>();

        // Haritaya 3 hasta eklenmesi
        Hasta h1 = new Hasta("Sirin Sever", "11111111111");
        Hasta h2 = new Hasta("Ayse Demir", "22222222222");
        Hasta h3 = new Hasta("Mehmet Kaya", "33333333333");

        kayitlar.put(h1.getTcKimlik(), h1);
        kayitlar.put(h2.getTcKimlik(), h2);
        kayitlar.put(h3.getTcKimlik(), h3);

        // Bir hastayı doğrudan TC ile bulma
        Hasta arananHasta = kayitlar.get("11111111111");
        if (arananHasta != null) {
            System.out.println("Aranan hasta: 11111111111 - " + arananHasta.getAd());
        }

        // Sistemde olmayan bir TC'yi sorgulama
        boolean varMi = kayitlar.containsKey("99999999999");
        System.out.println("99999999999 sistemde var mi? " + varMi);

        // Tüm kayitlari keySet() uzerinden dolasarak TC: Ad formatinda ekrana yazdirilmasi
        System.out.println("\n--- Tum Kayitlar ---");
        // keySet() anahtarlarin kumesi
        for (String tc : kayitlar.keySet()) {
            // kayitlar.get(tc) -> o TC numarasina (Key'e) sahip Hasta nesnesini verir ve artik o nesnenin icindeki metotlara erisilebilir
            System.out.println(tc + ": " + kayitlar.get(tc).getAd());
        }

        // Bir hastayi TC ile silme ve yeni boyutu yazdirma
        kayitlar.remove("22222222222");
        System.out.println("\n--- Silme islemi sonrasi ---");
        System.out.println("Kalan kayit sayisi: " + kayitlar.size());

        /** Analiz Sorulari
         * 1. HashMap<String, Hasta> yapisinda ilk String ne anlama geliyor, Hasta ne anlama geliyor?
         *    - String arama yaparken kullanilacak benzersiz Anahtarin (Key) veri tipini (TC Kimlik No),
         *      Hasta ise bu anahtara karsilik gelen verinin (Value) veri tipini (Hasta nesnesi) temsil eder.
         *
         * 2. Ayni TC ile put islemini iki kez yapsaydik ne olurdu? Sistemde ayni anahtardan iki tane bulunabilir mi?
         *    - HashMap, ayni anahtarla iki farkli kayit tutmaz. Eger var olan bir anahtarla (ayni TC ile) tekrar put islemi yapilirsa,
         *      eski degeri siler ve yerine yeni degeri yazar (uzerine yazar). Sistemde ayni anahtardan yalnizca bir tane bulunabilir.
         *
         * 3. ArrayList ile HashMap arasinda, “TC ile hizli arama” senaryosu icin neden HashMap daha uygun?
         *    - ArrayList'te istenen veriyi bulmak icin tum elemanlari bastan sona kontrol etmek (O(n)) gerekirken;
         *      HashMap'te aranilan degerin adresi dogrudan anahtarin (TC'nin) hash kodu ile hesaplandigi icin veriye aninda (O(1)) erisilebilir.
         */
    }
}
