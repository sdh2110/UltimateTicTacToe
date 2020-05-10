package Model;

import Controller.GameMoves.MoveData;

/**
 * An interface for spaces on a GameBoard.
 * 
 * @author Steven Hulbert
 */
public class Space implements BoardComponent {

    // The occupant off this space
    private PieceType occupant;

    public Space() {
        occupant = PieceType.EMPTY;
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
        if (occupant != PieceType.EMPTY ||
            move.getPlacementType() == PieceType.EMPTY) {
                return false;
        }
        occupant = move.getPlacementType();
		return true;
    }
}