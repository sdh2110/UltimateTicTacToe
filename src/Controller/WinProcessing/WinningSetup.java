package Controller.WinProcessing;

/**
 * A setup for a game board that defines a winning state for a certain player.
 * 
 * @author Steven Hulbert
 */
public class WinningSetup {

    // The char for an ambiguous player
    public static final char AMBIGUOUS_PLAYER = '*';
    
    // The regex defining this winning setup
    private String setupRegex;

    // The winner that this setup is defined for
    private char winnerOfSetup;

    /**
     * Creates a new winning setup for a certian winner.
     * 
     * @param basicSetup - The regex of a winning setup for an ambiguous player
     * @param winnerOfSetup - The player to have as winner for this setup
     */
    public WinningSetup(String basicSetup, char winnerOfSetup) {
        setupRegex = basicSetup.replace(AMBIGUOUS_PLAYER, winnerOfSetup);
        this.winnerOfSetup = winnerOfSetup;
    }

    /**
     * Checks if the given setup is a winning setup based off of this single
     * winning setup.
     * 
     * @param setupToCheck - The setup to check winning status of
     * @return whether or not the setup is a winning one
     */
    public boolean isWinningSetup(String setupToCheck) {
        return setupToCheck.matches(setupRegex);
    }

    /**
     * Gets the player that this winning setup was checking for.
     * 
     * @return - The winner that this setup is defined for
     */
    public char getPlayerCheckedFor() {
        return winnerOfSetup;
    }
}