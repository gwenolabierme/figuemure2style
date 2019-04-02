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

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * En javafx start() lance l'application.
     *
     * href="http://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm">jfxpub-scenegraph.htm</a>
     */
    @Override
    public void start(Stage stage) {

        int height = 600;
        int width = 600;

        MenuView v = new MenuView(stage, width, height); // 600x600 pixels
    }
}
