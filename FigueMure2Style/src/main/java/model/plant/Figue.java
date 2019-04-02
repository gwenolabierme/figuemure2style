package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Figue.
 * @author jeremy
 */
public class Figue extends Fruit {

    public Figue() {
        this.name = PlantVarietyEnum.FIGUE;
        this.styDevEat = StylisticDeviceEnum.PERIPHRASE;
        this.price = 1;
    }
    
}
