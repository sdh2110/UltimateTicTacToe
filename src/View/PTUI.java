package View;

/**
 * A Plain Text User Interface (PTUI) for Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class PTUI extends UserInterface {

    // An output string for "clearing" the screen
    private static final String CLEAR =
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    // The message that is printed at the start of the game
    private static final String START_MSG =
    "Welcome to %s!\n" +
    "Moves will be entered in a range from 1-9 that correlate to the\n" +
    "numbers on the number pad as shown below:\n" +
    "789\n" +
    "456\n" +
    "123\n\n";

    /**
     * Updates the console screen with the current board state.
     */
    @Override
    public void update() {
        BuildPTVisitor buildPTBoard = new BuildPTVisitor();
        getSubject().acceptVisitor(buildPTBoard);
        String ptBoard = buildPTBoard.getBoardString();

        System.out.println(CLEAR);
        System.out.println(ptBoard);
    }

    /**
     * Initializes this user interface, printing out a starting message.
     */
    @Override
    public void initialize() {
        System.out.printf(START_MSG, getManager().getNameOfGame());
    }
    
}