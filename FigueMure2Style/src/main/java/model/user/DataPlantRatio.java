package model.user;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public class DataPlantRatio implements Serializable {

    private int nbVictory;
    private int nbDefeat;
    private double ratio; // ratio de victoire

    public DataPlantRatio() {
        this.nbVictory = 0;
        this.nbDefeat = 0;
        this.ratio = 0;
    }

    public DataPlantRatio(int nbVictory, int nbDefeat) {
        this.nbVictory = nbVictory;
        this.nbDefeat = nbDefeat;
        this.ratio = nbVictory / nbDefeat;
    }

    public DataPlantRatio(int nbVictory, int nbDefeat, double ratio) {
        this.nbVictory = nbVictory;
        this.nbDefeat = nbDefeat;
        this.ratio = ratio;
    }

    public int getNbVictory() {
        return nbVictory;
    }

    public void setNbVictory(int nbVictory) {
        this.nbVictory = nbVictory;
    }

    public int getNbDefeat() {
        return nbDefeat;
    }

    public void setNbDefeat(int nbDefeat) {
        this.nbDefeat = nbDefeat;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}
