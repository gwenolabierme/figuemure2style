package figuemure2style;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.stylisticDevice.DifferentsStylisticDeviceType;
import model.stylisticDevice.FileStylisticD;
import model.stylisticDevice.StylisticDevice;
import model.stylisticDevice.StylisticDeviceEnum;

/**
 *
 * @author jeremy
 */
public class BDeditor {
    public static void main(String[] args) {
        createComparaison();
        
        printFile(StylisticDeviceEnum.COMPARAISON);
    }
    
    
    
    public static void createComparaison() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.COMPARAISON);
        
        try {
            StylisticDevice sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Un petit baiser, comme une folle araignée, Te courra par le cou…",
                    "Rimbaud", "Rêvé pour l’hiver");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans comparaison *****");
        }
        
        file.save();
    }
    
    public static void printFile(StylisticDeviceEnum sd) {
        FileStylisticD file =  FileStylisticD.load(sd);
        
        StylisticDevice[] sdTab = file.get();
        for(int i = 0; i< sdTab.length; ++i) {
            System.out.println(sdTab[i]);
        }
    }
}
