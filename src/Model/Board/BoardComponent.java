package Model.Board;

import Controller.GameMoves.MoveData;

/**
 * An interface for the components that make up a Tic-Tac-Toe board.
 * 
 * @author Steven Hulbert
 */
public interface BoardComponent {

    /**
     * Creates a new BoardComponent of this component's type.
     * 
     * @return a new BoardComponent
     */
    public BoardComponent createNewComponent();
    
    /**
     * Attempts the given move on this component.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    public boolean attemptMove(MoveData move);
    
}