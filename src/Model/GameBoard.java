package Model;

import Controller.GameMove;

/**
 * Represents a board for a nonspecific Tic-Tac-Toe game.
 * 
 * @author Steven Hulbert
 */
public abstract class GameBoard {
    
    // The spaces that make up the board
    private Space[][] spaces;

    /**
     * Attempts the given move on this board.
     * 
     * @param move - The information for the move that is being attempted
     * @return whether or not the move was a valid move
     */
    public boolean attemptMove(GameMove move) {
        return spaces[move.getXCoordinate()][move.getYCoordinate()].attemptMove(move);
    }

    /**
     * Initializes the data for this board to be set up for a new game.
     * 
     * @param spaceType - The type of space to fill this board with
     * @param width - The width of the board to be created
     * @param height - The heigt of the board to be created
     */
    protected void initializeBoard(Space spaceType, int width, int height) {
        spaces = new Space[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                spaces[i][j] = spaceType.createNewSpace();
            }
        }
    }
}