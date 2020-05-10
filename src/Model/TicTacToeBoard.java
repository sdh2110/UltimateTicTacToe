package Model;

/**
 * Represents a Tic-Tic-Toe board for a game of Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class TicTacToeBoard extends GameBoard {

    // The standard width for a Tic-Tac-Toe board
    private static final int TTT_WIDTH = 3;
    // The standard height for a Tic-Tac-Toe board
    private static final int TTT_HEIGHT = 3;

    /**
     * Creates a new TicTacToeBoard as a 3x3 grid of empty spaces.
     */
    public TicTacToeBoard() {
        initializeBoard(Space.FOR_FACTORY, TTT_WIDTH, TTT_HEIGHT);
    }

    /**
     * Creates a new TicTacToeBoard.
     * 
     * @return a new TicTacToeBoard
     */
    @Override
    public BoardComponent createNewComponent() {
        return new TicTacToeBoard();
    }
    
}