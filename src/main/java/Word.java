import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    private String word;
    private ArrayList<Character> guessedLetters;
    private ArrayList<Character> display;

    private String[] wordRoster = {"cereal", "boxing", "dictionary", "github", "college", "linguini", "codingiscool", "chemistry"};

    public Word() {
        Random rand = new Random();
        int wordIndex = rand.nextInt(wordRoster.length - 1);
        word = wordRoster[wordIndex];
        guessedLetters = new ArrayList<>();
        display = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            display.add('_');
        }
    }

    public boolean guessLetter(char c, JLabel label) {
        guessedLetters.add(c);
        if (word.contains(c + "")) {
            return true;
        } else {
            label.setText("Wrong!");
            return false;
        }
    }

    public boolean duplicateGuess(char c) {
        if (guessedLetters.contains(c)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateDisplay(char c, JLabel displayLabel, JLabel statusLabel) {
        for (int i =0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                display.set(i, c);
            }
        }

       displayLabel.setText(print());
        if (!display.contains('_')) {
            statusLabel.setText("You Win!");
            return true;
        } else {
            return false;
        }
    }

    public String print() {
        String sOut = "";
        for (Character c : display) {
            sOut += (c + " ");
        }
        return sOut;
    }
}
