package model;

import figuemure2style.App;
import java.io.Serializable;
import model.plant.Carotte;
import model.plant.Plant;
import model.plant.PlantVarietyEnum;

/**
 * Class contain data for the field.
 *
 * @author jeremy
 */
public class FieldModel implements Serializable {
    /**
     * Mode debug ?
     */
    private boolean debug = true;
    /**
     * Nombre de parcelles dispo au début.
     */
    private int nbFreePlot;
    /**
     * Matrice du jardin.
     * null = parcelle vide.
     * Plant sinon.
     */
    private Plant [][] garden;
    
    /**
     * Constructeur de FieldModel.
     */
    public FieldModel() {
        nbFreePlot = App.freePlotBegin;
        
        // Charger sauvegarde
        
        garden = new Plant[App.gardenSize][App.gardenSize];
        
        if(debug) {
            printGarden();
        }
    }
    
    /**
     * Fais évoluer les données du modèle et celles de ses enfants.
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
    
    private void printGarden() {
        int i, j;
        Plant pl;
        
        System.out.println("**********GARDEN************");
        i = 0;
        while(i < App.gardenSize) {
            j = 0;
            while(j < App.gardenSize) {
                pl = garden[i][j];
                
                if(pl == null) {
                    System.out.print(pl + "   ");
                } else {
                    System.out.print(pl.getName() + "   ");
                }
                ++j;
            }
            ++i;
            System.out.println("");
        }
    }
}
