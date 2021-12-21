import java.util.Locale;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Word secretWord = new Word();
        Man man = new Man();

        Scanner input = new Scanner(System.in);
        secretWord.print();

        while (true) {
            System.out.println("Guess a Letter: ");
            String guess = input.nextLine();
            guess = guess.replaceAll("\\s", "");
            while (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) { //Check if entered input is a valid LETTER
                System.out.println("Enter a LETTER, please: ");
                guess = input.nextLine();
            }
            guess = guess.toLowerCase(Locale.ROOT);
            char guessedLetter = guess.charAt(0);

            if (secretWord.duplicateGuess(guessedLetter)) {
                continue;
            }

            if (secretWord.guessLetter(guessedLetter)) { //Check if secretWord contains guessedLetter and print accordingly
                if (secretWord.updateDisplay(guessedLetter)) { //Check if whole word has been guessed
                    break;
                }
            } else {
                man.wrongGuess();
                secretWord.print();
            }

            if (!man.update()) { //If no more guesses
                break;
            }
        }
    }
}
