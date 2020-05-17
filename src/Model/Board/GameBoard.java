package Model.Board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controller.GameManagement.ManagedComponent;
import Controller.GameMoves.MoveData;
import Controller.WinProcessing.WinProcessor;

/**
 * Represents a board for a nonspecific Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class GameBoard extends ManagedComponent implements BoardComponent {
    
    // The spaces that make up the board
    private List<BoardComponent> spaces;

    // The processor that determines if this board is in a winning state
    private WinProcessor winProcessor;

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
    protected void initializeBoard(BoardComponent componentType, int width, WinProcessor winProcessor) {
        setWinProccesor(winProcessor);

        int componentCount = width * width;
        spaces = new ArrayList<>(componentCount);
        BoardComponent nextComponent;

        for (int i = 0; i < componentCount; i++) {
            nextComponent = componentType.createNewComponent();
            nextComponent.setWinProccesor(winProcessor);
            spaces.add(nextComponent);
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

    /**
     * Gets the occupying player piece for this board, in other words, the
     * player that is winning this board.
     * 
     * @return the piece type char of this component
     */
    public char getOccupant() {
        return winProcessor.getWinner();
    }

    /**
     * Gets the width of this board.
     * 
     * @return the width
     */
    public int getWidth() {
        return (int)Math.sqrt(spaces.size());
    }

    /**
     * Sets the win processor for this board, making a copy of the given
     * processor and pairing the copy to this board.
     * 
     * @param winProcessor - The win processor to use
     */
    @Override
    public void setWinProccesor(WinProcessor winProcessor) {
        this.winProcessor = winProcessor.createRepairedCopy(this);
    }

}