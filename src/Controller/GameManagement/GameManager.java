package Controller.GameManagement;

import java.util.ArrayList;
import java.util.List;

import Controller.PlayManager;
import Controller.GameMoves.LocationData;
import Controller.GameMoves.MoveData;
import Controller.GameMoves.PieceData;
import Controller.Players.Player;
import Model.BoardVisitor;
import Model.Board.GameBoard;
import Model.Board.PieceType;
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
    // The players in this game
    private List<Player> players;

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
        players = new ArrayList<>(2);

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
        List<Integer> request = new ArrayList<>();
        request.add(Player.TO_BE_FILLED);
        return getPlayer(playerNumber).fulfillMoveRequest(request);
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

    /**
     * Adds another player to this game if both players in this game have not
     * been added yet.
     * 
     * @param player - The player being added
     */
    public void addPlayer(Player player) {
        if (players.size() < 2) {
            players.add(player);
            takeManagmentOf(player);
        }
    }

    /**
     * Gets the player requested, either player 1 or 2.
     * 
     * @param playerNum - The player number being requested
     * @return the requested player
     */
    private Player getPlayer(int playerNum) {
        return players.get(playerNum - 1);
    }

    /**
     * Has the UI request input from the user to enter a location at which they
     * want to make a move.
     * 
     * @return - A number between 0-8
     */
    public int reqLocationFromUI() {
        return ui.requestLocationInput();
    }
}