package Controller.GameMoves;

/**
 * A data packet that specifies the type of piece to be placed with this move.
 * 
 * @author Steven Hulbert
 */
public class PieceData implements MoveData {

    //The type of piece to be placed with this move
    private char placement;

    /**
     * Creates a new PieceData that describes a move placing a certain kind of
     * piece.
     * 
     * @param placementType - The type of piece to be placed with this move
     */
    public PieceData(char placementType) {
        placement = placementType;
    }

    /**
     * Not utilized for this data packet so always returns NONEXISTANT_ATR.
     * 
     * @return NONEXISTANT_ATR
     */
    @Override
    public int getLocation() {
        return NONEXISTANT_ATR;
    }

    /**
     * Gets the type of piece to place with this move.
     * 
     * @return the piece type
     */
    @Override
    public char getPlacementType() {
        return placement;
    }

    /**
     * Not utilized for this data packet so always returns null.
     * 
     * @return null
     */
    @Override
    public MoveData getNextData() {
        return null;
    }
    
}