package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Tomate.
 * @author jeremy
 */
public class Tomate extends Veggie {

    public Tomate() {
        this.name = PlantVarietyEnum.TOMATE;
        this.styDevEat = StylisticDeviceEnum.OXYMORE;
        this.price = 3;
    }
    
}
