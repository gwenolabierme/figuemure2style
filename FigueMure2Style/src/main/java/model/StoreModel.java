package model;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.Mure;
import model.plant.Patate;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;
import model.stylisticDevice.FileStylisticD;
import model.stylisticDevice.StylisticDevice;
import model.stylisticDevice.StylisticDeviceEnum;
import model.user.User;

/**
 * Model de la boutique.
 *
 * @author jeremy
 */
public class StoreModel {

    private User usr;

    private Set<StylisticDevice> fertilizerList;

    public StoreModel(User usr) {
        this.usr = usr;
        this.fertilizerList = new HashSet<StylisticDevice>();
    }

    public StoreModel(User usr, HashSet<StylisticDevice> fertilizerList) {
        this.usr = usr;
        this.fertilizerList = fertilizerList;
    }

    /**
     * Rempli la fertilizerList aléatoirement en fonction des légumes débloqués.
     */
    public void updateFertilizer() {
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
                        if (plant.equals(PlantVarietyEnum.PATATE)) {
                            Patate p = new Patate();
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
        this.fertilizerList.clear();
        //on ajoute deux exemplaires de chaque figure disponible
        for (StylisticDeviceEnum sde : sdeList) {
            FileStylisticD file = FileStylisticD.load(sde);
            this.fertilizerList.add(getAleatStylDevice(file.get()));
            this.fertilizerList.add(getAleatStylDevice(file.get()));
        }
    }

    private StylisticDevice getAleatStylDevice(StylisticDevice[] sdTab) {
        int size = sdTab.length;

        Random rand = new Random();
        int randSD = rand.nextInt(size);

        return sdTab[randSD];
    }

    public User getUsr() {
        return usr;
    }

    /**
     * Retourne le Set d'engrais sous forme de tableau.
     *
     * @return tableau de figure de style
     */
    public StylisticDevice[] getFertilizerTab() {
        if (this.fertilizerList.size() > 0) {
            return this.fertilizerList.toArray(new StylisticDevice[this.fertilizerList.size()]);
        } else {
            return null;
        }
    }
}
