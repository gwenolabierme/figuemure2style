package view;

import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.GrowthStateEnum;
import model.plant.Mure;
import model.plant.Patate;
import model.plant.Plant;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;
import model.stylisticDevice.StylisticDeviceEnum;
import model.user.User;
import observer.MouseEventSubscriber;
import static view.JfxView.stage;
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
    /**
     * Chemin jusqu'aux images.
     */
    protected final String imgFigureDeStylePath = "/assets/img/figureDeStyle";
    /**
     * Image actuelle du paneau de la plante.
     */
    protected Image FigureDeSyleImg;

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
        setPanelImg();
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
        graphicsContext.drawImage(this.FigureDeSyleImg, this.x - 15, this.y + 90);
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
    public void mousePressed(String s, StylisticDeviceEnum sde, double x, double y) {
        User usr = JfxView.user;
        if ((x >= this.getX()) && (x <= this.getX() + this.CurrentImg.getWidth())
                && (y >= this.getY()) && (y <= this.getY() + this.CurrentImg.getHeight())) {

            System.out.println("Arrose");
            if (this.plantView != null) {

                Plant plant = this.plantView.getModel();

                if (plant.getStyDevEat().equals(sde)) {
                    usr.setScore(usr.getScore() + plant.getPrice(), usr.getPseudo());
                    usr.updateDico(this.plantView.getModel().getName(), true, usr.getPseudo());

                    if (plant.getGrowthState().equals(GrowthStateEnum.SPROUT)) {
                        plant.setGrowthState(GrowthStateEnum.MEDIUM);
                    } else {
                        if (plant.getGrowthState().equals(GrowthStateEnum.MEDIUM)) {
                            plant.setGrowthState(GrowthStateEnum.FINAL);
                        } else {
                            if (plant.getGrowthState().equals(GrowthStateEnum.FINAL)) {
                                if (usr.getInventory().containsKey(plant.getName())) {
                                    int nbPlant = usr.getInventory().get(plant.getName());
                                    usr.changeQtyStock(plant.getName(), nbPlant + 1, usr.getPseudo());
                                }
                                usr.setScore(usr.getScore() + 3 * plant.getNbXp(), usr.getPseudo());

                                this.plantView = null;
                            }
                        }
                    }
                } else {
                    plant.setLife(plant.getLife() - 1);
                    usr.updateDico(this.plantView.getModel().getName(), false, usr.getPseudo());
                    usr.setScore(usr.getScore() - 1, usr.getPseudo());
                    if (plant.getLife() <= 0) {
                        this.plantView = null;
                        usr.setScore(usr.getScore() - 3, usr.getPseudo());
                    }
                }

                if (this.plantView != null) {
                    System.out.println(this.plantView.getModel().getGrowthState());
                } else {
                    System.out.println("Plante recolté ou morte");
                }

                setPanelImg();
            }
        }
    }

    @Override
    public void mousePressed(String s, PlantVarietyEnum plant, double x, double y) {
        if ((x >= this.getX()) && (x <= this.getX() + this.CurrentImg.getWidth())
                && (y >= this.getY()) && (y <= this.getY() + this.CurrentImg.getHeight())) {
            System.out.println("Plante");
            if ((this.plantView == null) && (this.isUnlock)) {
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
                            if (plant.equals(PlantVarietyEnum.PATATE)) {
                                p = new Patate();
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
                setPanelImg();
            }
        }
    }

    /**
     * setPanelImg : Quand la plante disparait mettre le panneau null.
     */
    private void setPanelImg() {
        if (this.plantView == null) {
            this.FigureDeSyleImg = new Image(imgFigureDeStylePath + "/null" + imgType);
        } else {
            System.out.println(imgFigureDeStylePath + "/" + this.plantView.getModel().getName() + imgType);
            this.FigureDeSyleImg = new Image(imgFigureDeStylePath + "/" + this.plantView.getModel().getName().toString() + imgType);
        }
    }
}
