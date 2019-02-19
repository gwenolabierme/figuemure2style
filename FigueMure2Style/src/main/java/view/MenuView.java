package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Menu Principal qui apparait au lancement.
 */
public class MenuView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

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
        stage.setTitle("FigueMûre2Style");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Button buttonSolo = new Button("Jouer");
        buttonSolo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //MenuLocal ms = new MenuLocal();
                stage.close();
            }
        });
        buttonSolo.setMinSize(200, 50);
        grid.add(buttonSolo, 1, 2);


        Button buttonExit = new Button("Quitter");
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        buttonExit.setMinSize(200, 50);
        grid.add(buttonExit, 1, 5);

        Scene scene = new Scene(grid, 270, 320);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Constructeur sans paramètres.
     */
    public MenuView() {
        Stage stage = new Stage();
        MenuView mvp = new MenuView(stage, 600, 600);
    }

    /**
     * Démarre le jeu.
     */
    /*
    public void startGame() {
       
        Stage stage1 = new Stage();
        JfxView gameView = new JfxView("Poneymon 2.0 - Jeu", stage1);
        FieldModel fieldModel = new FieldModel(cl, App.playerNumber, 
                "test", ModeEnum.LOCAL, null);
        FieldView fieldView =
                new FieldView(fieldModel, this.width, this.height);

        Controler controler = Controler.getControler();

        fieldView.setControler(controler);
        controler.addUpdateView(gameView);
        controler.setModel(fieldModel);
        gameView.setView(fieldView);

        Stage stage2 = new Stage();
        JfxView scoreView = new JfxView("Poneymon 2.0 - Score", stage2);
        scoreView.setView(new ScoreView(fieldModel, this.width, this.height));
        controler.addView(scoreView);

        controler.startTimer();

    }*/
}
