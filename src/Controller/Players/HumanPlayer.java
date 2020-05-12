package Controller.Players;

import java.util.List;

import Controller.GameMoves.LocationData;
import Controller.GameMoves.MoveData;
import Controller.GameMoves.PieceData;

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
     * Has the player fill the given move request, modifying it to contain the
     * data of the move the player wants to attempt.
     * 
     * @param requestParams - The format of the move the player should create
     * @return the move to attempt
     */
    public MoveData fulfillMoveRequest(List<Integer> requestParams) {
        MoveData move = new PieceData(getPieceToPlace());

        for (Integer requestComponent : requestParams) {
            int location = 0;
            if (requestComponent == TO_BE_FILLED) {
                location = getManager().reqLocationFromUI();
            }
            else {
                location = requestComponent;
            }
            move = new LocationData(location, move);
        }

        return move;
    }
    
}