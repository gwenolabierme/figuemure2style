package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Mure.
 * @author jeremy
 */
public class Mure extends Fruit {

    public Mure() {
        this.name = PlantVarietyEnum.MURE;
        this.styDevEat = StylisticDeviceEnum.PERSONNIFICATION;
        this.price = 1;
        this.nbXp = 5;
    }
    
}
