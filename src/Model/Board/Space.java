package Model.Board;

import Controller.GameMoves.MoveData;
import Model.BoardVisitor;

/**
 * An interface for spaces on a GameBoard.
 * 
 * @author Steven Hulbert
 */
public class Space implements BoardComponent {

    // Char representation of board spaces
    public static final char EMPTY = '.';
    public static final char X_PIECE = 'X';
    public static final char O_PIECE = 'O';

    // A Space object used for the createNewComponent factory method
    public static final Space FOR_FACTORY = new Space();

    // The occupant off this space
    private char occupant;

    public Space() {
        occupant = EMPTY;
    }

    /**
     * Creates a new Space.
     * 
     * @return a new Space
     */
    @Override
    public BoardComponent createNewComponent() {
        return new Space();
    }

    /**
     * Attempts the given move on this space.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    @Override
    public boolean attemptMove(MoveData move) {
        if (occupant != EMPTY || move.getPlacementType() == EMPTY) {
            return false;
        }
        occupant = move.getPlacementType();
        return true;
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

    /**
     * Gets the occupant of this space.
     * 
     * @return the occupant
     */
    @Override
    public char getOccupant() {
        return occupant;
    }
}