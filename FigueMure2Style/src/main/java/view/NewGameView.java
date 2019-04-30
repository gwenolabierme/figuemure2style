package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import model.ModelException;
import model.user.User;

/**
 * Nouvelle partie.
 */
public class NewGameView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;
    
    private String title = "FigueMûre2Style";
    
    /**
     * Constructeur sans paramètres.
     */
    public NewGameView() {
        Stage stage = new Stage();
        NewGameView ngv = new NewGameView(stage, 600, 600);
    }
    
    /**
     * Constructeur NewGameView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w     largeur de la fenêtre
     * @param h     hauteur de la fenêtre
     */
    public NewGameView(final Stage stage, int w, int h) {
        this.width = w;
        this.height = h;
        
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

        // Bouton : Retour
        Button buttonReturn = new Button("←");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                MenuView mv = new MenuView(stage, w, h);
            }
        });
        buttonReturn.setMinSize(50, 50);
        buttonReturn.getStyleClass().add("panel_arrow");
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);
        
        // Titre
        Text title = new Text();
        title.setText("Créer une partie");
        title.getStyleClass().add("title");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);
        
        // Pseudo
        Label pseudoLabel = new Label();
        pseudoLabel.setText("Pseudo :");
        pseudoLabel.getStyleClass().add("label");
        gridpane.add(pseudoLabel, 0, 1);
        gridpane.setHalignment(pseudoLabel, HPos.RIGHT);
        
        TextField pseudo = new TextField();
        pseudo.getStyleClass().add("textfield");
        gridpane.add(pseudo, 1, 1);
        gridpane.setHalignment(pseudo, HPos.LEFT);
        
        // Genre
        RadioButton farmer1 = new RadioButton("Fermier");
        RadioButton farmer2 = new RadioButton("Fermière");

        ToggleGroup radioGroupFarmer = new ToggleGroup();
        farmer1.setToggleGroup(radioGroupFarmer);
        farmer2.setToggleGroup(radioGroupFarmer);
        
        farmer1.getStyleClass().add("gender");
        farmer2.getStyleClass().add("gender");
        gridpane.add(farmer1, 0, 2);
        gridpane.add(farmer2, 1, 2);
        gridpane.setHalignment(farmer1, HPos.RIGHT);
        gridpane.setHalignment(farmer2, HPos.CENTER);
        
        // Bouton : Validation
        Button buttonValidation = new Button("Valider");
        buttonValidation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String newPseudo = pseudo.getText();
                User u = new User(newPseudo);
                if(!(u.isUserExist(newPseudo))) {
                    String newGender;
                    if (farmer1.isSelected()) {
                        newGender = "fermier";
                    }
                    else {
                        newGender = "fermiere";
                    }
                    try {
                        u = new User(newPseudo, newGender);

                        // Fenetre : LoadGameView
                        LoadGameView lgv = new LoadGameView(stage, 600, 600);
                    } catch (ModelException ex) {
                        Logger.getLogger(NewGameView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        buttonValidation.setMinSize(200, 50);
        buttonValidation.getStyleClass().add("panel");
        gridpane.add(buttonValidation, 1, 3);
        gridpane.setHalignment(buttonValidation, HPos.CENTER);
        
        // Background
        gridpane.getStyleClass().add("small_background");
        
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css"); 
        stage.setScene(scene);
        stage.show();
    }
}
