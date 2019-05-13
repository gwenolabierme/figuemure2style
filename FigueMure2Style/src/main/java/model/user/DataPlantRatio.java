package model.user;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public class DataPlantRatio implements Serializable {

    private long nbVictory;
    private long nbDefeat;
    private double ratio; // ratio de victoire

    public DataPlantRatio(long nbVictory, long nbDefeat, double ratio) {
        this.nbVictory = nbVictory;
        this.nbDefeat = nbDefeat;
        this.ratio = ratio;
    }

    public long getNbVictory() {
        return nbVictory;
    }

    public void setNbVictory(long nbVictory) {
        this.nbVictory = nbVictory;
    }

    public long getNbDefeat() {
        return nbDefeat;
    }

    public void setNbDefeat(long nbDefeat) {
        this.nbDefeat = nbDefeat;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}
