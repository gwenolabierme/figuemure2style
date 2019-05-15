package observer;

import java.util.ArrayList;
import java.util.List;
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
    public void mousePressed(String s, StylisticDeviceEnum sde) {
        for (MouseEventSubscriber subscriber : subscribers) {
            subscriber.mousePressed(s, sde);
        }
    }
    
}
