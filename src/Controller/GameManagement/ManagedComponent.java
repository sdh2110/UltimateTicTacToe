package Controller.GameManagement;

/**
 * A class to extend for any components that will be managed by a GameManager.
 * 
 * @author Steven Hulbert
 */
public class ManagedComponent {
    
    // The manager of this component
    private GameManager manager;

    /**
     * Assigns a mangager to this component.
     * 
     * @param manager - The manager to assign
     */
    public void assignManager(GameManager manager) {
        this.manager = manager;
    }

    /**
     * Get the manager for this component
     * 
     * @return the manager
     */
    protected GameManager getManager() {
        return manager;
    }
}