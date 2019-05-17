package view;

import controller.Controller;
import java.util.ArrayList;
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
    
    private final List<String> listNames = Arrays.asList("carrot", "fig", "blackberry", "patato", "apple", "tomato");
    private final List<String> listFigureDeStyle = Arrays.asList("COMPARAISON", "PERIPHRASE", "PERSONNIFICATION", "HYPERBOLE", "CHIASME", "OXYMORE");
        
    private TableView<UserVegetableRatio> table = new TableView<UserVegetableRatio>();

    /**
     * Constructeur sans paramètres.
     */
    public DashbordView() {
        Stage stage = new Stage();
        User u = new User();
        DashbordView dv = new DashbordView(stage, 800, 800, u);
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
        UserVegetableRatio carotteRatio = new UserVegetableRatio(listNames.get(0) + "UnlockTable", listFigureDeStyle.get(0), String.valueOf(mapRatio.get(PlantVarietyEnum.CAROTTE).getRatio()));
        UserVegetableRatio figueRatio = new UserVegetableRatio(listNames.get(1) + "UnlockTable", listFigureDeStyle.get(1), String.valueOf(mapRatio.get(PlantVarietyEnum.FIGUE).getRatio()));
        UserVegetableRatio mureRatio = new UserVegetableRatio(listNames.get(2) + "UnlockTable", listFigureDeStyle.get(2), String.valueOf(mapRatio.get(PlantVarietyEnum.MURE).getRatio()));
        UserVegetableRatio patateRatio = new UserVegetableRatio(listNames.get(3) + "UnlockTable", listFigureDeStyle.get(3), String.valueOf(mapRatio.get(PlantVarietyEnum.PATATE).getRatio()));
        UserVegetableRatio pommeRatio = new UserVegetableRatio(listNames.get(4) + "UnlockTable", listFigureDeStyle.get(4), String.valueOf(mapRatio.get(PlantVarietyEnum.POMME).getRatio()));
        UserVegetableRatio tomateRatio = new UserVegetableRatio(listNames.get(5) + "UnlockTable", listFigureDeStyle.get(5), String.valueOf(mapRatio.get(PlantVarietyEnum.TOMATE).getRatio()));
        
        ArrayList<UserVegetableRatio> listVegetableRatio = new ArrayList<UserVegetableRatio>();
        listVegetableRatio.add(carotteRatio);
        listVegetableRatio.add(figueRatio);
        listVegetableRatio.add(mureRatio);
        listVegetableRatio.add(patateRatio);
        listVegetableRatio.add(pommeRatio);
        listVegetableRatio.add(tomateRatio);
        
        Text titleVegetable = new Text("Fruits & légumes");
        titleVegetable.getStyleClass().add("titleTable");
        gridpane.add(titleVegetable, 0, 2);
        gridpane.setHalignment(titleVegetable, HPos.CENTER);
        
        Text titleFigureDeStyle = new Text("Figure de style");
        titleFigureDeStyle.getStyleClass().add("titleTable");
        gridpane.add(titleFigureDeStyle, 1, 2);
        gridpane.setHalignment(titleFigureDeStyle, HPos.CENTER);
        
        Text titleRatio = new Text("Ratio : nb victoire / nb défaite");
        titleRatio.getStyleClass().add("titleTable");
        gridpane.add(titleRatio, 2, 2);
        gridpane.setHalignment(titleRatio, HPos.CENTER);
        
        for (int i = 0 ; i < 6 ; i++) {
            // Image
            Button img = new Button();
            img.getStyleClass().add(listVegetableRatio.get(i).getImg());
            img.setMinSize(60, 60);
            gridpane.setHalignment(img, HPos.CENTER);
            gridpane.add(img, 0, 3 + i);
            
            // Figure de style
            Text figureDeStyle = new Text(listVegetableRatio.get(i).getFigureDeStyle());
            figureDeStyle.getStyleClass().add("");
            gridpane.setHalignment(figureDeStyle, HPos.CENTER);
            gridpane.add(figureDeStyle, 1, 3 + i);
            
            // Ratio
            Text ratio = new Text(listVegetableRatio.get(i).getRatio());
            ratio.getStyleClass().add("");
            gridpane.setHalignment(ratio, HPos.CENTER);
            gridpane.add(ratio, 2, 3 + i);
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
