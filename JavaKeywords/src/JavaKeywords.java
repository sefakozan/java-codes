public class JavaKeywords {
    public static void main(String[] args) {
        // abstract classlardan nesne yaratılamaz
        // Hayvan hayvan1 = new Hayvan();

        System.out.println(Hayvan.getToplamHayvanSayisi());

        // Kedi ve Köpek nesneleri oluşturuyoruz
        Kedi kedi = new Kedi("Pamuk", 3, "Van Kedisi");
        Kopek kopek = new Kopek("Karabaş", 5, "Kangal");

        // Bilgileri yazdırıyoruz
        kedi.bilgiYazdir();
        kedi.sesCikar();
        System.out.println();

        kopek.bilgiYazdir();
        kopek.sesCikar();
        System.out.println();

        // Toplam hayvan sayısını yazdır
        System.out.println("Toplam hayvan sayısı: " + Hayvan.getToplamHayvanSayisi());
    }
}