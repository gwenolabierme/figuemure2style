package model.user;

import javafx.scene.control.Button;

/**
 *
 * @author gwenolabierme
 */
public class UserDidacticiel {

    private String actualView;
    private String gender; // Fermier / Fermière

    public UserDidacticiel(String actualView, String gender) {
        this.actualView = actualView;
        this.gender = gender;
    }

    public Button message(String text) {
        Button msg = new Button(text);
        msg.setMinSize(580, 150);
        
        if (this.actualView.equals("GameView")) {
            msg.getStyleClass().add("didacticiel_other");
        }
        else if (this.gender.contains("farmer_man")) {
            msg.getStyleClass().add("didacticiel_famer_man");
        }
        else if (this.gender.contains("farmer_woman")) {
            msg.getStyleClass().add("didacticiel_famer_woman");
        }
        
        return msg;
    }
}
