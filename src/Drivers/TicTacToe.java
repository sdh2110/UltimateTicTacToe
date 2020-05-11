package Drivers;

import Controller.PlayManager;
import Controller.GameManagement.GameManager;
import Model.Board.GameBoard;
import Model.Board.TicTacToeBoard;
import View.PTUI;
import View.UserInterface;

/**
 * A driver class for running a Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public class TicTacToe {

    /**
     * Creates a Tic-Tac-Toe game and runs it.
     */
    public static void main(String[] args) {
        GameBoard gameBoard = new TicTacToeBoard();
        UserInterface userInterface = new PTUI();
        PlayManager playManager = new PlayManager();
        GameManager manager = new GameManager("Tic-Tac-Toe", gameBoard, userInterface, playManager);
        manager.beginGame();
    }
}