package view;

import controller.Controller;
import figuemure2style.App;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.FieldModel;
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
    private final FieldModel fm;
    /**
     * Controller à qui on va rapporter les évènements.
     */
    private Controller controller;
    /**
     * Images pacelles.
     */
    private ParcelView[][] parcelView;
    /**
     * Images plantes.
     */
    private PlantView[][] plantView;
    /**
     * Arrosoir
     */
    private StylisticDeviceEnum sdeCan;

    /**
     * Constructeur de FieldView.
     *
     * @param fieldModel Modèle de données
     * @param width Largeur du canvas
     * @param height Hauteur du canvas
     */
    public FieldView(FieldModel fieldModel, int width, int height) {
        super(width, height);

        this.fm = fieldModel;

        this.width = width;
        this.height = height;

        this.sdeCan = null;
        /*
         * Permet de capturer le focus et donc les evenements clavier et
         * souris
         */
        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();

        parcelView = new ParcelView[App.gardenSize][App.gardenSize];
        plantView = new PlantView[App.gardenSize][App.gardenSize];

        for (int i = 0; i < App.gardenSize; ++i) {
            for (int j = 0; j < App.gardenSize; ++j) {
                if (App.freePlotBegin * i + j < fm.getNbFreePlot()) {
                    this.parcelView[i][j] = new ParcelView(gc, true);
                    this.parcelView[i][j].setX((int) ((j) * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getWidth() / 2));
                    this.parcelView[i][j].setY((int) (i * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getHeight() / 2));
                } else {
                    this.parcelView[i][j] = new ParcelView(gc, false);
                    this.parcelView[i][j].setX((int) ((j) * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getWidth() / 2)); // on centre la parcelle sur sa colonne
                    this.parcelView[i][j].setY((int) (i * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getHeight() / 2));
                }
                if (fm.getPlant(i, j) == null) {
                    this.plantView[i][j] = null;
                } else {
                    this.plantView[i][j] = new PlantView(gc, fm.getPlant(i, j));
                    this.plantView[i][j].setX((int) ((j) * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getWidth() / 2
                            - this.plantView[i][j].getCurrentImg().getWidth() / 2)); // on centre le légume sur la parcelle
                    this.plantView[i][j].setY((int) (i * (640 / (App.gardenSize))
                            + this.parcelView[i][j].getCurrentImg().getHeight() / 2
                            - this.plantView[i][j].getCurrentImg().getHeight() / 2));
                }
            }
        }

        /*
         * Event Listener de la souris quand un bouton est pressée on rapporte
         * l'évènement au contrôleur
         */
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.mousePressed(event.getButton().toString(), sdeCan);
                sdeCan = null;
            }
        });
    }
        
    public FieldView(FieldModel fieldModel, int width, int height, StylisticDeviceEnum sde) {
        this(fieldModel, width, height);
        
        //TODO : traiter sde
        // changer pointeur souris
        // effet si clique
        
        this.sdeCan = sde;
        //Image img = new Image("/assets/css/img/wateringcan.png");
        //scene.setCursor(new ImageCursor(image));
    }

    /**
     * Affichage le terrain et les characters.
     */
    public void display() {
        // Affichage le jardin
        for (int i = 0; i < App.gardenSize; ++i) {
            for (int j = 0; j < App.gardenSize; ++j) {
                this.parcelView[i][j].display();
                if (this.plantView[i][j] != null) {
                    this.plantView[i][j].display();
                }
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
                this.controller.addSubscriber(this.plantView[i][j]);
            }
        }
    }
}
