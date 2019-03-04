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
    /**
     * Etat de croissance actuel de la plante.
     */
    protected GrowthStateEnum growthState;
    /**
     * Vie de la plante. Diminue à chaque erreur de nouriture.
     */
    protected int life;

    
    public Plant() {
        this.name = null;
        this.styDevEat = null;
        this.price = 0;
        
        growthState = GrowthStateEnum.SPROUT;
        life = 3;
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

    public GrowthStateEnum getGrowthState() {
        return growthState;
    }

    public int getLife() {
        return life;
    }
    
    public void setGrowthState(GrowthStateEnum growthState) {
        this.growthState = growthState;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
}
