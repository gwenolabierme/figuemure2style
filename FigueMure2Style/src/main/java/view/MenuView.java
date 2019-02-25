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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import model.FieldModel;

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
        
        Button buttonPlay = new Button("Jouer");
        buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stageGame = new Stage();
                JfxView gameView = new JfxView(title.getText(), stageGame);

                FieldModel fieldModel = new FieldModel();

                FieldView fieldView =
                        new FieldView(fieldModel, 600,600);

                Controller controller = Controller.getControler();
                fieldView.setControler(controller);
                controller.addUpdateView(gameView);
                controller.setModel(fieldModel);
                gameView.setView(fieldView);

                controller.startTimer();

                stage.close();
            }
        });
        buttonPlay.setMinSize(200, 50);
        gridpane.add(buttonPlay, 1, 3);
        gridpane.setHalignment(buttonPlay, HPos.CENTER);


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

        Scene scene = new Scene(gridpane, w, h);
        stage.setScene(scene);
        stage.show();
    }
}
