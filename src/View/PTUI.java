package View;

import Model.Board.TicTacToeBoard;

/**
 * A Plain Text User Interface (PTUI) for Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class PTUI extends UserInterface{

    // An output string for "clearing" the screen
    private static final String CLEAR =
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

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
    
}