
package view;

import controller.Controller;
import figuemure2style.App;
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
import model.plant.PlantVarietyEnum;
import model.user.User;

/**
 *
 * Inventaire.
 */
public class InventoryView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private final String title = "FigueMûre2Style";

    /**
     * Constructeur sans paramètres.
     */
    public InventoryView() {
        Stage stage = new Stage();
        User u = new User();
        InventoryView iv = new InventoryView(stage, 
                App.windowsWidht, App.windowsHeight, u);
    }

    /**
     * Constructeur InventoryView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     */
    public InventoryView(final Stage stage, int w, int h, User u) {
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
                FieldView fieldView = new FieldView(fieldModel, 
                        App.windowsWidht, App.windowsHeight);

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
        logo.getStyleClass().add("logoInventoryView");
        gridpane.add(logo, 2, 0);
        gridpane.setHalignment(logo, HPos.CENTER);

        // Titre
        Text title = new Text();
        title.setText("Inventaire");
        title.getStyleClass().add("title");
        gridpane.add(title, 3, 0);
        gridpane.setHalignment(title, HPos.CENTER);


        // Listes de données : Fuits et légumes
        List<String> listNames = Arrays.asList("carrot", "fig", "blackberry", "patato", "apple", "tomato");
        List<String> listFigureDeStyle = Arrays.asList("COMPARAISON", "PERIPHRASE", "PERSONNIFICATION", "HYPERBOLE", "CHIASME", "OXYMORE");
        List<String> listUnlock = Arrays.asList("carotte", "figue", "mure", "patatte", "pomme", "tomate");
        List<Integer> listInventory = Arrays.asList(u.getInventory().get(PlantVarietyEnum.CAROTTE), u.getInventory().get(PlantVarietyEnum.FIGUE), u.getInventory().get(PlantVarietyEnum.MURE), u.getInventory().get(PlantVarietyEnum.PATATTE), u.getInventory().get(PlantVarietyEnum.POMME), u.getInventory().get(PlantVarietyEnum.TOMATE));
                
        // Vente
        Text sale = new Text();
        sale.setText(listFigureDeStyle.get(0));
        gridpane.add(sale, 4, 4);
        gridpane.setHalignment(sale, HPos.CENTER);

        // Boutons : Fuits et légumes
        for (int i = 0; i < 6; ++i) {
            Button vegeteble = new Button();
            vegeteble.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String infoVegetable = vegeteble.getStyleClass().toString();

                    if (!(infoVegetable.indexOf("carrot") == -1)) {
                        
                        sale.setText(listFigureDeStyle.get(0));
                    } else if (!(infoVegetable.indexOf("fig") == -1)) {
                       
                        sale.setText(listFigureDeStyle.get(1));
                    } else if (!(infoVegetable.indexOf("blackberry") == -1)) {
                       
                        sale.setText(listFigureDeStyle.get(2));
                    } else if (!(infoVegetable.indexOf("patato") == -1)) {
               
                        sale.setText(listFigureDeStyle.get(3));
                    } else if (!(infoVegetable.indexOf("apple") == -1)) {
                  
                        sale.setText(listFigureDeStyle.get(4));
                    } else if (!(infoVegetable.indexOf("tomato") == -1)) {
                    
                        sale.setText(listFigureDeStyle.get(5));
                    }
                }
            });
            vegeteble.setMinSize(60, 60);
            
            // Légumes débloqués
            if (u.getPlantUnlock().toString().indexOf(listUnlock.get(i)) != -1) {
                vegeteble.getStyleClass().add(listNames.get(i) + "Unlock");
            }
            else {
                vegeteble.getStyleClass().add(listNames.get(i) + "Lock");
            }
 
            Text titleVegeteble = new Text();
            titleVegeteble.setText(listFigureDeStyle.get(i));

            Text priceVegeteble = new Text();
            priceVegeteble.setText(listInventory.get(i).toString());

            if (i < 6) {
                gridpane.add(vegeteble, i, 1);
                gridpane.add(titleVegeteble, i, 1);
                gridpane.add(priceVegeteble, i, 1);
            } else {
                gridpane.add(vegeteble, i - 6, 3);
                gridpane.add(titleVegeteble, i - 6, 3);
                gridpane.add(priceVegeteble, i - 6, 3);
            }
            gridpane.setHalignment(vegeteble, HPos.CENTER);
            gridpane.setHalignment(titleVegeteble, HPos.CENTER);
            gridpane.setValignment(titleVegeteble, VPos.TOP);
            gridpane.setHalignment(priceVegeteble, HPos.CENTER);
            gridpane.setValignment(priceVegeteble, VPos.BOTTOM);
            
            // Bouton : Acheter
            Button buttonBuy = new Button("Vendre");
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
