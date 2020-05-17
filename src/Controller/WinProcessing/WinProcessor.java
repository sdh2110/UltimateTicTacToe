package Controller.WinProcessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Board.BoardComponent;
import Model.Board.GameBoard;
import Model.Board.Space;

/**
 * Paired with a GameBoard to determine the winner of that board.
 * 
 * @author Steven Hulbert
 */
public class WinProcessor {
    
    // The board this WinProcessor is paired with
    private GameBoard pairedBoard;
    // The width of the paired board
    private int boardWidth;

    // The valid winning setups for this processor to check
    private List<WinningSetup> winningSetups;
    // The winning piece type of this board
    private char winner;

    /**
     * Creates a new WinProcessor with no winning setups added.
     * 
     * @param pairedBoard - The board this WinProcessor is paired with
     */
    public WinProcessor(GameBoard pairedBoard) {
        this.pairedBoard = pairedBoard;
        winningSetups = new ArrayList<>();
        boardWidth = pairedBoard.getWidth();
    }

    /**
     * Creates a new WinProcessor with the given winningSetups.
     * 
     * @param pairedBoard - The board this WinProcessor is paired with
     * @param winningSetups - The valid winning setups for this processor to check
     * @param boardWidth - The width of the paired board
     */
    private WinProcessor(GameBoard pairedBoard, List<WinningSetup> winningSetups, int boardWidth) {
        this.pairedBoard = pairedBoard;
        this.winningSetups = winningSetups;
        this.boardWidth = boardWidth;
    }

    /**
     * Creates a copy of this WinProcessor that is repaired to a new board.
     * 
     * @param newlyPairedBoard - The new board to pair it to
     * @return the repaired copy of this processor
     */
    public WinProcessor createRepairedCopy(GameBoard newlyPairedBoard) {
        return new WinProcessor(newlyPairedBoard, winningSetups, boardWidth);
    }

    /**
     * Gets the winner for the board this processor is paired with.
     * 
     * @return the winner of the board
     */
    public char getWinner() {
        if (winner == Space.EMPTY) {
            updateWinner();
        }
        return winner;
    }

    /**
     * Updates the winner of the paired board.
     */
    private void updateWinner() {
        String setup = buildBoardSetup();

        for (WinningSetup validSetup : winningSetups) {
            if (validSetup.isWinningSetup(setup)) {
                winner = validSetup.getPlayerCheckedFor();
                return;
            }
        }
    }

    /**
     * Builds the string representation of the paired board's setup.
     * 
     * @return the board setup
     */
    private String buildBoardSetup() {
        Iterator<BoardComponent> iterator = pairedBoard.getComponentIterator();
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while (iterator.hasNext()) {
            builder.append(iterator.next().getOccupant());
            if (i % boardWidth == 0) {
                builder.append(Space.EMPTY);
            }
            i++;
        }

        return builder.toString();
    }

    /**
     * Adds the given setup as a valid win setup for this win processor.
     * 
     * @param basicSetup - The regex of a winning setup for an ambiguous player
     */
    public void addWinningSetup(String basicSetup) {
        winningSetups.add(new WinningSetup(basicSetup, Space.X_PIECE));
        winningSetups.add(new WinningSetup(basicSetup, Space.O_PIECE));
    }
    
}