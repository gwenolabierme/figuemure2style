package observer;

import java.util.ArrayList;
import java.util.List;
import model.plant.PlantVarietyEnum;
import model.stylisticDevice.StylisticDeviceEnum;

/**
 * @author Victor Doucet doucet.victor@gmail.com
 */
public abstract class MouseEventSubscription {
    private final List<MouseEventSubscriber> subscribers = new ArrayList<MouseEventSubscriber>();

    public void addSubscriber(MouseEventSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Méthode appelée lorsqu'un event souris est déclenché, elle va avertir tous
     * ses abonnés de l'évènement.
     * @param s type event
     */
    public void mousePressed(String s, StylisticDeviceEnum sde, double x, double y) {
        for (MouseEventSubscriber subscriber : subscribers) {
            subscriber.mousePressed(s, sde, x, y);
        }
    }
    
    /**
     * Méthode appelée lorsqu'un event souris est déclenché, elle va avertir tous
     * ses abonnés de l'évènement.
     * @param s type event
     */
    public void mousePressed(String s, PlantVarietyEnum pve, double x, double y) {
        for (MouseEventSubscriber subscriber : subscribers) {
            subscriber.mousePressed(s, pve, x, y);
        }
    }
    
}
