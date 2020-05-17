package Model.Board;

import Controller.GameMoves.MoveData;
import Controller.WinProcessing.WinProcessor;
import Model.BoardVisitor;

/**
 * An interface for the components that make up a Tic-Tac-Toe board.
 * 
 * @author Steven Hulbert
 */
public interface BoardComponent {

    /**
     * Creates a new BoardComponent of this component's type.
     * 
     * @return a new BoardComponent
     */
    public BoardComponent createNewComponent();
    
    /**
     * Attempts the given move on this component.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    public boolean attemptMove(MoveData move);
    
    /**
     * Accepts a visit from a BoardVisitor.
     * 
     * Always implemented as follows:
     *      visitor.visit(this);
     * 
     * @param visitor - The visitor that is visiting this component
     */
    public void acceptVisitor(BoardVisitor visitor);

    /**
     * Gets the occupying piece for this component
     * 
     * @return the piece type char of this component
     */
    public char getOccupant();

    /**
     * Sets the win processor for this component.
     * 
     * @param winProcessor - The win processor to set it as
     */
    public void setWinProccesor(WinProcessor winProcessor);
}