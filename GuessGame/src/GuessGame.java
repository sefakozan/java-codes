public class GuessGame {
    public Player guesser;
    public Player picker;
    public int gameMin;
    public int gameMax;

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
        turnPlayer();
        startSession();
    }

    private void startSession() {
        Answer pickerAnswer;
        this.picker.informPlayer(gameMin, gameMax);
        this.guesser.informPlayer(gameMin, gameMax);
        
        do {
            this.picker.pickNumber();
            int guessedNum = this.guesser.guessNumber();
            pickerAnswer = picker.answer(guessedNum);
            System.out.println(pickerAnswer);
        }
        while (pickerAnswer != Answer.EQUAL);
    }

    public void finish() {

    }

    public void turnPlayer() {
        Player temp = guesser;
        guesser = picker;
        picker = temp;
    }


}