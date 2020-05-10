package Model;

import Controller.GameMoves.MoveData;

public class SingleSpace implements Space {

    // The occupant off this space
    private PieceType occupant;

    public SingleSpace() {
        occupant = PieceType.EMPTY;
    }

    /**
     * Creates a new SingleSpace.
     * 
     * @return a new SingleSpace.
     */
    @Override
    public Space createNewSpace() {
        return new SingleSpace();
    }

    /**
     * Attempts a given move on this space.
     * 
     * @param move - The move being attempted
     * @return whether or not the move was a valid move
     */
    @Override
    public boolean attemptMove(MoveData move) {
        if (occupant == PieceType.EMPTY) {
            
        }
        return false;
    }
    
}