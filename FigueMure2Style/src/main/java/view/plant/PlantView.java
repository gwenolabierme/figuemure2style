package view.plant;

import model.plant.GrowthStateEnum;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.plant.Plant;
import view.View;

/**
 * Classe générique pour les plantes.
 * @author jeremy
 */
public class PlantView implements View{
    /**
     * Chemin jusqu'aux images.
     */
    protected final String imgPath = "/assets/img";
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
    protected Image CurrentImg;
    /**
     * Map contenant les images de la croissance de la plante.
     */
    protected static HashMap<GrowthStateEnum, Image> growthStatesImg;
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

    public PlantView(GraphicsContext graphicsContext, Plant model) {
        this.model = model;
        baseInit(graphicsContext);
    }
    
    public PlantView(GraphicsContext graphicsContext, Plant model, int x, int y) {
        this.model = model;
        this.baseInit(graphicsContext);
        this.x = x;
        this.y = y;
    }
    
    private void baseInit(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.growthStatesImg = new HashMap();
        this.initImg();
        this.CurrentImg = growthStatesImg.get(model.getGrowthState());
    }

    public Plant getModel() {
        return model;
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
    
    public void update() {
        this.CurrentImg = growthStatesImg.get(model.getGrowthState());
    }
    
    /**
     * Affichage de la plante.
     */
    public void display() {
        update();
        graphicsContext.drawImage(this.CurrentImg, 0, 0);
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
