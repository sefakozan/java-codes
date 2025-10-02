public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    public void informPlayer(int gameMin, int gameMax) {
        this.gameMin = gameMin;
        this.gameMax = gameMax;
    }

    public void informPlayer(int step) {
        this.step = step;
    }

    public void pickNumber() {
        System.out.println("-".repeat(50));
        System.out.printf("You knew it in %d steps! Now it's my turn.\n", step);
        System.out.printf("Keep in mind a number from the range %d-%d.\n", gameMin, gameMax);
        System.out.println("Info: Enter B, S, E for the answer.");
        System.out.println("-".repeat(50));
    }

    @Override
    public Answer answer(int guess) {
        char answerChar = ' ';
        boolean flag = false;
        do {
            System.out.printf("Is that the number %d?\n", guess);
            System.out.printf("%s: ", this.name);

            // konsoldan sadece b, s, e girilecek
            try {
                String answer = scanner.next();

                // Girdinin tek karakter olduğunun kontrolü
                if (answer.length() != 1) {
                    throw new IllegalArgumentException("Please enter a valid word!.. (b, s, e)");
                }

                answerChar = answer.toLowerCase().charAt(0);

                // b ve s ve e'ye eşit değilse hata fırlat
                if (answerChar != 'b' && answerChar != 's' && answerChar != 'e') {
                    throw new IllegalArgumentException("Please enter a valid word!..\n");
                }

                // hatalara yakalanmazsa girilen değer geçerli
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!flag);

        if (answerChar == 'b') {
            return Answer.BIG;
        }
        else if (answerChar == 's') {
            return Answer.SMALL;
        }
        else {
            return Answer.EQUAL;
        }
    }

    @Override
    public void think(Answer answer) {
        System.out.print("\nConsider your guess based on the computer's answer.");
    }

    public int guessNumber() {
        int guess = 0;
        System.out.print("Guess: ");
        guess = this.scanner.nextInt();
        this.lastGuess = guess;
        return guess;
    }

    public int stepsNumber(int step) {
        return step;
    }
}
