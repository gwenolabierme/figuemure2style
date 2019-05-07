package view;

import controller.Controller;
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
import model.user.User;

/**
 *
 * @author gwenolabierme
 */
public class StoreWateringcanView {
    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;
    
    private String title = "FigueMûre2Style";
    
    private static StoreModel model;
    
    /**
     * Constructeur simple.
     * @param user joueur
     */
    public StoreWateringcanView(User user) {
        Stage stage = new Stage();
        StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, user);
    }
    
    /**
     * Constructeur NewGameView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w     largeur de la fenêtre
     * @param h     hauteur de la fenêtre
     * @param user joueur
     */
    public StoreWateringcanView(final Stage stage, int w, int h, User user) {
        int iWattCan;
        this.width = w;
        this.height = h;
        this.model = new StoreModel(user);

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
        gridpane.getColumnConstraints().addAll(col1,col2,col3,col4,col5,col6);
        gridpane.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6);
        
        
        // Retour
        Button buttonReturn = new Button("←");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : stageGame
                JfxView gameView = new JfxView(title, stage, user);

                FieldModel fieldModel = new FieldModel();
                FieldView fieldView =
                        new FieldView(fieldModel, 800,800);

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
        buttonVegetable.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreVegetableView TODO
                //StoreVegetableView nvv = new StoreVegetableView(stage, 800, 800);
            }
        });
        buttonVegetable.setMinSize(100, 100);
        //buttonVegetable.getStyleClass().add("panel");
        gridpane.add(buttonVegetable, 0, 1);
        gridpane.setHalignment(buttonVegetable, HPos.CENTER);
        
        // Bouton : Figure de style
        Button buttonWateringcan = new Button("Figure de style");
        buttonWateringcan.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // Fenetre : StoreWateringcanView
                StoreWateringcanView swv = new StoreWateringcanView(stage, 800, 800, user);
            }
        });
        buttonWateringcan.setMinSize(100, 100);
        //buttonVegetable.getStyleClass().add("panel");
        gridpane.add(buttonWateringcan, 0, 3);
        gridpane.setHalignment(buttonWateringcan, HPos.CENTER);
        
        model.updateFertilizer();
        
        iWattCan = 0;
        // Boutons : Arrosoires
        for (int i = 0 ; i < 5 ; ++i) {
            Button figureDeStyle = new Button();   
            figureDeStyle.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e) {
                    // Fenetre : Figure de style
                    WateringcanView wv = new WateringcanView(stage, 800, 800, model, iWattCan);
                }
            });
            figureDeStyle.setMinSize(60, 60);
            figureDeStyle.getStyleClass().add("logoWateringcan");
            gridpane.add(figureDeStyle, i + 1, 1);
            gridpane.setHalignment(figureDeStyle, HPos.CENTER);
            
            ++iWattCan;
            if (iWattCan > user.getPlantUnlock().size()*2) {
                iWattCan = 0;
            }
        }
        for (int i = 0 ; i < 5 ; ++i) {
            Button figureDeStyle = new Button(); 
            figureDeStyle.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e) {
                    // Fenetre : Figure de style
                    WateringcanView wv = new WateringcanView(stage, 800, 800, model, iWattCan);
                }
            });
            figureDeStyle.setMinSize(60, 60);
            figureDeStyle.getStyleClass().add("logoWateringcan");
            gridpane.add(figureDeStyle,i + 1, 3);
            gridpane.setHalignment(figureDeStyle, HPos.CENTER);
            
            ++iWattCan;
            if (iWattCan > user.getPlantUnlock().size()*2) {
                iWattCan = 0;
            }
        }
        
        
        // Background
        //gridpane.getStyleClass().add("small_background");
        
        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css"); 
        stage.setScene(scene);
        stage.show();
        
    }
}
