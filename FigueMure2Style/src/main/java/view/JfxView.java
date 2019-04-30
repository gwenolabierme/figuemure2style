package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import model.ModelException;
import model.user.User;

/**
 * view for jfx.
 *
 * @author jeremy
 */
public class JfxView implements View {
    /**
     * Groupe de vue à la racine de la fenêtre.
     */
    private final Group root;
    /**
     * Fenêtre à gérer.
     */
    private final Stage stage;
    /**
     * Vue à afficher dans la fenêtre.
     */
    private CanvasView view;

    /**
     * Constructeur de JfxView.
     *
     * @param title Titre de la fenêtre à créer
     * @param stage Fenêtre à gérer
     */
    public JfxView(String title, Stage stage) {
        this.stage = stage;

        // Nom de la fenetre
        this.stage.setTitle(title);
        
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        //gridpane.setPadding(new Insets(20, 20, 20, 20, 20));

        ColumnConstraints col1 = new ColumnConstraints(); 
        col1.setPercentWidth(20);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(20);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(20);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(20);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPercentWidth(20);
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(20);
        // set the relative size of columns in the gridpane
        gridpane.getColumnConstraints().addAll(col1,col2,col3, col4, col5);
        gridpane.getRowConstraints().addAll(row1,row2,row3,row4,row5);
        
        // Terres
        this.root = new Group();
        gridpane.add(this.root, 0, 0);
        gridpane.setHalignment(this.root, HPos.LEFT);
        gridpane.setValignment(this.root, VPos.TOP);
        
        
        // Bouton : Boutique
        Button buttonValidation = new Button("Boutique");
        buttonValidation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //TODO
                // Fenetre : LoadGameView
                //LoadGameView lgv = new LoadGameView(stage, 600, 600);
                    

            }
        });
        buttonValidation.setMinSize(50, 50);
        //buttonValidation.getStyleClass().add("panel");
        gridpane.add(buttonValidation, 4, 0);
        gridpane.setHalignment(buttonValidation, HPos.LEFT);
        gridpane.setValignment(this.root, VPos.TOP);
        
        // Background
        //gridpane.getStyleClass().add("small_background");
        
        // Scene
        Scene scene = new Scene(gridpane, 800, 800);
        scene.getStylesheets().add("/assets/css/Background.css"); 
        stage.setScene(scene);
        stage.show();
        
        
        
        

    }

    /**
     * Défini la vue à afficher dans la fenêtre.
     *
     * @param view Vue à attribuer dans la fenêtre
     */
    public void setView(CanvasView view) {
        this.view = view;
        this.view.setRoot(this.root);
        this.root.getChildren().add(this.view);
    }

    /**
     * Affiche la fenêtre.
     */
    public void show() {
        this.stage.show();
    }

    /**
     * Met à jour la fenêtre et sa vue.
     */
    public void display() {
        this.view.display();
    }
}
