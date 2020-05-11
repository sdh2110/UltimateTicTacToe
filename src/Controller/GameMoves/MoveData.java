package Controller.GameMoves;

import Model.Board.PieceType;

/**
 * A packet containing the information for a move made in a Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public interface MoveData {

    /**
     * Gets the location of the move.
     * 
     * @return the move location
     */
    public int getLocation();
    
    /**
     * Gets the type of piece to place with this move.
     * 
     * @return the piece type
     */
    public PieceType getPlacementType();

    /**
     * Get the inner bit of data stored in this GameMove containing the next
     * information required for processing this move.
     * 
     * @return gets the next packet of data for this move
     */
    public MoveData getNextData();
 }