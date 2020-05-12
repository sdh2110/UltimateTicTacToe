package Controller.GameMoves;

import Model.Board.Space;

/**
 * A data packet that represents the location of the move being made. It wraps
 * itself around another MoveData packet that will contain the rest of the
 * information required for this move.
 * 
 * @author Steven Hulbert
 */
public class LocationData implements MoveData {
    
    // The location of the move being made
    private int location;

    // The next packet of data that makes up this move
    private MoveData nextData;

    /**
     * Creates a new LocationData with given location and next data.
     * 
     * @param nextData - The next packet of data that makes up this move
     */
    public LocationData(MoveData nextData) {
        this.location = OPEN_REQUEST;
        this.nextData = nextData;
    }

    /**
     * Creates a new LocationData with given location and next data.
     * 
     * @param location - The location of the move being made
     * @param nextData - The next packet of data that makes up this move
     */
    public LocationData(int location, MoveData nextData) {
        this.location = location;
        this.nextData = nextData;
    }

    /**
     * Not utilized for this data packet so always returns EMPTY.
     * 
     * @return PieceType.EMPTY
     */
    @Override
    public char getPlacementType() {
        return Space.EMPTY;
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

    /**
     * Gets the location of the move.
     * 
     * @return the move location
     */
    @Override
    public int getLocation() {
        return location;
    }
    
}