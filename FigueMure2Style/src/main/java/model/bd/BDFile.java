package model.bd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fichiers de BD pour les utilisateurs.
 */
public class BDFile {
    private static final String BD_path = "src/main/resources/BD/User";
    private Map<String, String> map;

    public BDFile() {
        this.map = new HashMap<String, String>();
    }
    
    /**
     * Sauvegarde un fichier contenant les information d'un utilisateur.
     * @return true si la map a été sauvegarée, false sinon
     */
    public boolean newFile(String pseudo, Map m) {
        ObjectOutputStream oos;
        boolean saveSuccess = true;
        
        if (isDirectoryBDExist()) {
            try {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                          new FileOutputStream(
                            new File(BD_path + "/" + pseudo))));
                // Sauvegarde du fichier
                oos.writeObject(m);

                // Fermeture du flux
                oos.close();

            } catch (IOException ex) { 
                Logger.getLogger(BDFile.class.getName())
                        .log(Level.SEVERE, "Impossible de sauvegarder le fichier : {0}", ex);
                saveSuccess = false;
            }
        } else {
            Logger.getLogger(BDFile.class.getName())
                    .log(Level.SEVERE, "Impossible de trouver le dossier BD et de le creer.");
            saveSuccess = false;
        }
        
        return saveSuccess;
    }
    
    
    /**
     * Charge un fichier de figure de style.
     * @param pseudo le nom du fichier
     * @return la map chargée depuis le fichier, null sinon
     */
    public Map loadFile(String pseudo) {
        ObjectInputStream ois;
        Map newMap = null;
        
        if (isDirectoryBDExist()) {
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                          new FileInputStream(
                            new File(BD_path + "/" + pseudo))));
                // Chargement du fichier
                newMap = (Map) ois.readObject();

                // Fermeture du flux
                ois.close();

            } catch (IOException ex) { 
                Logger.getLogger(BDFile.class.getName())
                        .log(Level.SEVERE, "Impossible de charger le fichier : {0}", ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BDFile.class.getName())
                        .log(Level.SEVERE, "Impossible de charger le fichier : {0}", ex);
            }
        } else {
            Logger.getLogger(BDFile.class.getName())
                    .log(Level.SEVERE, "Impossible de trouver le dossier BD et de le creer.");
        }
        
        return newMap;
    }
    
    /**
     * Test si le répertoire BD exist. Si ce n'est pas le cas, on le créait.
     * @return true si le répertoire BD exist ou a pu être créé, false sinon
     */
    private static boolean isDirectoryBDExist() {
        Path path;
        boolean directoryExist = true;
        
        path = Paths.get(BD_path);
        // Si le répertoire BD n'existe pas encore, on le créer
        if (!(Files.exists(path) && (Files.isDirectory(path)))) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                Logger.getLogger(BDFile.class.getName())
                        .log(Level.SEVERE, "Impossible de creer le dossier BD : {0}", ex);
                directoryExist = false;
            }
        }
        
        return directoryExist;
    }
    
    /**
     * isFileBDExist.
     * @param pseudo Pseudo de l'utilisateur
     * @return true si le fichier exist
     */
    public boolean isFileBDExist(String pseudo) {
        Path path;
        boolean fileExist = true;
        
        path = Paths.get(BD_path + "/" + pseudo);
        // Si le fichier BD n'existe pas
        if (!(Files.exists(path))) {
            fileExist = false;
        }
        
        return fileExist;
    }
}
