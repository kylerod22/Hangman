import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    public final int dimension = 350;
    private Word secretWord;
    private Man man;

    private JFrame frame;
    private JPanel panel;
    private JLabel wordDisplay;
    private JLabel status;
    private JTextField inputField;
    private JButton guessButton;

    public Game() {

        secretWord = new Word();
        man = new Man();

        frame = new JFrame();
        frame.setSize(dimension, dimension);

        panel = new JPanel();
        frame.add(panel);

        GridLayout layout = new GridLayout(4, 0);
        layout.setVgap(25);

        panel.setLayout(layout);

        status = new JLabel("Guess a Letter");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(new Font("Verdana", Font.PLAIN, 25));
        panel.add(status);


        wordDisplay = new JLabel(secretWord.print());
        wordDisplay.setHorizontalAlignment(JLabel.CENTER);
        wordDisplay.setFont(new Font("Verdana", Font.PLAIN, 30));
        panel.add(wordDisplay);

        inputField = new JTextField(1);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(inputField);

        guessButton = new JButton("Guess Letter");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(guessButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hangman");
        frame.pack();



        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();


        /*


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
        }*/
    }
}
