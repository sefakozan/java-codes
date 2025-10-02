import java.util.Locale;

/*****************************************************************************************************
 *
 * javac (derleyici): file.java dosyasını JVM koduna compile eder ve file.class (java ByteCode) oluşturur
 * java file: ByteCode'u (.class) JVM içerisinde çalıştırır
 * javap -verbose -c file.class: JVM ByteCode'un içeriğini yazdırır
 *
 ***********
 *
 * JDK - Developer Kit (JRE + JVM + DevTools)
 * Java uygulamaları geliştirmek için gereken derleyici (javac), kütüphaneler ve
 * diğer araçları içeren kapsamlı bir geliştirme kitidir.
 *
 * JRE - Runtime Environment (JVM):
 * Java uygulamalarını çalıştırmak için gerekli olan JVM, standart kütüphaneler ve çalışma zamanı bileşenlerini sağlayan ortamdır.
 *
 * JVM
 * Java ByteCode'u çalıştırarak platform bağımsızlığını sağlayan, donanımdan bağımsız bir sanal makinedir.
 *
 ************
 *
 * Java Compiled bir dil mi yoksa Interpreted bir dil mi?
 * Derleme Aşaması: Java kodu, javac tarafından bytecode çevrilir.
 * Bu bytecode, platformdan bağımsız bir ara formattır ve doğrudan donanım üzerinde çalışmaz.
 *
 * Yorumlama Aşaması: Bu bytecode, JVM (Java Virtual Machine) tarafından çalıştırılırken yorumlanır veya
 * JIT (Just-In-Time) derleyicisiyle makine diline çevrilerek yürütülür.
 * JVM, bayt kodu platforma özgü makine koduna dönüştürerek çalıştırır.
 *
 ******************************************************************************************************/

public class HelloJava {
    public static void main(String[] args) {
        // String sınıfı Immutable (değiştirilemez) bir sınıftır, yani bir kez oluşturulduktan sonra içeriği değiştirilemez.
 
        // join: Birden fazla Stringleri birleştirir ve aralarına belirtilen ayraçı ekler.
        String argStr = String.join(" ", args);
        p("args", argStr);

        // 1. String Literal
        // String havuzunda (String Pool) saklanır, böylece bellek verimliliği sağlanır.
        String str10 = "Merhaba Dünya";
        // str10.reverse(); --> str10 Immutable
        p("str10", str10);

        // 2. New
        // Yeni bir nesne oluşturur ve String havuzunda değil, heap belleğinde saklanır.
        String str20 = new String("Merhaba Dünya");
        p("str20", str20);

        // Method Overload
        p("str10 == str20", str10 == str20); // adres karşılaştırılıyor

        // 3. null String
        String str30 = null; // Henüz bir değer atanmamış
        String str31;
        System.out.println();
        p("str30", str30);

        // Atama operatörü atadığı değeri geri dönderir.
        p("str31", str31 = null);

        // 4. Empty String ("")
        String str40 = "";
        String str41 = String.valueOf("");
        String str42 = new String();
        String str43 = "   "; // Blank String
        p("str40", str40);
        p("str41", str41);
        p("str42", str42);
        p("str43", str43);
        p("str43.trim()", str43.trim());

        // null string ve empty string farklıdır
        if (str40.equals(str30) == false) {
            p("str40.equals(str30) == false", "true");
        }

        // 5. Char Array
        char[] harfler = {'M', 'e', 'r', 'h', 'a', 'b', 'a'};
        String str50 = new String(harfler);
        String str51 = new String(harfler, 2, 3);
        p("str50", str50);
        p("str51", str51);

        // 6. StringBuilder veya StringBuffer'dan String oluşturma
        // StringBuilder sınıfı, mutable (değiştirilebilir) string işlemleri için kullanılır ve performans açısından String sınıfına göre daha verimlidir
        StringBuilder sb = new StringBuilder();
        sb.append("Merhaba");
        sb.append(" ");
        sb.append("Dünya");
        sb.reverse();

        // toString metodu ile sb'yi Immutable String'e dönüştürüyoruz.
        String str60 = sb.toString();
        p("str60", str60);

        // toUpperCase
        Locale locale = Locale.of("tr", "TR");
        String str70 = "merhaba ilk ğenç dünya".toUpperCase(locale);
        p("str70", str70);
    }

    public static void p(String name, String value) {

        if (value == null) {
            value = "#null#";
        }
        if (value.isEmpty()) {
            value = "#empty#";
        }
        if (value.isBlank()) {
            value = "#blank#";
        }

        // %-30s  --> %s ile yazdırır, sola hizalı şekilde sağa boşluk
        // %30s   --> %s ile yazdırır, sağa hizalı şekilde sola boşluk
        // %7.3f  --> 3.14159   --> Çıktı: [  3.141] 7 karakter (. dahili)
        // %-30.3f  --> 3.14159   --> Çıktı: [3.141`25 boşluk`] (. dahil)
        // %.3s   --> Merhaba   --> Çıktı: [Mer] ilk 3 karakter
        // %05d   --> 42        --> Çıktı: 00042
        // %,d    --> 1234567   --> 1,234,567
        // %+d    --> 42        --> +42

        // %s - Str, %d - Int, %f - Flt/Dbl, %c - Char, %b - Boolean
        System.out.printf("name: %-30s value: %s\n", name, value);
    }

    public static void p(String name, boolean value) {
        System.out.printf("name: %-30s value: %b", name, value);
    }
}