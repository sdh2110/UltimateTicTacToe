package Model;

import Model.Board.*;

/**
 * A interface for classes that traverse a board to visit the individual
 * components, performing some sort of action on each.
 * 
 * @author Steven Hulbert
 */
public interface BoardVisitor {
    
    /**
     * Visit a space piece and perform the operation on it.
     * 
     * @param space - The Space to visit
     */
    public void visit(Space space);
    
    /**
     * Visit a game board and perform the operation on it.
     * 
     * @param space - The GameBoard to visit
     */
    public void visit(TicTacToeBoard ticTacToeBoard);
}