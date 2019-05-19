package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Doucet doucet.victor@gmail.com
 */
public abstract class KeyEventSubscription {

    private final List<KeyEventSubscriber> subscribers = new ArrayList<KeyEventSubscriber>();

    /**
     * addSubscriber.
     *
     * @param subscriber TODO
     */
    public void addSubscriber(KeyEventSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Méthode appelée lorsqu'une touche est pressée, elle va avertir tous ses
     * abonnés de l'évènement.
     *
     * @param s Touche pressée
     */
    public void keyPressed(String s) {
        for (KeyEventSubscriber subscriber : subscribers) {
            subscriber.keyPressed(s);
        }
    }
}
