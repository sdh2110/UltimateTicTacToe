package Model.Board;

import Controller.WinProcessing.WinProcessor;
import Model.BoardVisitor;

/**
 * Represents a Tic-Tic-Toe board for a game of Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class TicTacToeBoard extends GameBoard {

    // The standard width for a Tic-Tac-Toe board
    private static final int TTT_WIDTH = 3;
    
    // The standard rules of three in a line in any direction to win
    private static WinProcessor THREE_IN_LINE_TO_WIN;
    static {
        THREE_IN_LINE_TO_WIN = new WinProcessor(TTT_WIDTH);
        
        // Horizantal
        THREE_IN_LINE_TO_WIN.addWinningSetup("(.*)AAA(.*)");
        // Verticle
        THREE_IN_LINE_TO_WIN.addWinningSetup("(.*)A...A...A(.*)");
        // Diagonol down right
        THREE_IN_LINE_TO_WIN.addWinningSetup("(.*)A....A....A(.*)");
        // Diagonol up right
        THREE_IN_LINE_TO_WIN.addWinningSetup("(.*)A..A..A(.*)");
    }

    /**
     * Creates a new TicTacToeBoard as a 3x3 grid of empty spaces.
     */
    public TicTacToeBoard() {
        initializeBoard(Space.FOR_FACTORY, TTT_WIDTH, THREE_IN_LINE_TO_WIN);
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

    /**
     * Accepts a visit from a BoardVisitor.
     * 
     * @param visitor - The visitor that is visiting this component
     */
    @Override
    public void acceptVisitor(BoardVisitor visitor) {
        visitor.visit(this);
    }
    
}