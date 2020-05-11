package Controller.GameManagement;

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

    /**
     * Creates a new GameManager, managing the specified components.
     * 
     * @param gameName - The name of this game
     * @param gameBoard - The board for this game
     * @param userInterface - The UI to display this game
     */
    public GameManager(String gameName, GameBoard gameBoard, UserInterface userInterface) {
        name = gameName;
        board = gameBoard;
        ui = userInterface;

        takeManagmentOf(board);
        takeManagmentOf(ui);
    }

    /**
     * Starts the game that this manager is managing.
     */
    public void beginGame() {
        ui.initialize();
        System.out.println(ui.requestLocationInput());
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
}