package View;

import Controller.GameManagement.ManagedComponent;

/**
 * An abstract class for all UIs used by Tic-Tac-Toe games.
 * 
 * @author Steven Hulbert
 */
public abstract class UserInterface extends ManagedComponent {

    /**
     * Updates the user interface.
     */
    public abstract void update();

    /**
     * Initializes this user interface.
     */
    public abstract void initialize();
}