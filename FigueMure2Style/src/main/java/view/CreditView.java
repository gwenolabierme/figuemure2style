package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Crédits.
 */
public class CreditView {

    /**
     * Longueur et largeur de la fenêtre.
     */
    private int width;
    private int height;

    private String title = "FigueMûre2Style";

    /**
     * Constructeur sans paramètres.
     */
    public CreditView() {
        Stage stage = new Stage();
        CreditView cv = new CreditView(stage, 600, 600);
    }

    /**
     * Constructeur CreditView.
     *
     * @param stage Relatif à Canvas pour la construction de la fenêtre
     * @param w largeur de la fenêtre
     * @param h hauteur de la fenêtre
     */
    public CreditView(final Stage stage, int w, int h) {
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

        // Bouton : Retour
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
        title.setText("Crédis");
        title.getStyleClass().add("title");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);

        // Texte
        Text developpeur = new Text();
        developpeur.setText("Concepteur & Développeurs");
        developpeur.getStyleClass().add("text_credits");
        gridpane.add(developpeur, 1, 1);
        gridpane.setHalignment(developpeur, HPos.CENTER);

        Text noms = new Text();
        noms.setText("Gwénola Biermé & Jérémy Duval");
        noms.getStyleClass().add("text_credits");
        gridpane.add(noms, 1, 3);
        gridpane.setHalignment(noms, HPos.CENTER);

        Text fac1 = new Text();
        fac1.setText("Réalisé dans le cadre d'un cours de Logiciel Educatif");
        fac1.getStyleClass().add("text_credits");
        gridpane.add(fac1, 1, 5);
        gridpane.setHalignment(fac1, HPos.CENTER);

        Text fac2 = new Text();
        fac2.setText("à l'Université Claude Bernard Lyon1");
        fac2.getStyleClass().add("text_credits");
        gridpane.add(fac2, 1, 6);
        gridpane.setHalignment(fac2, HPos.CENTER);

        Text licence = new Text();
        licence.setText("Sous licence CeCILL B");
        licence.getStyleClass().add("text_credits");
        gridpane.add(licence, 1, 8);
        gridpane.setHalignment(licence, HPos.CENTER);

        // Background
        gridpane.getStyleClass().add("small_background");

        // Scene
        Scene scene = new Scene(gridpane, w, h);
        scene.getStylesheets().add("/assets/css/Background.css");
        stage.setScene(scene);
        stage.show();
    }
}
