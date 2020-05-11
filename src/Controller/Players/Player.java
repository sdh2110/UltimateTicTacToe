package Controller.Players;

import Controller.GameManagement.ManagedComponent;
import Controller.GameMoves.MoveData;

/**
 * A system that controls a player in the Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class Player extends ManagedComponent {
    
    /**
     * Has the player fill the given move request, modifying it to contain the
     * data of the move the player wants to attempt.
     * 
     * @param request - The format of the move the player should create
     */
    public abstract void fulfillMoveRequest(MoveData request);

}