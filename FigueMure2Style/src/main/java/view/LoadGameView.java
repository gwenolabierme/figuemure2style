package view;

import controller.Controller;
import figuemure2style.App;
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
import model.FieldModel;
import model.user.User;

/**
 * Charger une partie.
 */
public class LoadGameView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private final String title = "FigueMûre2Style";
    
    public static FieldView fieldView;

    /**
     * Constructeur sans paramètres.
     */
    public LoadGameView() {
        Stage stage = new Stage();
        LoadGameView lgv = new LoadGameView(stage, 600, 600);
    }

    /**
     * Constructeur LoadGameView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     */
    public LoadGameView(final Stage stage, int w, int h) {
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

        // Retour
        Button buttonReturn = new Button("←");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
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
        title.setText("Charger une partie");
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

        // Bouton : Validation
        Button buttonValidation = new Button("Valider");
        buttonValidation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Erreur utilisateur
                Button error = new Button();

                String newPseudo = pseudo.getText();

                if (newPseudo.equals("")) {
                    // Error utilisateur
                    error = new Button(" Remplissez le champs pseudo.");
                    error.setMinSize(500, 100);
                    error.getStyleClass().add("error_menu");
                    gridpane.add(error, 1, 3);
                    gridpane.setHalignment(error, HPos.CENTER);
                } else {
                    User u = new User(newPseudo);

                    if (u.isUserExist(newPseudo)) {
                        u.getUser(newPseudo);

                        // Fenetre : stageGame
                        JfxView gameView = new JfxView(title.getText(), stage, u);

                        FieldModel fieldModel = new FieldModel();
                        fieldView = new FieldView(fieldModel, 
                                App.windowsWidht, App.windowsHeight);
                        
                        Controller controller = Controller.getControler();
                        fieldView.setControler(controller);
                        controller.addUpdateView(gameView);
                        controller.setModel(fieldModel);
                        gameView.setView(fieldView);

                        controller.startTimer();
                    } else {
                        // Error utilisateur
                        error = new Button(" Cet utilisateur n'existe pas.\n Créez un compte.");
                        error.setMinSize(500, 100);
                        error.getStyleClass().add("error_menu");
                        gridpane.add(error, 1, 3);
                        gridpane.setHalignment(error, HPos.CENTER);

                    }
                }
            }
        });
        buttonValidation.setMinSize(200, 50);
        buttonValidation.getStyleClass().add("panel");
        gridpane.add(buttonValidation, 1, 2);
        gridpane.setHalignment(buttonValidation, HPos.CENTER);

        // Background
        gridpane.getStyleClass().add("small_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();
    }
}
