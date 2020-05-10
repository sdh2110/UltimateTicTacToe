package Controller.GameMoves;

import Model.PieceType;

/**
 * A packet containing the information for a move made in a Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public interface GameMove {

    /**
     * Gets the x-coordinate at which this move is being attempted.
     * 
     * @return the x-coordinate
     */
    public int getXCoordinate();

    /**
     * Gets the y-coordinate at which this move is being attempted.
     * 
     * @return the t-coordinate
     */
    public int getYCoordinate();
    
    /**
     * Gets the type of piece to place with this move.
     * 
     * @return the piece type
     */
    public PieceType getPieceType();

    /**
     * Get the inner bit of data stored in this GameMove containing the next
     * information required for processing this move.
     * 
     * @return gets the next packet of data for this move
     */
    public GameMove getNextData();
 }