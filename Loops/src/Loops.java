public class Loops {
    public static int i = -2;

    public static void main(String[] args) {
        // for(Initialization; Condition; Update)
        // ifadeler soldan sağa şeklinde okunur
        // teorik olarak sınırsız ifadeler yazılabilir, condition hariç
        for (i = -1, loopInit1(), i = 0, loopInit2(); loopCond(); loopUp1(), i++, loopUp2()) {
            System.out.println("in for: " + i);
        }
    }

    public static void loopInit1() {
        System.out.println("loopinit1: " + i);
    }

    public static void loopInit2() {
        System.out.println("loopinit2: " + i);
    }

    public static boolean loopCond() {
        return i < 10;
    }

    public static void loopUp1() {
        System.out.println("loopup1: " + i);

    }

    public static void loopUp2() {
        System.out.println("loopup2: " + i);

    }
}