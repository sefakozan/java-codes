import java.util.Scanner;

public class ProblemSolving {
    public static void main(String[] args) {
        controlPoint();
    }

    public static void controlPoint() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("(x1,y1): ");
        int[] x1y1 = new int[]{scanner.nextInt(), scanner.nextInt()};

        System.out.print("(x2,y2): ");
        int[] x2y2 = new int[]{scanner.nextInt(), scanner.nextInt()};

        System.out.print("(x3,y3): ");
        int[] x3y3 = new int[]{scanner.nextInt(), scanner.nextInt()};

        // Doğru Denklemi y = mx + n
        float x = 1, y = 0, m = 0, n = 0;
        m = (float) (x2y2[1] - x1y1[1]) / (x2y2[0] - x1y1[0]);
        n = x1y1[1] - (m) * x1y1[0];

        // x1y1 ve x2y2 noktalarının doğrusunun denklemi
        y = m * x + n;

    }
}