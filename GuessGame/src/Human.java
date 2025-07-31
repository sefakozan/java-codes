public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    public void informPlayer(int gameMin, int gameMax) {
        this.gameMin = gameMin;
        this.gameMax = gameMax;
    }

    public void pickNumber() {
        System.out.printf("Aklınızdan %d-%d aralığından bir sayı tutunuz.\n", gameMin, gameMax);
    }

    @Override
    public Answer answer(int guess) {
        System.out.println("Cevap için b,s,e giriniz.");
        return Answer.EQUAL;
    }

    @Override
    public void think(Answer answer) {
        System.out.println("Bilgisayarın verdiği cevaba göre tahmininizi düşününüz.");
    }

    public int guessNumber() {
        int guess = 0;
        System.out.print("Tahmininizi giriniz: ");
        guess = this.scanner.nextInt();
        this.lastGuess = guess;
        return guess;
    }
}
