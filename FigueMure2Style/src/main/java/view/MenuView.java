package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.FieldModel;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

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

        Text title = new Text();      
        title.setText("FigueMûre2Style");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);
        
        
        Button buttonNewGame = new Button("Créer une partie");
        buttonNewGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                NewGameView ngv = new NewGameView(stage, 600, 600);
            }
        });
        buttonNewGame.setMinSize(200, 50);
        gridpane.add(buttonNewGame, 1, 3);
        gridpane.setHalignment(buttonNewGame, HPos.CENTER);
        
        
        Button buttonGame = new Button("Charger une partie");
        buttonGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                LoadGameView lgv = new LoadGameView(stage, 600, 600);
            }
        });
        buttonGame.setMinSize(200, 50);
        gridpane.add(buttonGame, 1, 4);
        gridpane.setHalignment(buttonGame, HPos.CENTER);

        
        
        Button buttonCredis = new Button("Crédis");
        buttonCredis.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                CreditView cv = new CreditView(stage, 600, 600);
            }
        });
        buttonCredis.setMinSize(200, 50);
        gridpane.add(buttonCredis, 1, 5);
        gridpane.setHalignment(buttonCredis, HPos.CENTER);

        
        Button buttonExit = new Button("Quitter");
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        buttonExit.setMinSize(200, 50);
        gridpane.add(buttonExit, 1, 6);
        gridpane.setHalignment(buttonExit, HPos.CENTER);
        
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/assets/img/css/BackgroundSmallScreen.jpg",600,600,true,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
        gridpane.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(gridpane, w, h);
        stage.setScene(scene);
        stage.show();
    }
}
