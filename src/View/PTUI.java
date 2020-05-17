package View;

import java.util.Scanner;

/**
 * A Plain Text User Interface (PTUI) for Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class PTUI extends UserInterface {

    // -------------------------- MESSAGE STRINGS -------------------------- //

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

    // The message for requesting location input
    private static final String LOC_INPT_MSG =
    "Enter the location number of the place you want to make a move: ";

    // The message to print when an invalid input is entered
    private static final String INVALID_INPT_MSG =
    "That was an invalid input, please enter a valid input: ";

    // The message to print when the game ends
    private static final String END_GAME_MESSAGE =
    "\n%s wins!\n";

    // ----------------------- PROCESSING CONSTANTS ------------------------ //

    // The REGEX for filtering location input
    private static final String LOCATION_RGX = "\\d";
    
    // The conversion array for input
    private static final int[] conversion = {-1, 6, 7, 8, 3, 4, 5, 0, 1, 2};

    // ------------------------ INSTANCE VARIABLES ------------------------- //

    // The scanner for reading input into the PTUI
    private Scanner scanner;

    // ------------------------------ METHODS ------------------------------ //

    /**
     * Creates a new PTUI.
     */
    public PTUI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Updates the console screen with the current board state.
     */
    @Override
    public void update() {
        BuildPTVisitor buildPTBoard = new BuildPTVisitor();
        getManager().sendVisitorToBoard(buildPTBoard);
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

    /**
     * Has the UI request input from the user to enter a location at which they
     * want to make a move.
     * 
     * @return - A number between 0-8
     */
    @Override
    public int requestLocationInput() {
        String input;

        System.out.print(LOC_INPT_MSG);
        input = scanner.nextLine();

        while (!input.matches(LOCATION_RGX)) {
            System.out.print(INVALID_INPT_MSG);
            input = scanner.nextLine();
        }

        return inputToRequestFormat(Integer.parseInt(input));
    }

    /**
     * Takes the raw integer entered in the UI and converts it to the expected
     * integer format for the request. The numbers are converted as shown
     * below:
     * 
     * 789    012
     * 456 -> 345
     * 123    678
     * 
     * @param rawInputNum - The raw number input from the console
     * @return a number in the expected format
     */
    private int inputToRequestFormat(int rawInputNum) {
        return conversion[rawInputNum];
    }

    /**
     * Displays a message for the end of the game detailing the winner.
     */
    @Override
    public void displayEndGameMessage() {
        System.out.printf(END_GAME_MESSAGE, String.valueOf(getManager().getWinner()));
    }
    
}