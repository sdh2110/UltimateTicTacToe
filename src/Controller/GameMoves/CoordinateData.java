package Controller.GameMoves;

import Model.Board.PieceType;

/**
 * A data packet that represents the coordinates of the move being made. It
 * wraps itself around another MoveData packet that will contain the rest of
 * the information required for this move.
 * 
 * @author Steven Hulbert
 */
public class CoordinateData implements MoveData {
    
    // The x-coordinate of the move being made
    private int xCoord;
    // The y-coordinate of the move being made
    private int yCoord;

    // The next packet of data that makes up this move
    private MoveData nextData;

    /**
     * Creates a new Coordinate data with given coordinates and next data.
     * 
     * @param xCoordinate - The x-coordinate of the move being made
     * @param yCoordinate - The y-coordinate of the move being made
     * @param nextData - The next packet of data that makes up this move
     */
    public CoordinateData(int xCoordinate, int yCoordinate, MoveData nextData) {
        xCoord = xCoordinate;
        yCoord = yCoordinate;
        this.nextData = nextData;
    }

    /**
     * Gets the x-coordinate at which this move is being attempted.
     * 
     * @return the x-coordinate
     */
    @Override
    public int getXCoordinate() {
        return xCoord;
    }

    /**
     * Gets the y-coordinate at which this move is being attempted.
     * 
     * @return the y-coordinate
     */
    @Override
    public int getYCoordinate() {
        return yCoord;
    }

    /**
     * Not utilized for this data packet so always returns EMPTY.
     * 
     * @return PieceType.EMPTY
     */
    @Override
    public PieceType getPlacementType() {
        return PieceType.EMPTY;
    }

    /**
     * Get the inner bit of data stored in this GameMove containing the next
     * information required for processing this move.
     * 
     * @return gets the next packet of data for this move
     */
    @Override
    public MoveData getNextData() {
        return nextData;
    }
    
}