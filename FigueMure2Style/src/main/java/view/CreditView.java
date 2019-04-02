
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
 *
 * Crédis
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

        
        
        
        Button buttonReturn = new Button("<-");
        buttonReturn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                MenuView mv = new MenuView(stage, w, h);
            }
        });
        buttonReturn.setMinSize(200, 50);
        gridpane.add(buttonReturn, 2, 0);
        gridpane.setHalignment(buttonReturn, HPos.RIGHT);
        
        
        
        
        Text title = new Text();
        title.setText("Crédis");
        gridpane.add(title, 1, 0);
        gridpane.setHalignment(title, HPos.CENTER);
        
        Text developpeur = new Text();
        developpeur.setText("Concepteur & Développeurs");
        gridpane.add(developpeur, 1, 2);
        gridpane.setHalignment(developpeur, HPos.CENTER);
        
        Text noms = new Text();
        noms.setText("Gwénola Biermé & Jérémy Duval");
        gridpane.add(noms, 1, 3);
        gridpane.setHalignment(noms, HPos.CENTER);
        
        Text fac = new Text();
        fac.setText("Réalisé dans le cadre d'un cours de Logiciel Educatif à l'Université CLaude Bernard Lyon1");
        gridpane.add(fac, 1, 5);
        gridpane.setHalignment(fac, HPos.CENTER);
        
        Text licence = new Text();
        licence.setText("Sous licence CeCILL B");
        gridpane.add(licence, 1, 7);
        gridpane.setHalignment(licence, HPos.CENTER);
        
        Scene scene = new Scene(gridpane, w, h);
        stage.setScene(scene);
        stage.show();
    }
    
    
}

