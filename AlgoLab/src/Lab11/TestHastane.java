package Lab11;

public class TestHastane {
    static void main(String[] args) {
        // Soru 2: Kalitim (Inheritance) – Hastane Personel Hiyerarsisi
        Kisi k1 = new Kisi("Sefa Kozan", "11111111111");
        Personel p1 = new Personel("Ferhat Ucar", "22222222222", "P001", "Yonetim");
        Doktor d1 = new Doktor("Ali Can", "33333333333", "D001", "Kardiyoloji", "Kalp Hastaliklari", "DR−2018−042");

        System.out.println("−−− Kisi −−−");
        k1.bilgileriGoster();

        System.out.println("\n−−− Personel −−−");
        p1.bilgileriGoster();

        System.out.println("\n−−− Doktor −−−");
        d1.bilgileriGoster();

        System.out.println("\ninstanceof sonuclari: ");
        // doktor nesnesi, Personel turunden midir?
        // true : Doktor, Personel'den turedigi icin Personel sayilir
        System.out.println("doktor instanceof Personel: " + (d1 instanceof Personel)); // true

        // doktor nesnesi, Kisi turunden midir?
        // true : Doktor, Kisi > Personel > Doktor zinciriyle Kisi'nin de alt turudur
        System.out.println("doktor instanceof Kisi: " + (d1 instanceof Kisi)); // false

        // personel nesnesi, Doktor turunden midir?
        // false : Personel, Doktor'un ust sinifidir; alt sinifi degildir
        System.out.println("personel instanceof Doktor: " + (p1 instanceof Doktor)); // false


        /* Analiz Sorulari
            1. Doktor sinifinin constructor’inda Kisi’nin alanlarina (ad, tcKimlik) dogrudan this.ad = ...
            ile deger atamayi deneyin. Ne oluyor? Neden super(...) kullanmak zorunlu?
                  - Kisi sinifindaki ad alani protected oldugundan Doktor'dan erisilebilir gorunse de, Java
                    her constructor'in ya this(…) ya da super(…) ile baslamasini zorunlu kilar; aksi halde derleyici
                    ortuk olarak super() ekler ve Kisi'de parametresiz constructor bulunmadigindan derleme hatasi
                    olusur. Hiyerarsideki her ust sinifin duzgun bicimde baslatilmasi icin super(…) zinciri
                    zorunludur.

             2. Doktor nesnesi uzerinde bilgileriGoster() cagrildiginda uc sinifin ciktisi sirayla ekrana geldi
             Bu sirayi saglayan mekanizma nedir?
                   - super.bilgileriGoster() zinciri: Doktor.bilgileriGoster() → Personel.bilgileriGoster() →
                     Kisi.bilgileriGoster() sirasiyla calisir. Her override edilen metot once ust sinifin metodunu
                     cagirir, ardindan kendi alanlarini ekler. Bu sayede kalitim hiyerarsisindeki tum katmanlarin
                     ciktisi yukaridan asagiya dogru sirayla olusur.

             3. Java’da class Doktor extends Personel, Kisi yazmayi deneyin. Hata aliyor musunuz? Java
             neden tek kalitima izin veriyor?
                   - Evet, derleme hatasi alinir. Java coklu kalitimi (multiple inheritance) siniflar icin
                     desteklemez. Bunun temel nedeni Elmas (Diamond) Problemi'dir: iki ust sinif ayni adda bir
                     metot tanimlarsa, alt sinifin hangi versiyonu miras aldigi belirsizlesir. Java bu karmasikligi
                     onlemek icin tek kaltima izin verir; tek kalitiöşa yapilamayan seyi,
                     interface'lerle birden fazla davranis eklenerek cozulebilir.
         */
    }
}
