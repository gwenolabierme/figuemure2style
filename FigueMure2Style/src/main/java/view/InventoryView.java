
package view;

import controller.Controller;
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
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.Mure;
import model.plant.Patate;
import model.plant.Plant;
import model.plant.Pomme;
import model.plant.Tomate;
import model.user.UserDidacticiel;

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
    
    // Listes de données : Fuits et légumes
    private final Plant carotte = new Carotte();
    private final Plant figue = new Figue();
    private final Plant mure = new Mure();
    private final Plant patate = new Patate();
    private final Plant pomme = new Pomme();
    private final Plant tomate = new Tomate();

    private final List<String> listNames = Arrays.asList("carrot", "fig", "blackberry", "patato", "apple", "tomato");
    private final List<String> listFigureDeStyle = Arrays.asList(carotte.getStyDevEat().toString(), figue.getStyDevEat().toString(), mure.getStyDevEat().toString(), patate.getStyDevEat().toString(), pomme.getStyDevEat().toString(), tomate.getStyDevEat().toString());
    private final List<String> listUnlock = Arrays.asList(carotte.getName().toString(), figue.getName().toString(), mure.getName().toString(), patate.getName().toString(), pomme.getName().toString(), tomate.getName().toString());
    private final List<String> listPrice = Arrays.asList(Integer.toString(carotte.getPrice()), Integer.toString(figue.getPrice()), Integer.toString(mure.getPrice()), Integer.toString(patate.getPrice()), Integer.toString(pomme.getPrice()), Integer.toString(tomate.getPrice()));
    
    /**
     * Constructeur sans paramètres.
     */
    public InventoryView() {
        Stage stage = new Stage();
        User u = new User();
        InventoryView iv = new InventoryView(stage, 800, 800, u);
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
        logo.getStyleClass().add("logoInventoryView");
        gridpane.add(logo, 2, 0);
        gridpane.setHalignment(logo, HPos.CENTER);

        // Titre
        Text title = new Text();
        title.setText("Inventaire");
        title.getStyleClass().add("title");
        gridpane.add(title, 3, 0);
        gridpane.setHalignment(title, HPos.CENTER);

        // Listes de données : Inventaire
        List<Integer> listInventory = Arrays.asList(u.getInventory().get(PlantVarietyEnum.CAROTTE), u.getInventory().get(PlantVarietyEnum.FIGUE), u.getInventory().get(PlantVarietyEnum.MURE), u.getInventory().get(PlantVarietyEnum.PATATE), u.getInventory().get(PlantVarietyEnum.POMME), u.getInventory().get(PlantVarietyEnum.TOMATE));
        Text carotteInvenventory = new Text(listInventory.get(0).toString());
        Text figueInvenventory = new Text(listInventory.get(1).toString());
        Text mureInvenventory = new Text(listInventory.get(2).toString());
        Text patateInvenventory = new Text(listInventory.get(3).toString());
        Text pommeInvenventory = new Text(listInventory.get(4).toString());
        Text tomateInvenventory = new Text(listInventory.get(5).toString());
        List<Text> listLabel = Arrays.asList(carotteInvenventory, figueInvenventory, mureInvenventory, patateInvenventory, pommeInvenventory, tomateInvenventory);
        // Vente
        Text sale = new Text();
        sale.setText(listFigureDeStyle.get(0).toUpperCase());
        gridpane.add(sale, 4, 4);
        gridpane.setHalignment(sale, HPos.CENTER);

        // Boutons : Fuits et légumes
        for (int i = 0; i < 6; ++i) {
            Button vegeteble = new Button();
            vegeteble.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String infoVegetable = vegeteble.getStyleClass().toString();

                    if (infoVegetable.contains(listNames.get(0))) {  
                        sale.setText(listFigureDeStyle.get(0).toUpperCase());
                    } else if (infoVegetable.contains(listNames.get(1))) {
                        sale.setText(listFigureDeStyle.get(1).toUpperCase());
                    } else if (infoVegetable.contains(listNames.get(2))) {
                        sale.setText(listFigureDeStyle.get(2).toUpperCase());
                    } else if (infoVegetable.contains(listNames.get(3))) {
                        sale.setText(listFigureDeStyle.get(3).toUpperCase());
                    } else if (infoVegetable.contains(listNames.get(4))) {
                        sale.setText(listFigureDeStyle.get(4).toUpperCase());
                    } else if (infoVegetable.contains(listNames.get(5))) {
                        sale.setText(listFigureDeStyle.get(5).toUpperCase());
                    }
                }
            });
            vegeteble.setMinSize(60, 60);
            
            // Légumes débloqués
            if (u.getPlantUnlock().toString().contains(listUnlock.get(i))) {
                vegeteble.getStyleClass().add(listNames.get(i) + "Unlock");
                vegeteble.setDisable(false);
            }
            else {
                vegeteble.getStyleClass().add(listNames.get(i) + "Lock");
                vegeteble.setDisable(true);
            }
 
            Text titleVegeteble = new Text();
            titleVegeteble.setText(listFigureDeStyle.get(i).toUpperCase());

            Text inventoryVegeteble = listLabel.get(i);

            if (i < 6) {
                gridpane.add(vegeteble, i, 1);
                gridpane.add(titleVegeteble, i, 1);
                gridpane.add(inventoryVegeteble, i, 1);
            } else {
                gridpane.add(vegeteble, i - 6, 3);
                gridpane.add(titleVegeteble, i - 6, 3);
                gridpane.add(inventoryVegeteble, i - 6, 3);
            }
            gridpane.setHalignment(vegeteble, HPos.CENTER);
            gridpane.setHalignment(titleVegeteble, HPos.CENTER);
            gridpane.setValignment(titleVegeteble, VPos.TOP);
            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);   
        }
        
        // Bouton : Acheter
        Button buttonBuy = new Button("Vendre");
        buttonBuy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String vegetableSale = sale.getText();
                int score = u.getScore();
                int nbXp = 0;
                int nbVegetable = 0;
                double money = u.getMoney();
                int priceVegetable = 0;
                
                Text inventoryVegeteble = new Text();
                switch(vegetableSale) {
                    case "COMPARAISON" :   
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(0))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(0);
                            nbXp += carotte.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Met à jour l'argent 
                            priceVegetable += Integer.parseInt(listPrice.get(0));

                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.CAROTTE, u.getPseudo());
                            listInventory.set(0, u.getInventory().get(PlantVarietyEnum.CAROTTE));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(0).toString());
                            gridpane.getChildren().remove(listLabel.get(0));
                            gridpane.add(inventoryVegeteble, 0, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break; 
                    case "PERIPHRASE" :
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(1))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(1);
                            nbXp += figue.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.FIGUE, u.getPseudo());
                            listInventory.set(1, u.getInventory().get(PlantVarietyEnum.FIGUE));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(1).toString());
                            gridpane.getChildren().remove(listLabel.get(1));
                            gridpane.add(inventoryVegeteble, 1, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break; 
                    case "PERSONNIFICATION" :
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(2))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(2);
                            nbXp += mure.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.MURE, u.getPseudo());
                            listInventory.set(2, u.getInventory().get(PlantVarietyEnum.MURE));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(2).toString());
                            gridpane.getChildren().remove(listLabel.get(2));
                            gridpane.add(inventoryVegeteble, 2, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break;
                    case "HYPERBOLE" :
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(3))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(3);
                            nbXp += mure.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.PATATE, u.getPseudo());
                            listInventory.set(3, u.getInventory().get(PlantVarietyEnum.PATATE));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(3).toString());
                            gridpane.getChildren().remove(listLabel.get(3));
                            gridpane.add(inventoryVegeteble, 3, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break;
                    case "CHIASME" :
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(4))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(4);
                            nbXp += pomme.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.POMME, u.getPseudo());
                            listInventory.set(4, u.getInventory().get(PlantVarietyEnum.POMME));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(4).toString());
                            gridpane.getChildren().remove(listLabel.get(4));
                            gridpane.add(inventoryVegeteble, 4, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break;
                    case "OXYMORE" :
                        if (u.getPlantUnlock().toString().contains(listUnlock.get(5))) {
                            // Met à jour le stock
                            nbVegetable += listInventory.get(5);
                            nbXp += tomate.getNbXp() * nbVegetable;
                            score += nbXp;
                            
                            // Vide les stock du légume
                            u.emptyQtyStock(PlantVarietyEnum.TOMATE, u.getPseudo());
                            listInventory.set(5, u.getInventory().get(PlantVarietyEnum.TOMATE));
                            
                            // Affiche le nouveau inventaire
                            inventoryVegeteble.setText(listInventory.get(5).toString());
                            gridpane.getChildren().remove(listLabel.get(5));
                            gridpane.add(inventoryVegeteble, 5, 1);
                            gridpane.setHalignment(inventoryVegeteble, HPos.CENTER);
                            gridpane.setValignment(inventoryVegeteble, VPos.BOTTOM);
                        }
                        break;    
                    default : 
                       break;
                }
                // Met à jour l'argent 
                money += priceVegetable * nbVegetable;
                u.setMoney(money, u.getPseudo());
                
                // Infos utilisateur
                UserDidacticiel didacticiel = new UserDidacticiel("DashbordView", u.getGender());
                String newScore = Integer.toString(score); 
                String newMoney = Double.toString(money);
                Button d = didacticiel.message("Nouveau score : " + newScore + "XP \nArgent restant : " + newMoney + "€");
                gridpane.add(d, 3, 5);
                gridpane.setHalignment(d, HPos.CENTER);
                gridpane.setValignment(d, VPos.BOTTOM);
            }
        });
        buttonBuy.setMinSize(200, 50);
        buttonBuy.getStyleClass().add("panel");
        gridpane.add(buttonBuy, 2, 4);
        gridpane.setHalignment(buttonBuy, HPos.CENTER);
        
        // Didacticiel
        if (u.isDidacticiel()) {
            UserDidacticiel didacticiel = new UserDidacticiel("DashbordView", u.getGender());
            Button d = didacticiel.message("Ici vous pourrez consulter votre\n inventaire et y vendre vos récoltes.");
            gridpane.add(d, 3, 5);
            gridpane.setHalignment(d, HPos.CENTER);
            gridpane.setValignment(d, VPos.BOTTOM);
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
