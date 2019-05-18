package view;

import controller.Controller;
import figuemure2style.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FieldModel;
import model.user.User;

/**
 *
 * Paramètres.
 */
public class SettingsView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private final String title = "FigueMûre2Style";

    /**
     * Constructeur sans paramètres.
     */
    public SettingsView() {
        Stage stage = new Stage();
        User u = new User();
        SettingsView sv = new SettingsView(stage, 
                App.windowsWidht, App.windowsHeight, u);
    }

    /**
     * Constructeur SettingsView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     */
    public SettingsView(Stage stage, int w, int h, User u) {
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
                // Fenetre : stageGame
                JfxView gameView = new JfxView(title, stage, u);

                FieldModel fieldModel = new FieldModel();
                //fv = new FieldView(fieldModel, App.windowsWidht, App.windowsHeight);
                
                //Controller controller = Controller.getControler();
                //fv.setControler(controller);
                //controller.addUpdateView(gameView);
                //controller.setModel(fieldModel);
                gameView.setView(LoadGameView.fieldView);

                //controller.startTimer();
            }
        });
        buttonReturn.setMinSize(50, 50);
        buttonReturn.getStyleClass().add("panel_arrow");
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);

        // Logo
        Button logo = new Button();
        logo.setMinSize(60, 60);
        logo.getStyleClass().add("logoSettingsView");
        gridpane.add(logo, 1, 0);
        gridpane.setHalignment(logo, HPos.LEFT);

        // Titre
        Text title = new Text();
        title.setText("Paramètres");
        title.getStyleClass().add("title");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);

        // Son
        CheckBox checkBoxSound = new CheckBox();
        checkBoxSound.getStyleClass().add("text_label");
        gridpane.add(checkBoxSound, 0, 3);
        gridpane.setHalignment(checkBoxSound, HPos.CENTER);

        Text textSound = new Text();
        textSound.setText("Désactiver le son");
        textSound.getStyleClass().add("text_label");
        gridpane.add(textSound, 1, 3);
        gridpane.setHalignment(textSound, HPos.LEFT);

        // Genre
        RadioButton farmer1 = new RadioButton("Fermier");
        RadioButton farmer2 = new RadioButton("Fermière");

        ToggleGroup radioGroupFarmer = new ToggleGroup();
        farmer1.setToggleGroup(radioGroupFarmer);
        farmer2.setToggleGroup(radioGroupFarmer);

        farmer1.getStyleClass().add("gender");
        farmer2.getStyleClass().add("gender");
        gridpane.add(farmer1, 0, 4);
        gridpane.add(farmer2, 1, 4);
        gridpane.setHalignment(farmer1, HPos.RIGHT);
        gridpane.setHalignment(farmer2, HPos.CENTER);

        // Bouton : Valider
        Button buttonValidation = new Button("Valider");
        buttonValidation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (checkBoxSound.isSelected()) {
                    // TODO
                    // Désactiver la musique
                }
                String newGender;
                String pseudo = u.getPseudo();
                if (farmer1.isSelected()) {
                    newGender = "fermier";
                    u.setGender(newGender, pseudo);
                } else if (farmer2.isSelected()) {
                    newGender = "fermiere";
                    u.setGender(newGender, pseudo);
                }
            }
        });
        buttonValidation.setMinSize(200, 50);
        buttonValidation.getStyleClass().add("panel");
        gridpane.add(buttonValidation, 1, 6);
        gridpane.setHalignment(buttonValidation, HPos.CENTER);

        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();
    }
}
