package model.user;

import javafx.scene.control.Button;

/**
 *
 * @author gwenolabierme
 */
public class UserVegetableRatio {

    private String img;
    private Button btn;
    private String figureDeStyle;
    private String ratio;

    public UserVegetableRatio() {

    }

    public UserVegetableRatio(String img, String btn, String figureDeStyle, String ratio) {
        this.img = img;
        this.btn = new Button();
        this.figureDeStyle = figureDeStyle;
        this.ratio = ratio;

    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public Button getBtn() {
        return btn;
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

    public static class ButtonUserVegetableRatio {

        Button btn;

        private ButtonUserVegetableRatio() {
            btn = new Button("The Button");
            btn.setMinSize(60, 60);
            //btn.getStyleClass().add("logoSettingsView");
        }

        public Button getButton() {
            return btn;
        }
    }
}
