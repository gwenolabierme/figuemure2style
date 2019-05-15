package view;

import controller.Controller;
import figuemure2style.App;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FieldModel;
import model.plant.PlantVarietyEnum;
import model.user.DataPlantRatio;
import model.user.User;
import model.user.UserVegetableRatio;

/**
 *
 * Tableau de bord.
 */
public class DashbordView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private final String title = "FigueMûre2Style";
    
    private final List<String> listUnlock = Arrays.asList("carotte", "figue", "mure", "patatte", "pomme", "tomate");
    private final List<String> listFigureDeStyle = Arrays.asList("COMPARAISON", "PERIPHRASE", "PERSONNIFICATION", "HYPERBOLE", "CHIASME", "OXYMORE");
        
    private TableView<UserVegetableRatio> table = new TableView<UserVegetableRatio>();
        
    //private UserVegetableRatio uRatio = new UserVegetableRatio();
        
    

    /**
     * Constructeur sans paramètres.
     */
    public DashbordView() {
        Stage stage = new Stage();
        User u = new User();
        DashbordView dv = new DashbordView(stage, 
                App.windowsWidht, App.windowsHeight, u);
    }

    /**
     * Constructeur DashbordView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     * @param u utilisateur
     */
    public DashbordView(Stage stage, int w, int h, User u) {
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
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);

        // Logo
        Button logo = new Button();
        logo.setMinSize(60, 60);
        logo.getStyleClass().add("logoDashbordView");
        gridpane.add(logo, 1, 0);
        gridpane.setHalignment(logo, HPos.LEFT);

        // Titre
        Text title = new Text();
        title.setText("Tableau de bord");
        title.getStyleClass().add("title");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);

        // Récupération des ratios
        HashMap<PlantVarietyEnum, DataPlantRatio> mapRatio = u.getDataSucces();
        
        // Tableau
        ObservableList<UserVegetableRatio> data =
        FXCollections.observableArrayList(                    
            new UserVegetableRatio(listUnlock.get(0) + "Unlock", "The Button", listFigureDeStyle.get(0), String.valueOf(mapRatio.get(PlantVarietyEnum.CAROTTE).getRatio())),
            new UserVegetableRatio(listUnlock.get(1) + "Unlock", "The Button", listFigureDeStyle.get(1), String.valueOf(mapRatio.get(PlantVarietyEnum.FIGUE).getRatio())),
            new UserVegetableRatio(listUnlock.get(2) + "Unlock", "The Button", listFigureDeStyle.get(2), String.valueOf(mapRatio.get(PlantVarietyEnum.MURE).getRatio())),
            new UserVegetableRatio(listUnlock.get(3) + "Unlock", "The Button", listFigureDeStyle.get(3), String.valueOf(mapRatio.get(PlantVarietyEnum.PATATTE).getRatio())),
            new UserVegetableRatio(listUnlock.get(4) + "Unlock", "The Button", listFigureDeStyle.get(4), String.valueOf(mapRatio.get(PlantVarietyEnum.POMME).getRatio())),
            new UserVegetableRatio(listUnlock.get(5) + "Unlock", "The Button", listFigureDeStyle.get(5), String.valueOf(mapRatio.get(PlantVarietyEnum.TOMATE).getRatio()))
        );
        
        table.setEditable(true);
       
        TableColumn btnCol = new TableColumn("Buttons");
        btnCol.setMinWidth(100);
        
        btnCol.setCellValueFactory(new PropertyValueFactory<UserVegetableRatio, String>("btn"));

        TableColumn figureDeStyleCol = new TableColumn("Figure de style");
        figureDeStyleCol.setMinWidth(250);
        figureDeStyleCol.setCellValueFactory(new PropertyValueFactory<UserVegetableRatio, String>("figureDeStyle"));

        TableColumn ratioCol = new TableColumn("Ratio");
        ratioCol.setMinWidth(100);
        ratioCol.setCellValueFactory(new PropertyValueFactory<UserVegetableRatio, String>("ratio"));

        table.setItems(data);
        table.getColumns().addAll(btnCol, figureDeStyleCol, ratioCol);
        
        table.setMinWidth(450);
        gridpane.add(table, 1, 2);
        
        // Background
        gridpane.getStyleClass().add("other_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();
    }
}
