import javax.swing.*;

public class Man {

    protected int guesses;
    public Man() {guesses = 5;}

    public void wrongGuess() {guesses--;}
    public boolean update(JLabel guesslabel, JLabel statusLabel) {
        guesslabel.setText("You have " + guesses + " guess(es) remaining." + "\n");
        if (guesses > 0) {
            return true;
        } else {
            statusLabel.setText("You lose!");
            return false;
        }

        //TODO: Add functionality for drawing man after each wrong guess
    }
}
