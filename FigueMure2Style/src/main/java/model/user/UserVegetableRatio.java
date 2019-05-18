package model.user;

import javafx.scene.control.Button;

/**
 *
 * @author gwenolabierme
 */
public class UserVegetableRatio {

    private String img;
    private String figureDeStyle;
    private String ratio;

    public UserVegetableRatio() {

    }

    public UserVegetableRatio(String img, String figureDeStyle, String ratio) {
        this.img = img;
        this.figureDeStyle = figureDeStyle;
        this.ratio = ratio;
    }

    public String getImg() {
        return img;
    }

    public String getFigureDeStyle() {
        return figureDeStyle;
    }

    public String getRatio() {
        return ratio;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setFigureDeStyle(String figureDeStyle) {
        this.figureDeStyle = figureDeStyle;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
}
