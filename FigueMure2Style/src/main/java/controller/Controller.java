package controller;

import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;
import view.JfxView;

/**
 * Class controler.
 * @author jeremy
 */
public class Controller {
    /**
     * Liste des vues géré par le controleur.
     */
    private final List<JfxView> views;
    /**
     * Liste que le controleur doit mettre à jour (les autres sont des
     * observers et se mettent à jour toutes seules).
     */
    private final List<JfxView> updateViews;
    /**
     * Modèle des données à gérer.
     */
    private FieldModel model;

    private AnimationTimer timer;

    private static Controller instance;
    private boolean paused = false;

    private Controller() {
        this.views = new ArrayList<JfxView>();
        this.updateViews = new ArrayList<JfxView>();
    }

    /**
     * Renvoie une instance unique de ce contrôleur.
     *
     * @return Instance unique du contrôleur
     */
    public static Controller getControler() {
        if (Controller.instance == null) {
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }

    public void addView(JfxView v) {
        this.views.add(v);
    }

    public void addUpdateView(JfxView v) {
        this.updateViews.add(v);
        this.views.add(v);
    }

    /**
     * Lance la boucle principale du jeu.
     */
    public void startTimer() {
        if (timer != null) {
            return;
        }
        for (JfxView view : views) {
            view.show();
            view.display();
        }
        timer = new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (model.update()) {
                    for (JfxView view : updateViews) {
                        view.display();
                    }
                }
            }
        };
        timer.start(); // On lance la boucle de rafraichissement
    }

    public void setModel(FieldModel m) {
        this.model = m;
    }

    /**
     * Mets en pause le jeu ou le relance si il était déjà en pause.
     */
    public void togglePause() {
        if (this.paused) {
            this.timer.start();
        } else {
            this.timer.stop();
        }
        this.paused = !this.paused;
    }
}
