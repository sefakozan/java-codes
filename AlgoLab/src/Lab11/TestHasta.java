package Lab11;

public class TestHasta {
    public static void main(String[] args) {
        // Soru 1: this Anahtar Sozcugu – Hasta Kayit Sistemi
        Hasta h1 = new Hasta("Sefa Kozan");
        Hasta h2 = new Hasta("Ferhat Ucar", "98765432101");
        Hasta h3 = new Hasta("Ayse Demir", "12345678901", "05415235152", "AB Rh-");

        h1.bilgileriGoster(); // once 1 parametreli constructor, sonra 2 parametreli constructor, sonra 4 parametreli constructor calisir
        System.out.println(Hasta.sayac1Param);
        h2.bilgileriGoster(); // once 2 parametreli constructor, sonra 4 parametreli constructor calisir
        System.out.println(Hasta.sayac2Param);
        h3.bilgileriGoster(); // 4 parametreli constructor calisir
        System.out.println(Hasta.sayac4Param);
    }
}
