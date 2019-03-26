package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Patatte.
 * @author jeremy
 */
public class Pattate extends Veggie {

    public Pattate() {
        this.name = PlantVarietyEnum.PATATTE;
        this.styDevEat = StylisticDeviceEnum.HYPERBOLE;
        this.price = 1;
    }
    
}
