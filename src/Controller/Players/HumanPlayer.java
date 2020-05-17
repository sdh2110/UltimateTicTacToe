package Controller.Players;

/**
 * A human player. Requests for information are always fulfilled through the
 * UI.
 * 
 * @author Steven Hulbert
 */
public class HumanPlayer extends Player {

    /**
     * Creates a new human player.
     * 
     * @param playerPieceType - The piece this player places
     */
    public HumanPlayer(char playerPieceType) {
        initializePlayer(playerPieceType);
    }

    /**
     * Gets the move input from this player. As a human player, the input is
     * given through the UI.
     * 
     * @return the location number of the move
     */
    @Override
    protected int getMoveInput() {
        return getManager().reqLocationFromUI();
    }
    
}