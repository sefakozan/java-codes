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

    public void informPlayer(int step) {

    }

    public void pickNumber() {
        this.pickedNumber = randomNum(gameMin, gameMax);
        System.out.printf("I kept a number in my mind from the %d-%d range.\n", gameMin, gameMax);
    }

    @Override
    public Answer answer(int guess) {
        Answer result;
        if (pickedNumber > guess) {
            result = Answer.BIG;
        }
        else if (pickedNumber < guess) {
            result = Answer.SMALL;
        }
        else {

            result = Answer.EQUAL;
        }
        System.out.printf("Computer: %s\n", result);
        return result;
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
        this.lastGuess = guess;
        return guess;
    }

    public int stepsNumber(int step) {
        return step;
    }
}
