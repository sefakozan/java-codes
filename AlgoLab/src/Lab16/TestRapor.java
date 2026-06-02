package Lab16;

public class TestRapor {
    public static void main(String[] args) {
        Hasta h1 = new Hasta("Sefa Kozan", "12345678901");
        Doktor d1 = new Doktor("Dr. Ferhat Ucar", "Kardiyoloji");

        // iki farkli nesne ayni dizide tutuluyor, ikisi de Raporlanabilir tipinde
        Raporlanabilir[] raporlar = {h1, d1};

        for (Raporlanabilir r : raporlar) {
            r.raporOlustur();
            System.out.println(r.raporOzeti());
            System.out.println();
        }

        /** Analiz Sorulari
         * 1. Raporlanabilir bir interface oldugu icin new Raporlanabilir() yazabilir miyiz? Neden?
         *    - Hayir, yazamayiz. Interface'ler soyut (abstract) yapilardir ve nesneleri dogrudan olusturulamaz (instantiate edilemez).
         *      Yalnizca bu interface'i uygulayan (implements) somut siniflarin (Hasta, Doktor gibi) nesneleri olusturulabilir.
         *
         * 2. Diziyi Raporlanabilir[] dizi olarak tanimlandi. Hem Hasta hem Doktor nesnesi ayni diziye nasıl sigdi? Bu davranisin adi nedir?
         *    - Hem Hasta hem de Doktor sinifi Raporlanabilir interface'ini uyguladigi icin Java'da "Raporlanabilir" tipinde kabul edilirler.
         *      Farkli alt siniflarin ortak bir ust referans ile yonetilebilmesine Cok Bicimlilik (Polymorphism) adi verilir.
         */
    }
}
