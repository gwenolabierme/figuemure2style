package observer;

import model.plant.PlantVarietyEnum;
import model.stylisticDevice.StylisticDeviceEnum;

/**
 * @author Victor Doucet doucet.victor@gmail.com
 */
public interface MouseEventSubscriber {
    /**
     * Appelé quand la souris est utilisée.
     * @param s Touche pressée
     * @param sde TODO
     * @param x TODO
     * @param y TODO
     */
    void mousePressed(String s, StylisticDeviceEnum sde, double x, double y);
    /**
     * Appelé quand la souris est utilisée.
     * @param s Touche pressée
     * @param pve TODO
     * @param x TODO
     * @param y TODO
     */
    void mousePressed(String s, PlantVarietyEnum pve, double x, double y);
}
