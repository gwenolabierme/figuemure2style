package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import model.FieldModel;
import model.user.User;

/**
 *
 * Boutique : Fruits et légumes.
 */
public class StoreVegetableView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private String title = "FigueMûre2Style";

    /**
     * Constructeur sans paramètres.
     */
    public StoreVegetableView() {
        Stage stage = new Stage();
        User u = new User();
        StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, u);
    }

    /**
     * Constructeur NewGameView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     */
    public StoreVegetableView(final Stage stage, int w, int h, User u) {
        this.width = w;
        this.height = h;

        // Nom de la fenetre
        stage.setTitle(title);

        GridPane gridpane = new GridPane();
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
                FieldView fieldView = new FieldView(fieldModel, 800, 800);

                Controller controller = Controller.getControler();
                fieldView.setControler(controller);
                controller.addUpdateView(gameView);
                controller.setModel(fieldModel);
                gameView.setView(fieldView);

                controller.startTimer();
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
        Button buttonVegetable = new Button("Fruits et légumes");
        buttonVegetable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreVegetableView
                StoreVegetableView svv = new StoreVegetableView(stage, 800, 800, u);
            }
        });
        buttonVegetable.setMinSize(100, 100);
        //buttonVegetable.getStyleClass().add("panel");
        gridpane.add(buttonVegetable, 0, 1);
        gridpane.setHalignment(buttonVegetable, HPos.CENTER);

        // Bouton : Figure de style
        Button buttonWateringcan = new Button("Figure de style");
        buttonWateringcan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreWateringcanView
                StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, u);
            }
        });
        buttonWateringcan.setMinSize(100, 100);
        //buttonVegetable.getStyleClass().add("panel");
        gridpane.add(buttonWateringcan, 0, 3);
        gridpane.setHalignment(buttonWateringcan, HPos.CENTER);

        // Listes de données : Fuits et légumes
        List<String> listNames = Arrays.asList("carrot", "fig", "blackberry", "patato", "apple", "tomato");
        List<String> listFigureDeStyle = Arrays.asList("COMPARAISON", "PERIPHRASE", "PERSONNIFICATION", "HYPERBOLE", "CHIASME", "OXYMORE");
        List<String> listPrice = Arrays.asList("1", "1", "1", "1", "3", "3");
        List<String> listlesson = new ArrayList();
        listlesson.add("Leçon - COMPARAISON \n Il y a un comparé (celui que l'on compare à quelque chose), un comparant (quelque chose)\n et un outil grammatical de comparaison (comme, tel que...).");
        listlesson.add("Leçon - PERIPHRASE \n Remplacement du mot par une expression explicative, fonction poétique et métaphorique\n ou atténuation.");
        listlesson.add("Leçon - PERSONNIFICATION \n Elle attribue des caractéristiques humaines à un objet, un animal, etc.");
        listlesson.add("Leçon - HYPERBOLE \n Elle exagère l'expression d'une idée pour la mettre en relief. Utilisée dans l'ironie, la caricature.");
        listlesson.add("Leçon - CHIASME \n Parallélisme et inversion, souligne l'union ou l'opposition.");
        listlesson.add("Leçon - OXYMORE \n Deux mots opposés l'un à côté de l'autre.");

        // Leçon
        Text lesson = new Text();
        lesson.setText(listlesson.get(0));
        gridpane.add(lesson, 1, 5);
        gridpane.setHalignment(lesson, HPos.LEFT);
        gridpane.setValignment(lesson, VPos.TOP);

        // Achat
        Text purchase = new Text();
        purchase.setText(listFigureDeStyle.get(0));
        gridpane.add(purchase, 4, 4);
        gridpane.setHalignment(purchase, HPos.CENTER);

        // Bouton : Acheter
        Button buttonBuy = new Button("Acheter");
        buttonBuy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // TODO
            }
        });
        buttonBuy.setMinSize(200, 50);
        buttonBuy.getStyleClass().add("panel");
        gridpane.add(buttonBuy, 2, 4);
        gridpane.setHalignment(buttonBuy, HPos.CENTER);

        // Boutons : Fuits et légumes
        for (int i = 0; i < 6; ++i) {
            Button vegeteble = new Button();
            vegeteble.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String infoVegetable = vegeteble.getStyleClass().toString();

                    if (!(infoVegetable.indexOf("carrot") == -1)) {
                        lesson.setText(listlesson.get(0));
                        purchase.setText(listFigureDeStyle.get(0));
                    } else if (!(infoVegetable.indexOf("fig") == -1)) {
                        lesson.setText(listlesson.get(1));
                        purchase.setText(listFigureDeStyle.get(1));
                    } else if (!(infoVegetable.indexOf("blackberry") == -1)) {
                        lesson.setText(listlesson.get(2));
                        purchase.setText(listFigureDeStyle.get(2));
                    } else if (!(infoVegetable.indexOf("patato") == -1)) {
                        lesson.setText(listlesson.get(3));
                        purchase.setText(listFigureDeStyle.get(3));
                    } else if (!(infoVegetable.indexOf("apple") == -1)) {
                        lesson.setText(listlesson.get(4));
                        purchase.setText(listFigureDeStyle.get(4));
                    } else if (!(infoVegetable.indexOf("tomato") == -1)) {
                        lesson.setText(listlesson.get(5));
                        purchase.setText(listFigureDeStyle.get(5));
                    }
                }
            });
            vegeteble.setMinSize(60, 60);
            vegeteble.getStyleClass().add(listNames.get(i) + "Unlock"); //TODO

            Text titleVegeteble = new Text();
            titleVegeteble.setText(listFigureDeStyle.get(i));

            Text priceVegeteble = new Text();
            priceVegeteble.setText(listPrice.get(i) + "XP");

            if (i < 5) {
                gridpane.add(vegeteble, i + 1, 1);
                gridpane.add(titleVegeteble, i + 1, 1);
                gridpane.add(priceVegeteble, i + 1, 1);
            } else {
                gridpane.add(vegeteble, i - 5 + 1, 3);
                gridpane.add(titleVegeteble, i - 5 + 1, 3);
                gridpane.add(priceVegeteble, i - 5 + 1, 3);
            }
            gridpane.setHalignment(vegeteble, HPos.CENTER);
            gridpane.setHalignment(titleVegeteble, HPos.CENTER);
            gridpane.setValignment(titleVegeteble, VPos.TOP);
            gridpane.setHalignment(priceVegeteble, HPos.CENTER);
            gridpane.setValignment(priceVegeteble, VPos.BOTTOM);
        }

        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();

    }
}
