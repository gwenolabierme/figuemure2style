package model.user;

import javafx.scene.control.Button;

/**
 * Messages du didacticiel.
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

        if (this.actualView.equals("GameView")) {
            msg.setMinSize(580, 150);
            msg.getStyleClass().add("didacticiel_other");
        } else if (this.gender.contains("farmer_man")) {
            msg.setMinSize(800, 200);
            msg.getStyleClass().add("didacticiel_famer_man");
        } else if (this.gender.contains("farmer_woman")) {
            msg.setMinSize(580, 150);
            msg.getStyleClass().add("didacticiel_famer_woman");
        }

        return msg;
    }
}
