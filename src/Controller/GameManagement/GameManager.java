package Controller.GameManagement;

import Controller.PlayManager;
import Controller.GameMoves.MoveData;
import Model.BoardVisitor;
import Model.Board.GameBoard;
import View.UserInterface;

/**
 * Manages interactions between the different main components of a Tic-Tac-Toe
 * game.
 * 
 * @author Steven Hulbert
 */
public class GameManager {

    // The name of this game
    private String name;

    // The board for this game
    private GameBoard board;
    // The user interface for this game
    private UserInterface ui;
    // The play manager for this game
    private PlayManager playManager;

    /**
     * Creates a new GameManager, managing the specified components.
     * 
     * @param gameName - The name of this game
     * @param gameBoard - The board for this game
     * @param userInterface - The UI to display this game
     */
    public GameManager(String gameName, GameBoard gameBoard, UserInterface userInterface, PlayManager playManager) {
        name = gameName;
        board = gameBoard;
        ui = userInterface;
        this.playManager = playManager;

        takeManagmentOf(board);
        takeManagmentOf(ui);
        takeManagmentOf(playManager);
    }

    /**
     * Starts the game that this manager is managing.
     */
    public void beginGame() {
        ui.initialize();
        playManager.runGame();
    }

    /**
     * Assigns this GameManager to be the manager of a certain component.
     * 
     * @param component - The component to manage
     */
    private void takeManagmentOf(ManagedComponent component) {
        component.assignManager(this);
    }

    /**
     * Gets the name of this game.
     * 
     * @return the name of this game
     */
    public String getNameOfGame() {
        return name;
    }

    /**
     * Has a visitor visit the board to complete its processing.
     * 
     * @param visitor - The visitor to send
     */
    public void sendVisitorToBoard(BoardVisitor visitor) {
        board.acceptVisitor(visitor);
    }

    /**
     * Requests a player (either 1 or 2) to make a move. Gets the desired move
     * from that player and returns the requested move.
     * 
     * @param playerNumber - The player number to request a move from
     * @return the move made by the player
     */
    public MoveData requestMoveFromPlayer(int playerNumber) {
        return null; //TODO
    }
    
    /**
     * Attempts the given move on the game's board.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    public boolean attemptMove(MoveData move) {
        return board.attemptMove(move);
    }
}