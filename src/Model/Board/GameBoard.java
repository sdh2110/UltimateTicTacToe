package Model.Board;

import java.util.ArrayList;
import java.util.Iterator;

import Controller.GameMoves.MoveData;

/**
 * Represents a board for a nonspecific Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class GameBoard implements BoardComponent {
    
    // The spaces that make up the board
    private BoardComponent[][] spaces;

    /**
     * Attempts the given move on this board.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    @Override
    public boolean attemptMove(MoveData move) {
        return spaces[move.getXCoordinate()][move.getYCoordinate()].attemptMove(move.getNextData());
    }

    /**
     * Initializes the data for this board to be set up for a new game.
     * 
     * @param componentType - The type of component to fill this board with
     * @param width - The width of the board to be created
     * @param height - The heigt of the board to be created
     */
    protected void initializeBoard(BoardComponent componentType, int width, int height) {
        spaces = new BoardComponent[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                spaces[i][j] = componentType.createNewComponent();
            }
        }
    }

    /**
     * Creates an iterator for iterator for iterating through the components
     * that make up this GameBoard.
     * 
     * @return an iterator for the board
     */
    public Iterator<BoardComponent> getComponentIterator() {
        ArrayList<BoardComponent> components = new ArrayList<>();
        for (int y = 0; y < spaces.length; y++) {
            for (int x = 0; x < spaces.length; x++) {
                components.add(spaces[x][y]);
            }
        }
        return components.iterator();
    }
}