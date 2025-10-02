import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    protected final Scanner scanner;
    public String name;
    public int score;
    protected int gameMin;
    protected int gameMax;
    protected int lastGuess;
    protected int step;
    private final Random random;

    public Player(String name) {
        this.name = name;
        this.random = new Random();
        scanner = new Scanner(System.in);
    }

    public abstract void informPlayer(int gameMin, int gameMax);

    public abstract void informPlayer(int step);

    public abstract void pickNumber();

    public abstract Answer answer(int guess);

    public abstract void think(Answer answer);

    public abstract int guessNumber();

    public abstract int stepsNumber(int step);

    // min-max dahil değil arasında random
    protected int randomNum(int min, int max) {
        return this.random.nextInt(max - min - 1) + min + 1;
    }
}
