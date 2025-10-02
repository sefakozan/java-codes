public class GuessGame {
    public Player guesser;
    public Player picker;
    public int gameMin;
    public int gameMax;
    private int step = 0;
    private int humanStep = 0;
    private int computerStep = 0;

    // Constract'ı ayarlanacak, kim başlayacak
    public GuessGame(String playerName, int gameMin, int gameMax) {
        this.guesser = new Human(playerName);
        this.picker = new Computer();
        this.gameMin = gameMin;
        this.gameMax = gameMax;
    }

    public void gameRange(int getMin, int getMax) {
        this.gameMin = getMin;
        this.gameMax = getMax;
    }

    public void start() {
        startSession();
        humanStep = this.guesser.stepsNumber(step);
        step = 0;
        turnPlayer();
        startSession();
        computerStep = this.guesser.stepsNumber(step);
    }

    private void startSession() {
        Answer pickerAnswer;
        this.picker.informPlayer(gameMin, gameMax);
        this.guesser.informPlayer(gameMin, gameMax);

        this.picker.pickNumber();
        do {
            int guessedNum = this.guesser.guessNumber();
            pickerAnswer = picker.answer(guessedNum);

            if (pickerAnswer != Answer.EQUAL) {
                this.guesser.think(pickerAnswer);
            }
            System.out.println();
            step++;
        }
        while (pickerAnswer != Answer.EQUAL);
        this.guesser.informPlayer(step);
        step = this.guesser.stepsNumber(step);
    }

    public void turnPlayer() {
        // turn player
        Player temp = guesser;
        guesser = picker;
        picker = temp;
    }

    public void finish() {
        printScore();
    }

    private void printScore() {
        System.out.println("-".repeat(50));
        System.out.println("Computer step: " + computerStep);
        // human yerine insan ismi yazılacak
        System.out.printf("Human step   : %d\n", humanStep);

        if (humanStep < computerStep) {
            System.out.println("Congratulations! You've won the game!!!");
        }
        else if (humanStep == computerStep) {
            System.out.println("Oops... We ended up with a draw...");
        }
        else {
            System.out.println("Hooray! I won the game!!!");
        }
        System.out.println("-".repeat(50));
        System.out.print("Press any key to exit..");
    }
}