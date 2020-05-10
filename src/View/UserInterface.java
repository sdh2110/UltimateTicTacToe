package View;

import Model.Board.GameBoard;

/**
 * An abstract class for all UIs used by Tic-Tac-Toe games.
 * 
 * @author Steven Hulbert
 */
public abstract class UserInterface {

    // The board that this UI will display
    private GameBoard subjectBoard;
    
    /**
     * Attachs a game board to this UserInterface for the interface to display.
     * 
     * @param board - The board to attach
     */
    public void attachBoard(GameBoard subjectBoard) {
        this.subjectBoard = subjectBoard;
    }

    /**
     * Gets the suject board of this UI.
     * 
     * @return the subject board
     */
    protected GameBoard getSubject() {
        return subjectBoard;
    }

    /**
     * Updates the user interface.
     */
    public abstract void update();
}