package model;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class contain data for the field.
 *
 * @author jeremy
 */
public class FieldModel implements Serializable {

    /**
     * Constructeur de FieldModel.
     */
    public FieldModel() {
        
    }
    
    /**
     * Fais évoluer les données du modèle et celles de ces enfants.
     *
     * @return True si les données du modèle ont été modifiées (ou d'un enfant)
     */
    public boolean update() {
        boolean updated = false;
        /*for (CharacterModel model : this.characters) {
            this.updatePersoVision(model);
            // On a pas le choix sur le sens de cette instruction car si un
            // personnage a déjà bougé durant ce tour updated sera à true et
            // l'opérateur ignorera l'instruction à droite
            if (model.getCurrentLap() != this.nbLapToRun) {
                this.mapModel.detectCollision(model);
            }
            updated = model.update() || updated;

        }
            
        return updated;*/
        return true;
    }
}
