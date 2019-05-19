package view;

import controller.Controller;
import figuemure2style.App;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.Mure;
import model.plant.Patate;
import model.plant.Plant;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;
import model.user.DataPlantRatio;
import model.user.User;
import static view.JfxView.stage;

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
    private final List<String> listPrice = Arrays.asList(Integer.toString(carotte.getPrice()), Integer.toString(figue.getPrice()), Integer.toString(mure.getPrice()), Integer.toString(patate.getPrice()), Integer.toString(pomme.getPrice()), Integer.toString(tomate.getPrice()));
    private final List<String> listUnlock = Arrays.asList(carotte.getName().toString(), figue.getName().toString(), mure.getName().toString(), patate.getName().toString(), pomme.getName().toString(), tomate.getName().toString());
    private final List<String> listNamesFr = Arrays.asList(PlantVarietyEnum.CAROTTE.toString(), PlantVarietyEnum.FIGUE.toString(), PlantVarietyEnum.MURE.toString(), PlantVarietyEnum.PATATE.toString(), PlantVarietyEnum.POMME.toString(), PlantVarietyEnum.TOMATE.toString());
    private final List<String> listNeed = Arrays.asList("0", "2", "3", "4", "4", "5");
    
    /**
     * Constructeur sans paramètres.
     */
    public StoreVegetableView() {
        Stage stage = new Stage();
        User u = new User();
        StoreVegetableView swv = new StoreVegetableView(stage,
                App.windowsWidht, App.windowsHeight, u);
    }

    /**
     * Constructeur StoreVegetableView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utlisateur
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
                StoreVegetableView svv = new StoreVegetableView(stage,
                        App.windowsWidht, App.windowsHeight, u);
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
                StoreWateringcanView swv = new StoreWateringcanView(stage,
                        App.windowsWidht, App.windowsHeight, u);
            }
        });
        buttonWateringcan.setMinSize(110, 110);
        buttonWateringcan.getStyleClass().add("panelStore");
        gridpane.add(buttonWateringcan, 0, 3);
        gridpane.setHalignment(buttonWateringcan, HPos.CENTER);

        // Liste de données : Leçons de figures de style
        List<String> listlesson = new ArrayList();
        listlesson.add("Leçon - COMPARAISON \n Il y a un comparé (celui que l'on compare à quelque chose), un comparant (quelque chose)\n et un outil grammatical de comparaison (comme, tel que...).");
        listlesson.add("Leçon - PERIPHRASE \n Remplacement du mot par une expression explicative, fonction poétique et métaphorique\n ou atténuation.");
        listlesson.add("Leçon - PERSONNIFICATION \n Elle attribue des caractéristiques humaines à un objet, un animal, etc.");
        listlesson.add("Leçon - HYPERBOLE \n Elle exagère l'expression d'une idée pour la mettre en relief.\n Utilisée dans l'ironie, la caricature.");
        listlesson.add("Leçon - CHIASME \n Parallélisme et inversion, souligne l'union ou l'opposition.");
        listlesson.add("Leçon - OXYMORE \n Deux mots opposés l'un à côté de l'autre.");

        // Leçon
        Text lesson = new Text();
        lesson.setText(listlesson.get(0));
        lesson.getStyleClass().add("lecon");
        gridpane.add(lesson, 1, 5);
        gridpane.setHalignment(lesson, HPos.LEFT);
        gridpane.setValignment(lesson, VPos.TOP);
        
        // Liste de données : Ratio
        HashMap<PlantVarietyEnum, DataPlantRatio> mapRatio = u.getDataSucces();
        List<String> listRatios = Arrays.asList(String.valueOf(mapRatio.get(PlantVarietyEnum.CAROTTE).getRatio()), String.valueOf(mapRatio.get(PlantVarietyEnum.FIGUE).getRatio()), String.valueOf(mapRatio.get(PlantVarietyEnum.MURE).getRatio()), String.valueOf(mapRatio.get(PlantVarietyEnum.PATATE).getRatio()), String.valueOf(mapRatio.get(PlantVarietyEnum.POMME).getRatio()), String.valueOf(mapRatio.get(PlantVarietyEnum.TOMATE).getRatio()));

        // Achat
        Text purchase = new Text();
        purchase.setText(listFigureDeStyle.get(0).toUpperCase());
        gridpane.add(purchase, 4, 4);
        gridpane.setHalignment(purchase, HPos.CENTER);

        // Boutons : Fuits et légumes
        for (int i = 0; i < 6; ++i) {
            Button vegeteble = new Button();
            vegeteble.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String infoVegetable = vegeteble.getStyleClass().toString();

                    if (infoVegetable.contains("carrot")) {
                        lesson.setText(listlesson.get(0));
                        purchase.setText(listFigureDeStyle.get(0).toUpperCase());
                    } else if (infoVegetable.contains("fig")) {
                        lesson.setText(listlesson.get(1));
                        purchase.setText(listFigureDeStyle.get(1).toUpperCase());
                    } else if (infoVegetable.contains("blackberry")) {
                        lesson.setText(listlesson.get(2));
                        purchase.setText(listFigureDeStyle.get(2).toUpperCase());
                    } else if (infoVegetable.contains("patato")) {
                        lesson.setText(listlesson.get(3));
                        purchase.setText(listFigureDeStyle.get(3).toUpperCase());
                    } else if (infoVegetable.contains("apple")) {
                        lesson.setText(listlesson.get(4));
                        purchase.setText(listFigureDeStyle.get(4).toUpperCase());
                    } else if (infoVegetable.contains("tomato")) {
                        lesson.setText(listlesson.get(5));
                        purchase.setText(listFigureDeStyle.get(5).toUpperCase());
                    }
                }
            });
            vegeteble.setMinSize(60, 60);
            
            String price = listPrice.get(i);
            String ratio = listRatios.get(i);
            double finalPrice = Double.parseDouble(price) * Double.parseDouble(ratio);
            Text priceVegeteble = new Text();
            // Légumes débloqués
            if (u.getPlantUnlock().toString().contains(listUnlock.get(i))) {
                vegeteble.getStyleClass().add(listNames.get(i) + "Unlock");
                priceVegeteble.setText(String.valueOf(finalPrice) + "€");
            } else {
                vegeteble.getStyleClass().add(listNames.get(i) + "Lock");
                priceVegeteble.setText(listNeed.get(i) + " " + listNamesFr.get(i-1)+ "s");
            }

            Text titleVegeteble = new Text();
            titleVegeteble.setText(listFigureDeStyle.get(i).toUpperCase());


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
        
        // Bouton : Acheter
        Button buttonBuy = new Button("Acheter");
        buttonBuy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String vegetableBuy = purchase.getText();
                double money = u.getMoney();
                int priceVegetable = 0;
                double ratio = 0.0;

                PlantVarietyEnum pve;
                FieldModel fieldModel;
                FieldView fv;
                
                PlantVarietyEnum plantNeedToUnlock = null;
                int nbNeedToUnlock = 0;
                
                switch (vegetableBuy) {
                    case "COMPARAISON":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(0));
                        ratio += Double.parseDouble(listRatios.get(0));

                        // Plante le légume
                        pve = PlantVarietyEnum.CAROTTE;
                        break;
                    case "PERIPHRASE":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(1));
                        ratio += Double.parseDouble(listRatios.get(1));

                        // Plante le légume
                        pve = PlantVarietyEnum.FIGUE;
                        
                        //To unlock
                        plantNeedToUnlock = PlantVarietyEnum.CAROTTE;
                        nbNeedToUnlock = 2;
                        break;
                    case "PERSONNIFICATION":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(2));
                        ratio += Double.parseDouble(listRatios.get(2));

                        // Plante le légume
                        pve = PlantVarietyEnum.MURE;
                        
                        //To unlock
                        plantNeedToUnlock = PlantVarietyEnum.FIGUE;
                        nbNeedToUnlock = 3;
                        break;
                    case "HYPERBOLE":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(3));
                        ratio += Double.parseDouble(listRatios.get(3));

                        // Plante le légume
                        pve = PlantVarietyEnum.PATATE;
                        
                        //To unlock
                        plantNeedToUnlock = PlantVarietyEnum.MURE;
                        nbNeedToUnlock = 4;
                        break;
                    case "CHIASME":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(4));
                        ratio += Double.parseDouble(listRatios.get(4));

                        // Plante le légume
                        pve = PlantVarietyEnum.POMME;
                        
                        //To unlock
                        plantNeedToUnlock = PlantVarietyEnum.PATATE;
                        nbNeedToUnlock = 4;
                        break;
                    case "OXYMORE":
                        // Met à jour l'argent 
                        priceVegetable += Integer.parseInt(listPrice.get(5));
                        ratio += Double.parseDouble(listRatios.get(5));

                        // Plante le légume
                        pve = PlantVarietyEnum.TOMATE;
                        
                        //To unlock
                        plantNeedToUnlock = PlantVarietyEnum.POMME;
                        nbNeedToUnlock = 5;
                        break;
                    default:
                        priceVegetable += Integer.parseInt(listPrice.get(0));
                        ratio += Double.parseDouble(listRatios.get(0));
                        
                        pve = PlantVarietyEnum.CAROTTE;
                        break;
                }

                if (u.getPlantUnlock().contains(pve)) {
                    
                    // Met à jour l'argent 
                    money -= priceVegetable * ratio;
                    u.setMoney(money, u.getPseudo());

                    // Plante le légume
                    JfxView gameView = new JfxView(title.getText(), stage, u);

                    //fieldModel = new FieldModel();
                    //fv = new FieldView(fieldModel, App.windowsWidht, App.windowsHeight, pve);

                    //Controller controller = Controller.getControler();
                    //fv.setControler(controller);
                    //controller.addUpdateView(gameView);
                    //controller.setModel(fieldModel);
                    LoadGameView.fieldView.setPveBought(pve);
                    gameView.setView(LoadGameView.fieldView);

                    //controller.startTimer();
                } else {
                    // Verifie l'inventaire et enleve les plantes nécessaire pour débloquer
                    if (JfxView.user.getInventory().get(plantNeedToUnlock) >= nbNeedToUnlock) {
                        System.out.println("UNLOCK " + pve);
                        JfxView.user.changeQtyStock(plantNeedToUnlock, 
                                JfxView.user.getInventory().get(plantNeedToUnlock) 
                                        - nbNeedToUnlock, u.getPseudo());
                        JfxView.user.addPlantUnlock(pve, u.getPseudo());
                    }
                    
                    StoreVegetableView svv = new StoreVegetableView(stage, App.windowsWidht, App.windowsHeight, u);
                }
            }
        });
        buttonBuy.setMinSize(200, 50);
        buttonBuy.getStyleClass().add("panel");
        gridpane.add(buttonBuy, 2, 4);
        gridpane.setHalignment(buttonBuy, HPos.CENTER);

        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();

    }
}
