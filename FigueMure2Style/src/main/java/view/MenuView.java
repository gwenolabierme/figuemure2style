package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;

/**
 * Menu Principal qui apparait au lancement.
 */
public class MenuView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;
    
    private String title = "FigueMûre2Style";
    
    /**
     * Constructeur sans paramètres.
     */
    public MenuView() {
        Stage stage = new Stage();
        MenuView mv = new MenuView(stage, 600, 600);
    }

    /**
     * Constructeur MenuView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w     largeur de la fenêtre
     * @param h     hauteur de la fenêtre
     */
    public MenuView(final Stage stage, int w, int h) {

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

        // Logo
        Button logo = new Button();      
        logo.setMinSize(350, 145);
        logo.getStyleClass().add("logo");
        gridpane.add(logo, 1, 0);
        gridpane.setHalignment(logo, HPos.CENTER);
        
        // Bouton : Créer une partie
        Button buttonNewGame = new Button("Créer une partie");
        buttonNewGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : NewGameView
                NewGameView ngv = new NewGameView(stage, 600, 600);
            }
        });
        buttonNewGame.setMinSize(200, 50);
        buttonNewGame.getStyleClass().add("panel");
        gridpane.add(buttonNewGame, 1, 2);
        gridpane.setHalignment(buttonNewGame, HPos.CENTER);
        
        // Bouton : Charger une partie
        Button buttonGame = new Button("Charger une partie");
        buttonGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : LoadGameView
                LoadGameView lgv = new LoadGameView(stage, 600, 600);
            }
        });
        buttonGame.setMinSize(200, 50);
        buttonGame.getStyleClass().add("panel");
        gridpane.add(buttonGame, 1, 3);
        gridpane.setHalignment(buttonGame, HPos.CENTER);

        // Bouton : Crédits
        Button buttonCredis = new Button("Crédits");
        buttonCredis.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                CreditView cv = new CreditView(stage, 600, 600);
            }
        });
        buttonCredis.setMinSize(200, 50);
        buttonCredis.getStyleClass().add("panel");
        gridpane.add(buttonCredis, 1, 4);
        gridpane.setHalignment(buttonCredis, HPos.CENTER);

        // Bouton : Quitter
        Button buttonExit = new Button("Quitter");
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        buttonExit.setMinSize(200, 50);
        buttonExit.getStyleClass().add("panel");
        gridpane.add(buttonExit, 1, 5);
        gridpane.setHalignment(buttonExit, HPos.CENTER);  
        
        // Background
        gridpane.getStyleClass().add("small_background"); 
        
        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css"); 
        stage.setScene(scene);
        stage.show();
    }
}
