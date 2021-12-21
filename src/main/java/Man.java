public class Man {

    private int guesses;
    public Man() {guesses = 5;}

    public void wrongGuess() {guesses--;}
    public boolean update() {
        if (guesses > 0) {
            System.out.println("You have " + guesses + " guess(es) remaining." + "\n");
            return true;
        } else {
            System.out.println("You lose!");
            return false;
        }

        //TODO: Add functionality for drawing man after each wrong guess
    }
}
