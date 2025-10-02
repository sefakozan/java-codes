import java.util.Scanner;

public class ProblemSolving {
    public static void main(String[] args) {
        controlPoint();
    }

    public static void controlPoint() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("(x1,y1): ");
        float[] x1y1 = new float[]{scanner.nextInt(), scanner.nextInt()};

        System.out.print("(x2,y2): ");
        float[] x2y2 = new float[]{scanner.nextInt(), scanner.nextInt()};

        System.out.print("(x3,y3): ");
        float[] x3y3 = new float[]{scanner.nextInt(), scanner.nextInt()};

        // Doğru Denklemi y = mx + n
        float x = 1, y = 0, m = 0, n = 0;
        m = (float) (x2y2[1] - x1y1[1]) / (x2y2[0] - x1y1[0]); // y2-y1 / x2-x1 --> eğim
        n = x1y1[1] - (m) * x1y1[0];

        System.out.printf("y = %.1fx + %.1f\n", m, n);

        // x1y1 ve x2y2 noktalarının doğrusunun denklemi
        y = m * x + n; // koordinat sistemi eğimi = 0
        y = n;         // koordinat sistemi eğimi = m

        float[] xminymin = {0, 0};
        // x1 + y1 = x2 + y2 eşit olursa ne olacak?
        // kordinat sistemini döndürdükten sonra yeni noktaların yerleri bulunacak!!!!!
        if ((x1y1[0] + x1y1[1]) > (x2y2[0] + x2y2[1])) {
            xminymin[0] = x2y2[0];
            xminymin[1] = x2y2[1];
        }
        else if ((x1y1[0] + x1y1[1]) < (x2y2[0] + x2y2[1])) {
            xminymin[0] = x1y1[0];
            xminymin[1] = x1y1[1];
        }
        // 10 15, 5 8, 1 1 hata oluyor
        if (x3y3[1] > n) {
            System.out.printf("(%.1f,%.1f) noktası doğrunun (%.1f,%.1f)min noktasının perspektifine göre solunda", x3y3[0], x3y3[1], xminymin[0], xminymin[1]);
        }
        else if (x3y3[1] < n) {
            System.out.printf("(%.1f,%.1f) noktası doğrunun (%.1f,%.1f)min noktasının perspektifine göre sağında", x3y3[0], x3y3[1], xminymin[0], xminymin[1]);
        }
        else {
            System.out.printf("(%.1f,%.1f) noktası doğrunun üzerinde", x3y3[0], x3y3[1]);

        }
    }
}