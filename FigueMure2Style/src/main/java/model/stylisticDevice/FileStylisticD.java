package model.stylisticDevice;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author jeremy
 */
public class FileStylisticD implements Serializable{
    /**
     * Type de figure de style du fichier.
     */
    protected final StylisticDeviceEnum sdType;
    /**
     * Chemin vers les fichiers.
     */
    private final String path = "/BD";
    
    private Set<StylisticDevice> styDevices;

    public FileStylisticD(StylisticDeviceEnum sdType) {
        this.sdType = sdType;
    }
    
    /**
     * Ajoute une figure de style au fichier.
     * @param sd StylisticDevice : une figure de style
     */
    public void addStylisiticD(StylisticDevice sd) {
        if (sd.getSdType() == this.sdType) {
            this.styDevices.add(sd);
        } else {
            // TODO : THROW AN EXCEPTION
        }
    }
    
    /**
     * Supprime une figure de style au fichier.
     * @param sd StylisticDevice : une figure de style
     */
    public void deleteStylisticD(StylisticDevice sd) {
        this.styDevices.remove(sd);
    }
    
    /**
     * Y a t'il des figures de style dans le fichier ?
     * @return true si le fichier est vide, false sinon
     */
    public boolean isEmpty() {
        return this.styDevices.isEmpty();
    }
    
    //TODO : save
    
    //TODO : load
    
}
