package Model.Board;

import Controller.GameMoves.MoveData;
import Model.BoardVisitor;

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
     * Accepts a visit from a BoardVisitor.
     * 
     * @param visitor - The visitor that is visiting this component
     */
    @Override
    public void acceptVisitor(BoardVisitor visitor) {
        visitor.visit(this);
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
}