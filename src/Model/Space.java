package Model;

import Controller.GameMoves.GameMove;

/**
 * An interface for spaces on a GameBoard.
 * 
 * @author Steven Hulbert
 */
public interface Space {

    /**
     * Creates a new space of this space's type.
     * 
     * @return a new space.
     */
    public Space createNewSpace();
    
    /**
     * Attempts a given move on this space.
     * 
     * @param move - The move being attempted
     * @return whether or not the move was a valid move
     */
    public boolean attemptMove(GameMove move);
}