package View;

import java.util.Iterator;

import Model.BoardVisitor;
import Model.Board.BoardComponent;
import Model.Board.Space;
import Model.Board.TicTacToeBoard;

/**
 * A visitor that traverses a board to build a string representation of it.
 * 
 * @author Steven Hulbert
 */
public class BuildPTVisitor implements BoardVisitor {

    // Char representation of board spaces
    private static final char EMPTY_C = '.';
    private static final char X_PIECE_C = 'X';
    private static final char O_PIECE_C = 'O';

    // The string representation of a board that is being built
    private StringBuilder boardString;

    /**
     * Creates a clean new BuildPTVisitor. 
     */
    public BuildPTVisitor() {
        boardString = new StringBuilder();
    }

    /**
     * Visit a space piece and perform the operation on it.
     * 
     * @param space - The Space to visit
     */
    @Override
    public void visit(Space space) {
        switch (space.getOccupant()) {
            case EMPTY:
            boardString.append(EMPTY_C);
            break;
            case X_PIECE:
            boardString.append(X_PIECE_C);
            break;
            case O_PIECE:
            boardString.append(O_PIECE_C);
        }
    }

    /**
     * Visits a game board, traversing through it to visit all of its
     * components.
     * 
     * @param space - The GameBoard to visit
     */
    @Override
    public void visit(TicTacToeBoard ticTacToeBoard) {
        Iterator<BoardComponent> traverse = ticTacToeBoard.getComponentIterator();
        while (traverse.hasNext()) {
            traverse.next().acceptVisitor(this);
        }
    }

    /**
     * Gets the completed string representation of the board that was visited.
     * 
     * @return the board string
     */
    public String getBoardString() {
        int spacing = (int)Math.sqrt(boardString.length());

        for (int i = boardString.length() - spacing; i > 0; i -= spacing) {
            boardString.insert(i, '\n');
        }

        return boardString.toString();
    }    
}