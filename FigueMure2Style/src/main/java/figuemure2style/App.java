package figuemure2style;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MenuView;

/**
 * Classe principale de l'application.
 *
 * s'appuie sur javafx pour le rendu
 */
public class App extends Application {

    /**
     * Taille du jardin (carré de cases (terre cultivable) = taille*taille).
     */
    public static int gardenSize = 4;
    /**
     * Cases disponible au départ.
     */
    public static int freePlotBegin = 2;

    public static int windowsHeight = 800;
    public static int windowsWidht = 800;

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * En javafx start() lance l'application.
     */
    @Override
    public void start(Stage stage) {

        int height = 600;
        int width = 600;

        MenuView v = new MenuView(stage, width, height);
    }
}
