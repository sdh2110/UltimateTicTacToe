package Controller.Players;

import java.util.List;

import Controller.GameManagement.ManagedComponent;
import Controller.GameMoves.MoveData;

/**
 * A system that controls a player in the Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class Player extends ManagedComponent {

    // The code for a piece of data that needs to be filled in a move request
    public static final int TO_BE_FILLED = -1;

    // The piece this player places
    private char playerPiece;
    
    /**
     * Has the player fill the given move request, modifying it to contain the
     * data of the move the player wants to attempt.
     * 
     * @param requestParams - The format of the move the player should create
     * @return the move to attempt
     */
    public abstract MoveData fulfillMoveRequest(List<Integer> requestParams);

    /**
     * Gets the type of piece this player places.
     * 
     * @return the piece type
     */
    protected char getPieceToPlace() {
        return playerPiece;
    }

    /**
     * Initializes this player.
     * 
     * @param playerPieceType - The piece this player places
     */
    protected void initializePlayer(char playerPieceType) {
        playerPiece = playerPieceType;
    }

}