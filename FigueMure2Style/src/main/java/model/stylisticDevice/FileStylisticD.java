package model.stylisticDevice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static final String pathBD = "src/main/resources/BD/figures/";
    
    private Set<StylisticDevice> styDevices;

    public FileStylisticD(StylisticDeviceEnum sdType) {
        this.styDevices = new HashSet<StylisticDevice>();
        this.sdType = sdType;
    }
    
    public StylisticDevice[] get() {
        return this.styDevices.toArray(new StylisticDevice[this.styDevices.size()]);
    }
    
    /**
     * Ajoute une figure de style au fichier.
     * @param sd StylisticDevice : une figure de style
     * @throws model.stylisticDevice.DifferentsStylisticDeviceType erreur
     */
    public void addStylisiticD(StylisticDevice sd) throws DifferentsStylisticDeviceType {
        if ((sd != null) && (sd.getSdType() == this.sdType)) {
            this.styDevices.add(sd);
        } else {
            throw new DifferentsStylisticDeviceType("The type of the stylistic"
                    + "device is differents of the file's.");
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
    
    public int size() {
        return this.styDevices.size();
    }
    
    /**
     * Sauvegarde un fichier de figure de style.
     * 
     * @return true si la map a été sauvegarée, false sinon
     */
    public boolean save() {
        ObjectOutputStream oos;
        boolean saveSuccess = true;
        
        if (isDirectoryBDExist()) {
            try {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                          new FileOutputStream(
                            new File(pathBD + this.sdType.toString()))));
                // Sauvegarde du fichier
                oos.writeObject(this);

                // Fermeture du flux
                oos.close();

            } catch (IOException ex) { 
                Logger.getLogger(FileStylisticD.class.getName())
                        .log(Level.SEVERE, "Impossible de sauvegarder le fichier : {0}", ex);
                saveSuccess = false;
            }
        } else {
            Logger.getLogger(FileStylisticD.class.getName())
                    .log(Level.SEVERE, "Impossible de trouver le dossier BD et de le creer.");
            saveSuccess = false;
        }
        
        return saveSuccess;
    }
    
    /**
     * Charge un fichier de figure de style.
     * 
     * @param sd le type de figure de style contenue dans le fichier
     * @return la map chargée depuis le fichier, null sinon
     */
    public static FileStylisticD load(StylisticDeviceEnum sd) {
        ObjectInputStream ois;
        FileStylisticD loadedMap = null;
        
        if (isDirectoryBDExist()) {
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                          new FileInputStream(
                            new File(pathBD + sd.toString()))));
                // Chargement du fichier
                loadedMap = (FileStylisticD) ois.readObject();

                // Fermeture du flux
                ois.close();

            } catch (IOException ex) { 
                Logger.getLogger(FileStylisticD.class.getName())
                        .log(Level.SEVERE, "Impossible de charger le fichier : {0}", ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FileStylisticD.class.getName())
                        .log(Level.SEVERE, "Impossible de charger le fichier : {0}", ex);
            }
        } else {
            Logger.getLogger(FileStylisticD.class.getName())
                    .log(Level.SEVERE, "Impossible de trouver le dossier BD et de le creer.");
        }
        
        return loadedMap;
    }
    
     /**
     * Test si le répertoire BD exist. Si ce n'est pas le cas, on le créait.
     * 
     * @return true si le répertoire BD exist ou a pu être créé, false sinon
     */
    private static boolean isDirectoryBDExist() {
        Path path;
        boolean directoryExist = true;
        
        path = Paths.get(pathBD);
        // Si le répertoire BD n'existe pas encore, on le créer
        if (!(Files.exists(path) && (Files.isDirectory(path)))) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                Logger.getLogger(FileStylisticD.class.getName())
                        .log(Level.SEVERE, "Impossible de creer le dossier BD : {0}", ex);
                directoryExist = false;
            }
        }
        
        return directoryExist;
    }
    
}
