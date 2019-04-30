package model;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.Mure;
import model.plant.Pattate;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;
import model.stylisticDevice.FileStylisticD;
import model.stylisticDevice.StylisticDevice;
import model.stylisticDevice.StylisticDeviceEnum;
import model.user.User;

/**
 *
 * @author jeremy
 */
public class StoreModel {
    private User usr;
    
    private Set<StylisticDevice> fertilizerList;
    
    public StoreModel (User usr) {
        this.usr = usr;
        this.fertilizerList = new HashSet<StylisticDevice>();
    }
    
    /**
     * Rempli la fertilizerList aléatoirement en fonction des légumes débloqués.
     */
    private void updateFertilizer () {
        EnumSet<StylisticDeviceEnum> sdeList = EnumSet.noneOf(StylisticDeviceEnum.class);
        
        //détermine les figures de styles
        for (PlantVarietyEnum plant : this.usr.getPlantUnlock()) {
            if (plant.equals(PlantVarietyEnum.CAROTTE)) {
                Carotte p = new Carotte();
                sdeList.add(p.getStyDevEat());
            } else {
                if (plant.equals(PlantVarietyEnum.FIGUE)) {
                    Figue p = new Figue();
                    sdeList.add(p.getStyDevEat());
                } else {
                    if (plant.equals(PlantVarietyEnum.MURE)) {
                        Mure p = new Mure();
                        sdeList.add(p.getStyDevEat());
                    } else {
                        if (plant.equals(PlantVarietyEnum.PATATTE)) {
                            Pattate p = new Pattate();
                            sdeList.add(p.getStyDevEat());
                        } else {
                            if (plant.equals(PlantVarietyEnum.POMME)) {
                                Pomme p = new Pomme();
                                sdeList.add(p.getStyDevEat());
                            } else {
                                if (plant.equals(PlantVarietyEnum.TOMATE)) {
                                    Tomate p = new Tomate();
                                    sdeList.add(p.getStyDevEat());
                                }
                            }
                        }
                    }
                }
            }
        }
        
        //traitement de figues de styles
        for (StylisticDeviceEnum sde : sdeList) {
            FileStylisticD file = FileStylisticD.load(sde);
        }
    }
}
