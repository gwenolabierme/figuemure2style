package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Pomme.
 * @author jeremy
 */
public class Pomme extends Fruit {

    public Pomme() {
        this.name = PlantVarietyEnum.POMME;
        this.styDevEat = StylisticDeviceEnum.CHIASME;
        this.price = 3;
    }
    
}
