package view;

import figuemure2style.App;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.FieldModel;
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.GrowthStateEnum;
import model.plant.Mure;
import model.plant.Pattate;
import model.plant.Plant;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;
import model.stylisticDevice.StylisticDeviceEnum;
import model.user.User;
import observer.MouseEventSubscriber;
import view.plant.PlantView;

/**
 *
 * @author jeremy
 */
public class ParcelView implements View, MouseEventSubscriber {

    /**
     * Chemin jusqu'aux images.
     */
    protected final String imgPath = "/assets/img";
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
    /**
     * Plante view sur parcelle
     */
    private PlantView plantView;

    public ParcelView(GraphicsContext graphicsContext, boolean isUnlock, PlantView plant) {
        this.baseInit(graphicsContext, isUnlock, plant);
    }

    public ParcelView(GraphicsContext graphicsContext, boolean isUnlock, PlantView plant, int x, int y) {
        this.baseInit(graphicsContext, isUnlock, plant);
        this.x = x;
        this.y = y;
    }

    private void baseInit(GraphicsContext graphicsContext, boolean isUnlock, PlantView plant) {
        this.graphicsContext = graphicsContext;
        this.isUnlock = isUnlock;
        this.parcelImg = new HashMap();
        this.initImg();
        this.CurrentImg = parcelImg.get(this.isUnlock);
        this.plantView = plant;
        
        setPlantPos();
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
        if (this.plantView != null) {
            this.plantView.display();
        }
    }

    /**
     * Initialise les images de la pacelle lock ou unlock, en allant chercher
     * l'image sous le format pathVersImg/parcel_etat.typeImg Exemple :
     * assets/img/parcel_lock.png
     */
    protected void initImg() {
        parcelImg.put(Boolean.TRUE, new Image(imgPath
                + "/parcel_unlock" + imgType));
        parcelImg.put(Boolean.FALSE, new Image(imgPath
                + "/parcel_lock" + imgType));
    }
    
    private void setPlantPos() {
        if (plantView != null) {
            plantView.setX((int) (this.getX()
                    + this.getCurrentImg().getWidth() / 2 
                    - plantView.getCurrentImg().getWidth() / 2)); // on centre le légume sur la parcelle
            plantView.setY((int) (this.getY()
                    + this.getCurrentImg().getHeight() / 2
                    - plantView.getCurrentImg().getHeight() / 2));
        }
    }

    public PlantView getPlantView() {
        return plantView;
    }

    @Override
    public void mousePressed(String s, StylisticDeviceEnum sde) {
        //TODO : agir sur plante en fonction sde
        if (this.plantView != null) {
        
            Plant plant = this.plantView.getModel();

            if (plant.getStyDevEat().equals(sde)) {
                if (plant.getGrowthState().equals(GrowthStateEnum.SPROUT)) {
                    plant.setGrowthState(GrowthStateEnum.MEDIUM);
                } else {
                    if (plant.getGrowthState().equals(GrowthStateEnum.MEDIUM)) {
                        plant.setGrowthState(GrowthStateEnum.FINAL);        
                    } else {
                        if (plant.getGrowthState().equals(GrowthStateEnum.FINAL)) {
                            User user = JfxView.user;
                            user.setScore(user.getScore() + 
                                    plant.getPrice(), user.getPseudo());
                            if (user.getInventory().containsKey(plant.getName())) {
                                int nbPlant = user.getInventory().get(plant.getName());
                                user.getInventory().put(plant.getName(), nbPlant+1);
                            }


                            this.plantView = null;      
                        }    
                    }
                }
            } else {
                plant.setLife(plant.getLife() + 1);
                if (plant.getLife() <= 0) {
                    this.plantView = null;
                }
            }
        }
    }

    @Override
    public void mousePressed(String s, PlantVarietyEnum plant) {
        if (this.plantView == null) {
            Plant p = null;
            
            if (plant.equals(PlantVarietyEnum.CAROTTE)) {
                p = new Carotte();
            } else {
                if (plant.equals(PlantVarietyEnum.FIGUE)) {
                    p = new Figue();
                } else {
                    if (plant.equals(PlantVarietyEnum.MURE)) {
                        p = new Mure();
                    } else {
                        if (plant.equals(PlantVarietyEnum.PATATTE)) {
                            p = new Pattate();
                        } else {
                            if (plant.equals(PlantVarietyEnum.POMME)) {
                                p = new Pomme();
                            } else {
                                if (plant.equals(PlantVarietyEnum.TOMATE)) {
                                    p = new Tomate();
                                }
                            }
                        }
                    }
                }
            }
            this.plantView = new PlantView(graphicsContext, p);
            setPlantPos();
        }
    }
}
