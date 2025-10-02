/**
 * STATIC KEYWORD
 * Java'da bir metot static olarak tanımlandığında, bu metot sınıfa aittir.
 * ve bir sınıfın nesnesi (instance) oluşturulmadan doğrudan çağrılabilir.
 * Yani, static metotlar nesneye özgü değildir, sınıf düzeyinde çalışır.
 * Bu nedenle, static metotlar genellikle sınıfın genel işlevlerini gerçekleştirmek veya
 * nesne oluşturmadan kullanılabilecek yardımcı metotlar için kullanılır.
 * **************************
 * Çok spesifik bir iş olmadığı sürece static olan tek metot main metodudur.
 * Çünkü program başlamadan önce ram'de yer alabilmesi gerekir.
 * <p>
 * JVM ve Program Başlangıcı:
 * Bir Java programı çalıştığında, JVM ilk olarak main metodunu arar ve yürütmeye başlar.
 * Bu noktada henüz hiçbir nesne oluşturulmamıştır, çünkü nesne oluşturma işlemi (new operatörü ile) programın çalışması sırasında yapılır.
 * Dolayısıyla, JVM'nin main metodunu çağırabilmesi için bu metodun nesneye bağlı olmadan çalışabilmesi gerekir.
 * <p>
 * RAM'de Yer Alma:
 * static metotlar ve değişkenler, sınıfın yüklenmesi sırasında (class loading) JVM tarafından bellekte alan ayrılır.
 * Bu, static üyelerin programın başlangıcında erişilebilir olmasını sağlar.
 * **************************
 * ** static Metotlarda Sadece static Metotlar Çağrılabilir, Neden?
 * static metotlar, sınıfın bir nesne olmadan çalışır.
 * non-static metotlar (instance metot) bir nesneye bağlıdır ve bir nesne olmadan çalışamaz.
 * Bu yüzden, bir static metot içinde non-static bir metot doğrudan çağrılamaz.
 * Eğer bir static metot içinde non-static bir metot çağrılmak istenirse,
 * önce o sınıfın bir nesnesi (instance) oluşturulmalı ve bu metot o nesne üzerinden çağrılmalıdır.
 * <p>
 * ** static Metot İçinde Neden this Kullanılamaz?
 * static metotlar, bir sınıfın nesnesi olmadan çağrılabilir.
 * Bu durumda, this hangi nesneyi işaret edeceği belirsizdir, çünkü bir nesne olmayabilir.
 * this, yalnızca nesneye özgü bağlamlarda (instance metotlarda) kullanılabilir. static bağlamda böyle bir nesne referansı yoktur.
 */

import java.util.Scanner;
import java.util.Arrays;

public final class GameManager {
    // GuessGame Field'ları ayarlanması için nesne tanımlandı
    private final Scanner scanner;
    private GuessGame game;

    public GameManager() {
        scanner = new Scanner(System.in);
    }

    // Kullanıcının ismini alacak
    // Kullanıcıdan tahmin aralığını alacak
    // Oyun arasında skor yazılacak
    // Oyun arasında oyuna devam edebilir veya çıkabilir*****
    // Tahmin etme sırası bir insana, bir bilgisayara geçecek
    // 1 Tur tamamlanınca oyun aralığı değiştirilebilir*****
    public static void main(String[] args) {
        GameManager manager = new GameManager();

        manager.greeting();

        manager.createGame();

        manager.game.start();

        manager.game.finish();

        manager.pressToContinue();

        manager.scanner.close();
    }

    // insan ismi ve oyun aralığı alınacak
    private void createGame() {
        String playerName = this.getHumanPlayerName();

        System.out.println("-".repeat(50));
        System.out.printf("Welcome %s!\n", playerName);

        int[] gameRange = this.getRange();
        this.game = new GuessGame(playerName, gameRange[0], gameRange[1]);
    }

    private void greeting() {
        System.out.println("\t".repeat(6) + "*".repeat(53));
        System.out.println("\t".repeat(6) + "*" + "\t".repeat(13) + "*");
        System.out.println("\t".repeat(6) + "*" + "\t".repeat(4) + "Welcome to Guess Game!" + "\t".repeat(4) + "*");
        System.out.println("\t".repeat(6) + "*" + "\t".repeat(13) + "*");
        System.out.println("\t".repeat(6) + "*".repeat(53) + "\n");
    }

    private String getHumanPlayerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public void pressToContinue() {
        try {
            System.in.read();
            System.in.skip(System.in.available()); // Kalan girişleri temizler
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] getRange() {
        System.out.println("Write the guess range of the game with a space in between...");

        String[] rangeStr = {"0", "0"};
        int rangeInt0 = 0, rangeInt1 = 0;
        // try-catch içinde flag kullanmak önemli
        boolean flag = false;
        do {
            System.out.print("\nSmall Range: ");
            //rangeStr = new String[]{scanner.next(), scanner.next()};
            rangeStr[0] = new String(scanner.next());
            System.out.print("Large Range: ");
            rangeStr[1] = new String(scanner.next());

            try {
                rangeInt0 = Integer.parseUnsignedInt(rangeStr[0]); // hata yakalanırsa catch bloğuna gider, flag'e uğramaz
                rangeInt1 = Integer.parseUnsignedInt(rangeStr[1]); // hata yakalanırsa catch bloğuna gider, flag'e uğramaz
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number!..");
            }
        }
        while (rangeInt0 < 0 || rangeInt1 < 0 || !flag);
        int[] rangeInt = {rangeInt0, rangeInt1};
        Arrays.sort(rangeInt);

        System.out.println("-".repeat(50));

        return rangeInt;
    }
}
