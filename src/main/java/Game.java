import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Game {

    public boolean runGame = true;

    public final int dimension = 350;
    private Word secretWord;
    private Man man;

    private JFrame frame;
    private JPanel panel;
    private JLabel wordDisplay;
    private JLabel statusDisplay;
    private JTextField inputField;
    private JButton guessButton;
    private JLabel guessDisplay;

    public Game() {
        secretWord = new Word();
        man = new Man();

        frame = new JFrame();
        frame.setSize(dimension, dimension);

        panel = new JPanel();
        frame.add(panel);

        GridLayout layout = new GridLayout(5, 0);
        layout.setVgap(25);

        panel.setLayout(layout);

        statusDisplay = new JLabel("Guess a Letter");
        statusDisplay.setHorizontalAlignment(JLabel.CENTER);
        statusDisplay.setFont(new Font("Verdana", Font.PLAIN, 25));
        panel.add(statusDisplay);

        wordDisplay = new JLabel(secretWord.print());
        wordDisplay.setHorizontalAlignment(JLabel.CENTER);
        wordDisplay.setFont(new Font("Verdana", Font.PLAIN, 30));
        panel.add(wordDisplay);

        inputField = new JTextField(1);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(inputField);

        guessButton = new JButton("Guess Letter");
        guessButton.addActionListener(event -> {
            if (runGame) {
                String guess = inputField.getText();
                if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) { //Check if entered input is a valid LETTER
                    statusDisplay.setText("Enter a LETTER, please: ");
                    return;
                } else {
                    guess = guess.toLowerCase(Locale.ROOT);
                    char guessedLetter = guess.charAt(0);
                    if (secretWord.duplicateGuess(guessedLetter)) {
                        statusDisplay.setText("You've already guessed that letter, try again.");
                        return;
                    }

                    if (secretWord.guessLetter(guessedLetter, statusDisplay)) { //Check if secretWord contains guessedLetter and print accordingly
                        if (secretWord.updateDisplay(guessedLetter, wordDisplay, statusDisplay)) { //Check if whole word has been guessed
                            runGame = false;
                        }
                    } else {
                        man.wrongGuess();
                        wordDisplay.setText(secretWord.print());
                    }

                    if (!man.update(guessDisplay, statusDisplay)) { //If no more guesses
                        runGame = false;
                    }
                }
            }
        });
        panel.add(guessButton);

        guessDisplay = new JLabel("You have " + man.guesses + " guess(es) remaining.");
        guessDisplay.setHorizontalAlignment(JLabel.CENTER);
        guessDisplay.setFont(new Font("Verdana", Font.PLAIN, 30));
        panel.add(guessDisplay);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hangman");
        frame.pack();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
