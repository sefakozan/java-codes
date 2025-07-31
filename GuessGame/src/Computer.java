public class Computer extends Player {
    private int pickedNumber;
    private int lastMin, lastMax;


    public Computer() {
        super("Computer");
    }

    public void informPlayer(int gameMin, int gameMax) {
        this.gameMin = gameMin;
        this.gameMax = gameMax;
        this.lastMin = gameMin;
        this.lastMax = gameMax;
    }

    public void pickNumber() {
        this.pickedNumber = randomNum(gameMin, gameMax);
        System.out.printf("Aklımdan %d-%d aralığından bir sayı tuttum.\n", gameMin, gameMax);
    }

    @Override
    public Answer answer(int guess) {
        if (pickedNumber > guess) {
            return Answer.BIG;
        }
        else if (pickedNumber < guess) {
            return Answer.SMALL;
        }
        else {
            return Answer.EQUAL;
        }
    }

    @Override
    public void think(Answer answer) {
        switch (answer) {
            case Answer.BIG -> this.lastMin = lastGuess;
            case Answer.SMALL -> this.lastMax = lastGuess;
        }
    }

    public int guessNumber() {
        int guess = this.randomNum(this.lastMin, this.lastMax);
        System.out.printf("Tuttuğunuz sayı %d?", guess);
        this.lastGuess = guess;
        return guess;
    }
}
