package view;

import figuemure2style.App;
import java.util.HashSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FieldModel;
import model.StoreModel;
import model.stylisticDevice.StylisticDevice;
import model.user.User;

/**
 *
 * Boutique : Arrosoirs.
 */
public class StoreWateringcanView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private final String title = "FigueMûre2Style";

    private static StoreModel model;
    private Stage stage;

    /**
     * Constructeur simple.
     *
     * @param u utilisateur
     */
    public StoreWateringcanView(User u) {
        Stage stage = new Stage();
        //HashSet<StylisticDevice> fertilizerList = null;
        //StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, u, fertilizerList);
        this.model = new StoreModel(u);
        StoreWateringcanView swv = new StoreWateringcanView(stage, 
                App.windowsWidht, App.windowsHeight, u);
    }

    /**
     * Constructeur StoreWateringcanView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     */
    public StoreWateringcanView(final Stage stage, int w, int h, User u) {
        this.stage = stage;
        this.model = new StoreModel(u);

        GridPane gridpane = new GridPane();

        fenetreInit(gridpane, u);

        forFertilizers(gridpane, u, false);

        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Constructeur StoreWateringcanView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     * @param fertilizerList liste de citation
     */
    public StoreWateringcanView(final Stage stage, int w, int h, User u, HashSet<StylisticDevice> fertilizerList) {
        this.width = w;
        this.height = h;
        //HashSet<StylisticDevice> fertilizerList = null;
        this.model = new StoreModel(u, fertilizerList);
        this.stage = stage;

        GridPane gridpane = new GridPane();

        fenetreInit(gridpane, u);

        forFertilizers(gridpane, u, true);

        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Initialise la fenetre.
     *
     * @param gridpane gridpane de cette view
     * @param user utilisateur
     */
    private void fenetreInit(GridPane gridpane, User u) {

        gridpane.setHgap(10);
        gridpane.setVgap(10);

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
        ColumnConstraints col6 = new ColumnConstraints();
        col6.setPercentWidth(20);
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(20);
        // set the relative size of columns in the gridpane
        gridpane.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);
        gridpane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);

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
        gridpane.add(buttonReturn, 5, 0);
        gridpane.setHalignment(buttonReturn, HPos.CENTER);

        // Logo
        Button logo = new Button();
        logo.setMinSize(60, 60);
        logo.getStyleClass().add("logoShopView");
        gridpane.add(logo, 2, 0);
        gridpane.setHalignment(logo, HPos.CENTER);

        // Titre
        Text title = new Text();
        title.setText("Boutique");
        title.getStyleClass().add("title");
        gridpane.add(title, 3, 0);
        gridpane.setHalignment(title, HPos.CENTER);

        // Bouton : Vegetable
        Button buttonVegetable = new Button("Fruits et \nlégumes");
        buttonVegetable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreVegetableView
                StoreVegetableView svv = new StoreVegetableView(stage, App.windowsWidht, App.windowsHeight, u);
            }
        });
        buttonVegetable.setMinSize(110, 110);
        buttonVegetable.getStyleClass().add("panelStore");
        gridpane.add(buttonVegetable, 0, 1);
        gridpane.setHalignment(buttonVegetable, HPos.CENTER);

        // Bouton : Figure de style
        Button buttonWateringcan = new Button("Figure de\n    style");
        buttonWateringcan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreWateringcanView
                StoreWateringcanView swv = new StoreWateringcanView(stage, 
                        App.windowsWidht, App.windowsHeight, u);
            }
        });
        buttonWateringcan.setMinSize(110, 110);
        buttonWateringcan.getStyleClass().add("panelStore");
        gridpane.add(buttonWateringcan, 0, 3);
        gridpane.setHalignment(buttonWateringcan, HPos.CENTER);
    }

    /**
     * Gère les étapes liées au choix des citations pour les arrosoirs.
     *
     * @param gridpane gridpane de cette view
     * @param u utilisateur
     * @param isWithFertilizerList True si c'est le constructeur avec une
     * FertilizerList en param
     */
    private void forFertilizers(GridPane gridpane, User u, boolean isWithFertilizerList) {
        if (!isWithFertilizerList) {
            model.updateFertilizer();
        }
        /*System.err.println("fert : ");
        for(StylisticDevice fert : model.getFertilizerTab()) {
            System.out.println(fert.getSentence());
        }*/

        // Boutons : Arrosoires
        int iLigne = 1;
        int iCol = 0;
        for (int i = 0; i < 10; ++i) {
            if (iCol >= 5) {
                iLigne = 2;
                iCol = 0;
            }

            final int iWattCan = i % (u.getPlantUnlock().size() * 2);

            Button figureDeStyle = new Button();
            figureDeStyle.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    // Fenetre : Figure de style
                    WateringcanView wv = new WateringcanView(stage, 
                            App.windowsWidht, App.windowsHeight, model, iWattCan, u);
                }
            });
            figureDeStyle.setMinSize(60, 60);
            figureDeStyle.getStyleClass().add("logoWateringcan");
            gridpane.add(figureDeStyle, iCol + 1, iLigne);
            gridpane.setHalignment(figureDeStyle, HPos.CENTER);

            ++iCol;
        }
    }
}
