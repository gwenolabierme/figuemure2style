package view;

import controller.Controller;
import figuemure2style.App;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.FieldModel;
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
     * Constructeur de FieldView.
     *
     * @param fieldModel Modèle de données
     * @param width      Largeur du canvas
     * @param height     Hauteur du canvas
     */
    public FieldView(FieldModel fieldModel, int width, int height) {
        super(width, height);

        this.fm = fieldModel;

        this.width = width;
        this.height = height;

        /*
         * Permet de capturer le focus et donc les evenements clavier et
         * souris
         */
        this.setFocusTraversable(true);

        gc = this.getGraphicsContext2D();
        
        for(int i = 0; i < App.gardenSize; ++i) {
            for(int j = 0; j < App.gardenSize; ++j) {
                if (App.freePlotBegin*i+j < fm.getNbFreePlot()) {
                    this.parcelView[i][j] = new ParcelView(gc, true);
                } else { 
                    this.parcelView[i][j] = new ParcelView(gc, false);
                }
                this.plantView[i][j] = new PlantView(gc, fm.getPlant(i, j));
            }
        }
        
        /*
         * Event Listener de la souris quand un bouton est pressée on rapporte
         * l'évènement au contrôleur
         */
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.mousePressed(event.getButton().toString());
            }
        });

        /*
         * Event Listener du clavier quand une touche est pressée on rapporte
         * l'évènement au contrôleur
         */
        /*this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                controller.keyPressed(e.getCode().getName());
            }
        });*/
    }

    /**
     * Affichage le terrain et les characters.
     */
    public void display() {

        // On nettoie le canvas à chaque frame
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, width, height);

        // Affichage le jardin
        for(int i = 0; i < App.gardenSize; ++i) {
            for(int j = 0; j < App.gardenSize; ++j) {
                this.parcelView[i][j].display();
                this.plantView[i][j].display();
            }
        }
    }

    /**
     * Défini le contrôleur qui est en charge de cette vue (à qui on va
     * rapporter les évènements).
     * @param controler Controler à attribuer à cette vue
     */
    public void setControler(Controller controler) {
        this.controller = controler;
        
        //TODO : Fonction ci-dessous pour chaque parcelle
        
        /*
        for (CharacterView view : this.characters) {
            this.controller.addSubscriber(view);
        }*/
    }
}
