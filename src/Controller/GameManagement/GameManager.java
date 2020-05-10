package Controller.GameManagement;

import Model.Board.GameBoard;
import View.UserInterface;

/**
 * Manages interactions between the different main components of a Tic-Tac-Toe
 * game.
 * 
 * @author Steven Hulbert
 */
public class GameManager {

    // The board for this game
    private GameBoard board;

    // The user interface for this game
    private UserInterface ui;

    /**
     * Creates a new GameManager, managing the specified components.
     * 
     * @param gameBoard - The board for this game
     * @param userInterface - The UI to display this game
     */
    public GameManager(GameBoard gameBoard, UserInterface userInterface) {
        board = gameBoard;
        ui = userInterface;
        ui.attachBoard(board);
    }

    /**
     * Starts the game that this manager is managing.
     */
    public void beginGame() {
        ui.update();
    }
}