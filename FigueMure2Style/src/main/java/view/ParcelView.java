package view;

import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.plant.GrowthStateEnum;
import model.plant.Plant;

/**
 *
 * @author jeremy
 */
public class ParcelView {
    /**
     * Chemin jusqu'aux images.
     */
    protected final String imgPath = "assets/img";
    /**
     * Format des images.
     */
    protected final String imgType = ".png";
    /**
     * True si la parcelle est déverouillée, False sinon.
     */
    protected boolean isUnlock;
    /**
     * Image actuelle de la plante.
     */
    protected Image CurrentImg;
    /**
     * Map contenant les images de la croissance de la plante.
     */
    HashMap<Boolean, Image> parcelImg;
    /**
     * Contexte graphique dans lequel on va afficher la plante.
     */
    private GraphicsContext graphicsContext;

    public ParcelView(GraphicsContext graphicsContext, boolean isUnlock) {
        this.graphicsContext = graphicsContext;
        this.isUnlock = isUnlock;
        this.initImg();
        this.CurrentImg = parcelImg.get(this.isUnlock);
    }

    public Image getCurrentImg() {
        return CurrentImg;
    }
    
    public void update(boolean isUnlock) {
        this.isUnlock = isUnlock;
        this.CurrentImg = parcelImg.get(this.isUnlock);
    }
    
    /**
     * Affichage de la plante.
     */
    public void display() {
        graphicsContext.drawImage(this.CurrentImg, 0, 0);
    }

    /**
     * Initialise les images de la pacelle lock ou unlock, en allant
     * chercher l'image sous le format pathVersImg/parcel_etat.typeImg
     * Exemple : assets/img/parcel_lock.png
     */
    protected void initImg() {
        parcelImg.put(true, new Image(imgPath 
                + "/parcel_unlock" + imgType));
        parcelImg.put(false, new Image(imgPath 
                + "/parcel_lock" + imgType));
    }
}
