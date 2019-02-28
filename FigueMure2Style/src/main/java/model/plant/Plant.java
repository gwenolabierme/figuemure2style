package model.plant;

import model.stylisticDevice.StylisticDeviceEnum;

/**
 * Classe générique pour les plantes.
 * @author jeremy
 */
public abstract class Plant {
    /**
     * Nom de la plante.
     */
    protected PlantVarietyEnum name;
    /**
     * Figure de style mangée par la plante.
     */
    protected StylisticDeviceEnum styDevEat;
    /**
     * Prix de vente de base.
     */
    protected int price;

    
    public Plant() {
        this.name = null;
        this.styDevEat = null;
        this.price = 0;
    }
    
    
    public PlantVarietyEnum getName() {
        return name;
    }

    public StylisticDeviceEnum getStyDevEat() {
        return styDevEat;
    }

    public int getPrice() {
        return price;
    }
    
}
