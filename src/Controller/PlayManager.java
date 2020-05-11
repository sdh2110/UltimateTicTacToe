package Controller;

import Controller.GameManagement.ManagedComponent;

/**
 * Manages the play of a Tic-Tac-Toe game. Runs the turns.
 * 
 * @author Steven Hulbert
 */
public class PlayManager extends ManagedComponent {
    
    // Whether or not it is player one's turn
    private boolean isPlayerOneTurn;

    /**
     * Runs the game of Tic-Tac-Toe
     */
    private void runGame() {
        while (true) {
            processNextTurn();
            endTurn();
        }
    }
    
    /**
     * Ends the current turn, moving the game to the next turn.
     */
    private void endTurn() {
        isPlayerOneTurn = !isPlayerOneTurn;
    }

    /**
     * Gets the player number of the current player whose turn it is.
     * 
     * @return the current player number
     */
    public int getCurrentPlayerTurn() {
        return isPlayerOneTurn ? 1 : 2;
    }

    private void processNextTurn() {}

}