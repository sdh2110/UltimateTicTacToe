package Controller;

/**
 * A packet containing the information for a move made in a Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public class GameMove {
    
    // The x-coordinate at which this move is being attempted
    private int xCoordinate;
    // The y-coordinate at which this move is being attempted
    private int yCoordinate;

    /**
     * Gets the x-coordinate at which this move is being attempted.
     * 
     * @return the x-coordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Gets the y-coordinate at which this move is being attempted.
     * 
     * @return the t-coordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }
 }