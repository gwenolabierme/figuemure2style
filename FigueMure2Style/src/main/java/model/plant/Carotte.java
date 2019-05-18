package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Model de Carotte.
 * @author jeremy
 */
public class Carotte extends Veggie {

    public Carotte() {
        this.name = PlantVarietyEnum.CAROTTE;
        this.styDevEat = StylisticDeviceEnum.COMPARAISON;
        this.price = 1;
        this.nbXp = 5;
    }
    
}
