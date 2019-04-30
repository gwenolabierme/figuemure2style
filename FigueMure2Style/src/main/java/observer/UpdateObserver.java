package observer;

/**
 * @author Victor Doucet doucet.victor@gmail.com
 */
public interface UpdateObserver {
    /**
     * Est appelé par l'observable lors d'une mise à jour.
     * @param observable UpdateObservable
     */
    void notifyUpdate(UpdateObservable observable);
}
