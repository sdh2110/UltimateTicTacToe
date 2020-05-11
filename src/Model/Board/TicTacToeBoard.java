package Model.Board;

import Model.BoardVisitor;

/**
 * Represents a Tic-Tic-Toe board for a game of Tic-Tac-Toe.
 * 
 * @author Steven Hulbert
 */
public class TicTacToeBoard extends GameBoard {

    // The standard width for a Tic-Tac-Toe board
    private static final int TTT_WIDTH = 3;

    /**
     * Creates a new TicTacToeBoard as a 3x3 grid of empty spaces.
     */
    public TicTacToeBoard() {
        initializeBoard(Space.FOR_FACTORY, TTT_WIDTH);
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