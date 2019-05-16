package view;

import controller.Controller;
import figuemure2style.App;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.FieldModel;
import model.plant.PlantVarietyEnum;
import model.stylisticDevice.StylisticDeviceEnum;
import view.plant.PlantView;

/**
 * view for the field.
 *
 * @author jeremy
 */
public class FieldView extends CanvasView {

    /**
     * Contexte graphique dans lequel on va afficher les éléments.
     */
    private final GraphicsContext gc;
    /**
     * Largeur de la fenêtre.
     */
    private final int width;
    /**
     * Hauteur de la fenêtre.
     */
    private final int height;
    /**
     * Modèle du champ de cours.
     */
    public final FieldModel fm;
    /**
     * Controller à qui on va rapporter les évènements.
     */
    private Controller controller;
    /**
     * Images pacelles.
     */
    public static ParcelView[][] parcelView;
    /**
     * Arrosoir
     */
    private StylisticDeviceEnum sdeCan;
    /**
     * Plante en cours d'achat
     */
    private PlantVarietyEnum pveBought;
    
    private boolean init = false;

    /**
     * Constructeur de FieldView.
     *
     * @param fieldModel Modèle de données
     * @param width Largeur du canvas
     * @param height Hauteur du canvas
     */
    public FieldView(FieldModel fieldModel, int width, int height, boolean init) {
        super(width, height);

        this.fm = fieldModel;

        this.width = width;
        this.height = height;

        this.sdeCan = null;
        this.init = init;
        /*
         * Permet de capturer le focus et donc les evenements clavier et
         * souris
         */
        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();
        
        if (!init) {
            System.out.println("init");
            parcelView = new ParcelView[App.gardenSize][App.gardenSize];
            for (int i = 0; i < App.gardenSize; ++i) {
                for (int j = 0; j < App.gardenSize; ++j) {
                    if (App.freePlotBegin * i + j < fm.getNbFreePlot()) {
                        PlantView pv;
                        if (fm.getPlant(i, j) == null) {
                            pv = null;
                        } else {
                            pv = new PlantView(gc, fm.getPlant(i, j));
                        }

                        parcelView[i][j] = new ParcelView(gc, true, pv);
                        parcelView[i][j].setX((int) ((j) * (640 / (App.gardenSize))
                                + parcelView[i][j].getCurrentImg().getWidth() / 2));
                        parcelView[i][j].setY((int) (i * (640 / (App.gardenSize))
                                + parcelView[i][j].getCurrentImg().getHeight() / 2));
                    } else {
                        parcelView[i][j] = new ParcelView(gc, false, null);
                        parcelView[i][j].setX((int) ((j) * (640 / (App.gardenSize))
                                + parcelView[i][j].getCurrentImg().getWidth() / 2)); // on centre la parcelle sur sa colonne
                        parcelView[i][j].setY((int) (i * (640 / (App.gardenSize))
                                + parcelView[i][j].getCurrentImg().getHeight() / 2));
                    }
                }
            }
            init = true;
        }

        /*
         * Event Listener de la souris quand un bouton est pressée on rapporte
         * l'évèwateringcannement au contrôleur
         */
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (sdeCan != null) {
                    controller.mousePressed(event.getButton().toString(), sdeCan);
                    sdeCan = null;  
                }
                if (pveBought != null) {
                    controller.mousePressed(event.getButton().toString(), pveBought);
                    pveBought = null;
                }
            }
        });
    }
    
    public FieldView(FieldModel fieldModel, int width, int height) {
        this(fieldModel, width, height, false);
    }
    
    public FieldView(FieldModel fieldModel, int width, int height, StylisticDeviceEnum sde) {
        this(fieldModel, width, height, true);
        
        //TODO : traiter sde
        // changer pointeur souris
        
        this.sdeCan = sde;
        //Image img = new Image("/assets/css/img/wateringcan.png");
        //scene.setCursor(new ImageCursor(image));
    }
    
    public FieldView(FieldModel fieldModel, int width, int height, PlantVarietyEnum pve) {
        this(fieldModel, width, height, true);
        
        //TODO : traiter sde
        // changer pointeur souris
        // effet si clique
        
        this.pveBought = pve;
        //Image img = new Image("/assets/css/img/_.png");
        //scene.setCursor(new ImageCursor(image));
    }

    /**
     * Affichage le terrain et les characters.
     */
    public void display() {
        // Affichage le jardin
        for (int i = 0; i < App.gardenSize; ++i) {
            for (int j = 0; j < App.gardenSize; ++j) {
                parcelView[i][j].display();
            }
        }
    }

    /**
     * Défini le contrôleur qui est en charge de cette vue (à qui on va
     * rapporter les évènements).
     *
     * @param controler Controler à attribuer à cette vue
     */
    public void setControler(Controller controler) {
        this.controller = controler;

        for (int i = 0; i < App.gardenSize; ++i) {
            for (int j = 0; j < App.gardenSize; ++j) {
                this.controller.addSubscriber(this.parcelView[i][j]);
                //this.controller.addSubscriber(this.plantView[i][j]);
            }
        }
    }

    public void setSdeCan(StylisticDeviceEnum sdeCan) {
        this.sdeCan = sdeCan;
    }

    public void setPveBought(PlantVarietyEnum pveBought) {
        this.pveBought = pveBought;
    }
    
    
}
