package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Patatte.
 * @author jeremy
 */
public class Patate extends Veggie {

    public Patate() {
        this.name = PlantVarietyEnum.PATATE;
        this.styDevEat = StylisticDeviceEnum.HYPERBOLE;
        this.price = 1;
        this.nbXp = 5;
    }
    
}
