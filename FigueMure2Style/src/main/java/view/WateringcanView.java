package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FieldModel;
import model.StoreModel;
import model.stylisticDevice.StylisticDevice;
import model.user.User;

/**
 *
 * @author gwenolabierme
 */
public class WateringcanView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;
    
    private String title = "FigueMûre2Style";
    
    private StylisticDevice fertilizer;
    
    /**
     * Constructeur sans paramètres.
     */
    public WateringcanView(StoreModel store, int indice) {
        Stage stage = new Stage();
        WateringcanView swv = new WateringcanView(stage, 800, 800, store, indice);
    }
    
    /**
     * Constructeur NewGameView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w     largeur de la fenêtre
     * @param h     hauteur de la fenêtre
     * @param store model du store
     * @param indice indice de l'arrosoire dans la boutique
     */
    public WateringcanView(final Stage stage, int w, int h, StoreModel store, int indice) {
        this.width = w;
        this.height = h;
        
        this.fertilizer = store.getFertilizerTab()[indice];
        
        // Nom de la fenetre
        stage.setTitle(title);
        
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
        
        ColumnConstraints column13 = new ColumnConstraints(), 
                column2 = new ColumnConstraints();
        column13.setPercentWidth(25);
        column2.setPercentWidth(50);
        // set the relative size of columns in the gridpane
        gridpane.getColumnConstraints().addAll(column13, column2, column13); 
        
        // Retour
        Button buttonReturn = new Button("←");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreWateringcanView
                StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, store.getUsr());
            }
        });
        buttonReturn.setMinSize(50, 50);
        buttonReturn.getStyleClass().add("panel_arrow");
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);
        
        // Titre
        Text title = new Text();
        title.setText("Figure de style");
        title.getStyleClass().add("title");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);
        
        // TODO
        // Figure de style
        Text figureDeStyle = new Text();
        figureDeStyle.setText("Figure de style");
        //figureDeStyle.getStyleClass().add("title");
        gridpane.add(figureDeStyle, 1, 1);
        gridpane.setHalignment(figureDeStyle, HPos.CENTER);
        
        
        // Bouton : Sélectionner
        Button buttonSelect = new Button("Sélectionner");
        buttonSelect.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // TODO
                // Fenetre : NewGameView
                //NewGameView ngv = new NewGameView(stage, 600, 600);
            }
        });
        buttonSelect.setMinSize(200, 50);
        //buttonSelect.getStyleClass().add("panel");
        gridpane.add(buttonSelect, 1, 2);
        gridpane.setHalignment(buttonSelect, HPos.CENTER);
        
        // Background
        //gridpane.getStyleClass().add("small_background");
        
        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css"); 
        stage.setScene(scene);
        stage.show();
    }
}
