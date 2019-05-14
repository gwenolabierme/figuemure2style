package model.user;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import model.ModelException;
import model.bd.BDFile;
import model.plant.PlantVarietyEnum;

/**
 * Utilisateur.
 */
public class User {

    private String pseudo;
    private String gender;
    private String password;
    private String passwordConfirm;
    private int score;
    private EnumSet<PlantVarietyEnum> plantUnlock;
    private HashMap<PlantVarietyEnum, Integer> inventory;
    /**
     * Données (victoire, défaites, ratio) pour chaque plante débloquée
     */
    private HashMap<PlantVarietyEnum, DataPlantRatio> dataSucces;

    /**
     * Constructeur User.
     */
    public User() {
    }

    /**
     * Constructeur User.
     *
     * @param pseudo Pseudo de l'utilisateur
     */
    public User(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Constructeur User.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @param gender Genre : Fermier / Fermiere
     * @throws model.ModelException erreur
     */
    public User(String pseudo, String gender) throws ModelException {
        setPseudo(pseudo);
        setGender(gender, pseudo);
        setScore(0, pseudo);

        // Creation d'un fichier de BD user
        Map<String, String> map = new HashMap<String, String>();
        map.put("pseudo", this.pseudo);
        map.put("gender", this.gender);
        map.put("score", Integer.toString(this.score));

        // Légumes débloqués
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
        initPlantUnlock();
        map.put("plantUnlock", this.plantUnlock.toString());

        // Inventaire
        inventory = new HashMap<PlantVarietyEnum, Integer>();
        initStock();
        map.put("PlantVarietyEnum.CAROTTE", inventory.get(PlantVarietyEnum.CAROTTE).toString());
        map.put("PlantVarietyEnum.FIGUE", inventory.get(PlantVarietyEnum.FIGUE).toString());
        map.put("PlantVarietyEnum.MURE", inventory.get(PlantVarietyEnum.MURE).toString());
        map.put("PlantVarietyEnum.PATATTE", inventory.get(PlantVarietyEnum.PATATTE).toString());
        map.put("PlantVarietyEnum.POMME", inventory.get(PlantVarietyEnum.POMME).toString());
        map.put("PlantVarietyEnum.TOMATE", inventory.get(PlantVarietyEnum.TOMATE).toString());

        BDFile f = new BDFile();
        f.newFile(pseudo, map);
    }

    /**
     * Constructeur User.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @param gender Genre : Fermier / Fermiere
     * @param password Mot de passe
     * @param passwordConfirm Mot de passe de confirmation
     * @throws model.ModelException erreur
     */
    public void User(String pseudo, String gender, String password, String passwordConfirm) throws ModelException {
        if (goodPassword(password, passwordConfirm)) {
            setPseudo(pseudo);
            setGender(gender, pseudo);
            setPassword(password, pseudo);
            setPasswordConfirm(passwordConfirm, pseudo);
            setScore(0, pseudo);

            // Creation d'un fichier de BD user
            Map<String, String> map = new HashMap<String, String>();
            map.put("pseudo", this.pseudo);
            map.put("gender", this.gender);
            map.put("password", this.password);
            map.put("passwordConfirm", this.passwordConfirm);
            map.put("score", Integer.toString(this.score));

            // Légumes débloqués
            plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
            initPlantUnlock();
            map.put("plantUnlock", this.plantUnlock.toString());

            // Inventaire
            inventory = new HashMap<PlantVarietyEnum, Integer>();
            initStock();
            map.put("PlantVarietyEnum.CAROTTE", inventory.get(PlantVarietyEnum.CAROTTE).toString());
            map.put("PlantVarietyEnum.FIGUE", inventory.get(PlantVarietyEnum.FIGUE).toString());
            map.put("PlantVarietyEnum.MURE", inventory.get(PlantVarietyEnum.MURE).toString());
            map.put("PlantVarietyEnum.PATATTE", inventory.get(PlantVarietyEnum.PATATTE).toString());
            map.put("PlantVarietyEnum.POMME", inventory.get(PlantVarietyEnum.POMME).toString());
            map.put("PlantVarietyEnum.TOMATE", inventory.get(PlantVarietyEnum.TOMATE).toString());

            BDFile f = new BDFile();
            f.newFile(pseudo, map);
        }
    }

    /**
     * getUser. Recupere l'utilisateur dans les fichiers de BD user.
     *
     * @param pseudo Pseudo de l'utilisateur
     */
    public void getUser(String pseudo) {
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        
        this.pseudo = (String) mapUser.get("pseudo");
        this.gender = (String) mapUser.get("gender");
        this.score = Integer.parseInt((String) mapUser.get("score"));

        // Légumes débloqués
        String listPlantUnlock = (String) mapUser.get("plantUnlock");
        EnumSet<PlantVarietyEnum> listVarietyPlantUnlock = null;
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);

        if (listPlantUnlock.contains("carotte")) {
            addPlantUnlock(PlantVarietyEnum.CAROTTE);
        }
        if (listPlantUnlock.contains("figue")) {
            addPlantUnlock(PlantVarietyEnum.FIGUE);
        }
        if (listPlantUnlock.contains("mure")) {
            addPlantUnlock(PlantVarietyEnum.MURE);
        }
        if (listPlantUnlock.contains("pattate")) {
            addPlantUnlock(PlantVarietyEnum.PATATTE);
        }
        if (listPlantUnlock.contains("pomme")) {
            addPlantUnlock(PlantVarietyEnum.POMME);
        }
        if (listPlantUnlock.contains("tomate")) {
            addPlantUnlock(PlantVarietyEnum.TOMATE);
        }

        // Inventaire
        String listInventory;
        inventory = new HashMap<PlantVarietyEnum, Integer>();
        this.inventory.put(PlantVarietyEnum.CAROTTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE")));
        this.inventory.put(PlantVarietyEnum.FIGUE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE")));
        this.inventory.put(PlantVarietyEnum.MURE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE")));
        this.inventory.put(PlantVarietyEnum.PATATTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATTE")));
        this.inventory.put(PlantVarietyEnum.POMME, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME")));
        this.inventory.put(PlantVarietyEnum.TOMATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE")));
    }

    /**
     * getUser. Recupere l'utilisateur dans les fichiers de BD user si
     * l'utilisateur a entre le bon mot de passe.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @param password mot de passe
     * @throws model.ModelException erreur
     */
    public void getUser(String pseudo, String password) throws ModelException {
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        if (password.equals((String) mapUser.get("password"))) {
            this.pseudo = (String) mapUser.get("pseudo");
            this.gender = (String) mapUser.get("gender");
            this.password = (String) mapUser.get("password");
            this.passwordConfirm = (String) mapUser.get("passwordConfirm");
            this.score = Integer.parseInt((String) mapUser.get("score"));

            // Légumes débloqués
            String listPlantUnlock = (String) mapUser.get("plantUnlock");
            EnumSet<PlantVarietyEnum> listVarietyPlantUnlock = null;
            plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);

            if (listPlantUnlock.contains("carotte")) {
                addPlantUnlock(PlantVarietyEnum.CAROTTE);
            }
            if (listPlantUnlock.contains("figue")) {
                addPlantUnlock(PlantVarietyEnum.FIGUE);
            }
            if (listPlantUnlock.contains("mure")) {
                addPlantUnlock(PlantVarietyEnum.MURE);
            }
            if (listPlantUnlock.contains("pattate")) {
                addPlantUnlock(PlantVarietyEnum.PATATTE);
            }
            if (listPlantUnlock.contains("pomme")) {
                addPlantUnlock(PlantVarietyEnum.POMME);
            }
            if (listPlantUnlock.contains("tomate")) {
                addPlantUnlock(PlantVarietyEnum.TOMATE);
            }

            // Inventaire
            String listInventory;
            this.inventory = new HashMap<PlantVarietyEnum, Integer>();
            this.inventory.put(PlantVarietyEnum.CAROTTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE")));
            this.inventory.put(PlantVarietyEnum.FIGUE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE")));
            this.inventory.put(PlantVarietyEnum.MURE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE")));
            this.inventory.put(PlantVarietyEnum.PATATTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATTE")));
            this.inventory.put(PlantVarietyEnum.POMME, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME")));
            this.inventory.put(PlantVarietyEnum.TOMATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE")));
        } else {
            throw new ModelException("Le mot de passe ne correspond pas");
        }
    }

    /**
     * setUser remplace les données utilisateur dans la BD.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @param gender Genre : Fermier / Fermiere
     * @throws model.ModelException erreur
     */
    public void setUser(String pseudo, String gender) throws ModelException {
        setPseudo(pseudo);
        setGender(gender, pseudo);
    }

    /**
     * setUser remplace les données utilisateur dans la BD.
     * 
     * @param pseudo Pseudo de l'utilisateur
     * @param gender Genre : Fermier / Fermiere
     * @param password Mot de passe de l'utilisateur
     * @param passwordConfirm Mot de passe de confirmation de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setUser(String pseudo, String gender, String password, String passwordConfirm) throws ModelException {
        setPseudo(pseudo);
        setGender(gender, pseudo);
        setPassword(password, pseudo);
        setPasswordConfirm(passwordConfirm, pseudo);
    }

    // TODO
    public void deleteUser(String pseudo) {

    }

    // TODO
    public void deleteUser(String pseudo, String password) {

    }

    /**
     * isUserExist. Fichier BD user existe.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @return True si le fichier exist
     */
    public boolean isUserExist(String pseudo) {
        BDFile f = new BDFile();
        if (f.isFileBDExist(pseudo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * goodPassword. Password and PasswordConfirm sont les mêmes.
     *
     * @param password Mot de passse
     * @param passwordConfirm Mot de passe de confirmation
     * @return true si le password est bon
     * @throws model.ModelException erreur
     */
    public boolean goodPassword(String password, String passwordConfirm) throws ModelException {
        if (password.equals(passwordConfirm)) {
            return true;
        } else {
            throw new ModelException("La confirmation de mot de passe ne correspond pas au mot de passe");
        }
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public int getScore() {
        return score;
    }
    
    /**
     * setPseudo remplace le pseudo de l'utilisateur dans la BD.
     * 
     * @param pseudo Pseudo de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setPseudo(String pseudo) throws ModelException {
        if (pseudo.equals(null)) {
            throw new ModelException("Le champ pseudo est vide");
        } else {
            this.pseudo = pseudo;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("pseudo", this.pseudo);
        }
    }

    /**
     * setGender remplace le genre du personnage de l'utilisateur dans la BD.
     * 
     * @param gender Genre : Fermier / Fermiere
     * @param pseudo Pseudo de l'utilisateur
     */
    public void setGender(String gender, String pseudo) {
        if (gender.equals("fermier")) {
            this.gender = "/assets/img/user/farmer_man.jpg";
        } else {
            this.gender = "/assets/img/user/farmer_woman.jpg";
        }
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        mapUser.replace("gender", this.gender);
    }

    /**
     * setPassword remplace le mot de passe de l'utilisateur dans la BD.
     * 
     * @param password Mot de passe de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setPassword(String password, String pseudo) throws ModelException {
        if (password.equals(null)) {
            throw new ModelException("Le champ mot de passe est vide");
        } else {
            this.password = password;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("password", this.password);
        }
    }

    /**
     * setPasswordConfirm remplace le mot de passe de confirmation de l'utilisateur dans la BD.
     * 
     * @param passwordConfirm Mot de passe de confirmation de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur 
     * @throws model.ModelException erreur
     */
    public void setPasswordConfirm(String passwordConfirm, String pseudo) throws ModelException {
        if (passwordConfirm.equals(null)) {
            throw new ModelException("Le champ confirmation de mot de passe est vide");
        } else {
            this.passwordConfirm = passwordConfirm;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("passwordConfirm", this.passwordConfirm);
        }
    }

    /**
     * setScore ramplace le score de l'utilisateur dans la BD.
     * 
     * @param score Score de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur
     */
    public void setScore(int score, String pseudo) {
        this.score = score;
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        mapUser.replace("score", this.score);
    }

    /**
     * Débloque une plante dans la boutique.
     *
     * @param plant PlantVarietyEnum
     */
    public void addPlantUnlock(PlantVarietyEnum plant) {
        this.plantUnlock.add(plant);
    }

    /**
     * Initialisation des plantes débloquées.
     */
    public void initPlantUnlock() {
        this.addPlantUnlock(PlantVarietyEnum.CAROTTE);
    }

    public EnumSet<PlantVarietyEnum> getPlantUnlock() {
        return plantUnlock;
    }

    public HashMap<PlantVarietyEnum, Integer> getInventory() {
        return inventory;
    }

    /**
     * Initialisation des stock de plantes à 0.
     */
    public void initStock() {
        this.inventory.put(PlantVarietyEnum.CAROTTE, 0);
        this.inventory.put(PlantVarietyEnum.FIGUE, 0);
        this.inventory.put(PlantVarietyEnum.MURE, 0);
        this.inventory.put(PlantVarietyEnum.PATATTE, 0);
        this.inventory.put(PlantVarietyEnum.POMME, 0);
        this.inventory.put(PlantVarietyEnum.TOMATE, 0);
    }

    /**
     * Ajoute la plante dans l'inventaire
     *
     * @param variety variété de la plante
     * @param qty quantité de la plante dans l'inventaire
     * @return True si la plante a été ajoutée, false sinon
     */
    public boolean addInStock(PlantVarietyEnum variety, int qty) {
        boolean plantAdd = false;

        if (this.plantUnlock.contains(variety)) {
            this.inventory.put(variety, qty);
            plantAdd = true;
        }

        return plantAdd;
    }

    /**
     * Change la quantité de la plante dans l'inventaire
     *
     * @param variety variété de la plante
     * @param qty quantité de la plante dans l'inventaire
     */
    public void changeQtyStock(PlantVarietyEnum variety, int qty) {
        this.inventory.replace(variety, qty);
    }

    /**
     * La plante est-elle dans l'inventaire ?
     *
     * @param variety variété de la plante
     * @return True si la plante est dans l'inventaire, false sinon
     */
    public boolean stockContainPlant(PlantVarietyEnum variety) {
        return this.inventory.containsKey(variety);
    }

    /**
     * Suprime la plante de l'inventaire.
     *
     * @param variety plante à supprimer
     */
    public void removePlantStock(PlantVarietyEnum variety) {
        this.inventory.remove(variety);
    }

    /**
     * Met a jour les ratios de chaques stratégies en fonction de leur nombre de
     * victoires et défaites.
     */
    private void updateRatios() {
        double ratio;

        for (PlantVarietyEnum key : this.dataSucces.keySet()) {
            DataPlantRatio data = this.dataSucces.get(key);
            ratio = (double) data.getNbVictory() / data.getNbDefeat();
            data.setRatio(ratio);
        }
    }

    /**
     * Met à jour le ratio de probabilité de la plante.
     *
     * @param key plante à mettre à jour
     * @param isSuccess True si le joueur a bien arrosé la plante, false sinon
     */
    public void updateDico(PlantVarietyEnum key, boolean isSuccess) {
        DataPlantRatio data = this.dataSucces.get(key);

        if (isSuccess) {
            data.setNbVictory(data.getNbVictory() + 1);
        } else {
            data.setNbDefeat(data.getNbDefeat() + 1);
        }

        this.updateRatios();
    }
}
