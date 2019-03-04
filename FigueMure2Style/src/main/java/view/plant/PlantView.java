package view.plant;

import java.util.HashMap;
import javafx.scene.image.Image;
import model.plant.Plant;

/**
 * Classe générique pour les plantes.
 * @author jeremy
 */
public abstract class PlantView {
    /**
     * Chemin jusqu'aux images.
     */
    protected final String imgPath = "assets/img";
    /**
     * Format des images.
     */
    protected final String imgType = ".png";
    /**
     * Model de la plante.
     */
    protected final Plant model;
    /**
     * Image actuelle de la plante.
     */
    protected final Image CurrentImg;
    /**
     * Map contenant les images de la croissance de la plante.
     */
    HashMap<GrowthStateEnum, Image> growthStatesImg;

    public PlantView(Plant model) {
        this.model = model;
        this.CurrentImg = growthStatesImg.get(GrowthStateEnum.SPROUT);
    }

    public Plant getModel() {
        return model;
    }

    public Image getCurrentImg() {
        return CurrentImg;
    }

    /**
     * Initialise les images de la plante dans les trois état possible, en allant
     * chercher l'image sous le format pathVersImg/nomPlante_etat.typeImg
     * Exemple : assets/img/carotte_sprout.png
     */
    protected void initImg() {
        growthStatesImg.put(GrowthStateEnum.SPROUT, new Image(imgPath 
                + "/" + model.getName().toString() + "_sprout" + imgType));
        growthStatesImg.put(GrowthStateEnum.MEDIUM, new Image(imgPath 
                + "/" + model.getName().toString() + "_medium" + imgType));
        growthStatesImg.put(GrowthStateEnum.FINAL, new Image(imgPath 
                + "/" + model.getName().toString() + "_final" + imgType));
    }
    
}
