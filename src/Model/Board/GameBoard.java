package Model.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controller.GameManagement.ManagedComponent;
import Controller.GameMoves.MoveData;

/**
 * Represents a board for a nonspecific Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class GameBoard extends ManagedComponent implements BoardComponent {
    
    // The spaces that make up the board
    private List<BoardComponent> spaces;

    /**
     * Attempts the given move on this board.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    @Override
    public boolean attemptMove(MoveData move) {
        return spaces.get(move.getLocation()).attemptMove(move.getNextData());
    }

    /**
     * Initializes the data for this board to be set up for a new game.
     * 
     * @param componentType - The type of component to fill this board with
     * @param width - The width of the board to be created
     */
    protected void initializeBoard(BoardComponent componentType, int width) {
        int componentCount = width * width;
        spaces = new ArrayList<>(componentCount);
        for (int i = 0; i < componentCount; i++) {
            spaces.add(componentType.createNewComponent());
        }
    }

    /**
     * Creates an iterator for iterator for iterating through the components
     * that make up this GameBoard.
     * 
     * @return an iterator for the board
     */
    public Iterator<BoardComponent> getComponentIterator() {
        return spaces.iterator();
    }
}