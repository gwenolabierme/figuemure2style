
package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.FieldModel;

/**
 *
 * Charger une partie
 */
public class LoadGameView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;
    
    private String title = "FigueMûre2Style";
    
    public LoadGameView() {
        Stage stage = new Stage();
        LoadGameView lgv = new LoadGameView(stage, 600, 600);
    }
    
    public LoadGameView(final Stage stage, int w, int h) {
        this.width = w;
        this.height = h;
        
        // Nom de la fenetre
        stage.setTitle(title);
        //stage.initStyle();
        
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
        
        
        Button buttonReturn = new Button("<-");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                MenuView mv = new MenuView(stage, w, h);
            }
        });
        buttonReturn.setMinSize(200, 50);
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);
        
        
        Text title = new Text();
        title.setText("Charger une partie");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);
        
        
        Label pseudoLabel = new Label();
        pseudoLabel.setText("Pseudo :");
        gridpane.add(pseudoLabel, 0, 2);
        
        TextField pseudo = new TextField();
        gridpane.add(pseudo, 1, 2);
        
        
        Button buttonValidation = new Button("Valider");
        buttonValidation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stageGame = new Stage();
                JfxView gameView = new JfxView(title.getText(), stageGame);

                FieldModel fieldModel = new FieldModel();
                FieldView fieldView =
                        new FieldView(fieldModel, 800,800);

                Controller controller = Controller.getControler();
                fieldView.setControler(controller);
                controller.addUpdateView(gameView);
                controller.setModel(fieldModel);
                gameView.setView(fieldView);

                controller.startTimer();

                stage.close();  
            }
        });
        gridpane.add(buttonValidation, 1, 3);
        gridpane.setHalignment(buttonValidation, HPos.CENTER);
        
        
        Scene scene = new Scene(gridpane, w, h);
        stage.setScene(scene);
        stage.show();
    }
    
}
