package observer;

/**
 * @author Victor Doucet doucet.victor@gmail.com
 */
public interface MouseEventSubscriber {
    /**
     * Appelé quand la souris est utilisée.
     * @param s Touche pressée
     */
    void mousePressed(String s);
}
