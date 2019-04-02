package view;

import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import observer.MouseEventSubscriber;

/**
 *
 * @author jeremy
 */
public class ParcelView implements View, MouseEventSubscriber{
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
    /**
     * Position en x.
     */
    private int x;
    /**
     * Position en y.
     */
    private int y;
    
    public ParcelView(GraphicsContext graphicsContext, boolean isUnlock) {
        this.baseInit(graphicsContext, isUnlock);
    }
    
    public ParcelView(GraphicsContext graphicsContext, boolean isUnlock, int x, int y) {
        this.baseInit(graphicsContext, isUnlock);
        this.x = x;
        this.y = y;
    }
    
    private void baseInit(GraphicsContext graphicsContext, boolean isUnlock) {
        this.graphicsContext = graphicsContext;
        this.isUnlock = isUnlock;
        this.parcelImg = new HashMap();
        this.initImg();
        this.CurrentImg = parcelImg.get(this.isUnlock);
    }

    public Image getCurrentImg() {
        return CurrentImg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void update(boolean isUnlock) {
        this.isUnlock = isUnlock;
        this.CurrentImg = parcelImg.get(this.isUnlock);
    }
    
    /**
     * Affichage de la plante.
     */
    public void display() {
        graphicsContext.drawImage(this.CurrentImg, x, y);
    }

    /**
     * Initialise les images de la pacelle lock ou unlock, en allant
     * chercher l'image sous le format pathVersImg/parcel_etat.typeImg
     * Exemple : assets/img/parcel_lock.png
     */
    protected void initImg() {
        parcelImg.put(Boolean.TRUE, new Image(imgPath 
                + "/parcel_unlock" + imgType));
        parcelImg.put(Boolean.FALSE, new Image(imgPath 
                + "/parcel_lock" + imgType));
    }

    @Override
    public void mousePressed(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
