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
     * Constructeur User.
     * 
     * @param pseudo Pseudo de l'utilisateur
     */
    public User(String pseudo) {
        this.pseudo = pseudo;
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
        initPlantUnlock();
    }
    
    /**
     * Constructeur User.
     * 
     * @param pseudo Pseudo de l'utilisateur
     * @param gender Genre : Fermier / Fermiere
     * @throws model.ModelException
     */
    public User(String pseudo, String gender) throws ModelException {
        setPseudo(pseudo);
        setGender(gender);
        setScore(0);
        
        // Creation d'un fichier de BD user
        Map<String, String> map = new HashMap<String, String>();
        map.put("pseudo", this.pseudo);
        map.put("gender", this.gender);
        map.put("score", Integer.toString(this.score));
        BDFile f = new BDFile();
        f.newFile(pseudo, map);
        
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
        initPlantUnlock();
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
            setGender(gender);
            setPassword(password);
            setPasswordConfirm(passwordConfirm);
            setScore(0);    
            
            // Creation d'un fichier de BD user
            Map<String, String> map = new HashMap<String, String>();
            map.put("pseudo", this.pseudo);
            map.put("gender", this.gender);
            map.put("password", this.password);
            map.put("passwordConfirm", this.passwordConfirm);
            map.put("score", Integer.toString(this.score));
            BDFile f = new BDFile();
            f.newFile(pseudo, map);
            
            plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
            initPlantUnlock();
        }
    }
    

    /**
     * getUser.
     * Recupere l'utilisateur dans les fichiers de BD user.
     * 
     * @param pseudo Pseudo de l'utilisateur
     */
    public void getUser(String pseudo) {
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        this.pseudo = (String) mapUser.get("pseudo");
        this.gender = (String) mapUser.get("gender");
        this.score = Integer.parseInt( (String) mapUser.get("score"));
    }
    
    /**
     * getUser.
     * Recupere l'utilisateur dans les fichiers de BD user si l'utilisateur a entre le bon mot de passe.
     * 
     * @param pseudo Pseudo de l'utilisateur
     * @param password mot de passe
     */
    public void getUser(String pseudo, String password) {
        //if (goodPassword())
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        this.pseudo = (String) mapUser.get("pseudo");
        this.gender = (String) mapUser.get("gender");
        this.password = (String) mapUser.get("password");
        this.passwordConfirm = (String) mapUser.get("passwordConfirm");
        this.score = Integer.parseInt( (String) mapUser.get("score"));
    }
    
    // TODO
    public void setUser(String pseudo, String gender) {
        
    }
    
    // TODO
    public void setUser(String pseudo, String gender, String password, String passwordConfirm) {
        
    }
    
    // TODO
    public void deleteUser(String pseudo) {
        
    }
    
    // TODO
    public void deleteUser(String pseudo, String password) {
        
    }
    
    // TODO
    public boolean isUserExist(String pseudo) {
        BDFile f = new BDFile();
        if (f.isFileBDExist(pseudo)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * goodPassword.
     * Password and PasswordConfirm sont les mêmes.
     * @param password Mot de passse
     * @param passwordConfirm Mot de passe
     * @return true si le password est bon
     * @throws model.ModelException erreur
     */
    public boolean goodPassword(String password, String passwordConfirm) throws ModelException {
        if (password.equals(passwordConfirm)) {
            return true;
        }
        else {
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
    

    public void setPseudo(String pseudo) throws ModelException {
        if (pseudo.equals(null)) {  
            throw new ModelException("Le champ pseudo est vide");
        }
        else {
            this.pseudo = pseudo;
        }
    }

    public void setGender(String gender) {
        if (gender.equals("fermier")){
            this.gender = "/assets/img/user/farmer_man.jpg";
        } 
        else {
            this.gender = "/assets/img/user/farmer_woman.jpg";
        }
    }

    public void setPassword(String password) throws ModelException {
        if (password.equals(null)){
            throw new ModelException("Le champ mot de passe est vide");
        }
        else {
            this.password = password;
        }
    }
    
    public void setPasswordConfirm(String passwordConfirm) throws ModelException {
        if (passwordConfirm.equals(null)){
            throw new ModelException("Le champ confirmation de mot de passe est vide");
        }
        else {
            this.passwordConfirm = passwordConfirm;
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Débloque une plante dans la boutique.
     * @param plant PlantVarietyEnum
     */
    public void addPlantUnlock(PlantVarietyEnum plant) {
        this.plantUnlock.add(plant);
    }
        
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
     * Ajoute la plante dans l'inventaire
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
     * @param variety variété de la plante
     * @param qty quantité de la plante dans l'inventaire
     */
    public void changeQtyStock(PlantVarietyEnum variety, int qty) {
        this.inventory.replace(variety, qty);
    }
    
    /**
     * La plante est-elle dans l'inventaire ?
     * @param variety variété de la plante
     * @return True si la plante est dans l'inventaire, false sinon
     */
    public boolean stockContainPlant (PlantVarietyEnum variety){
        return this.inventory.containsKey(variety);
    }
    
    /**
     * Suprime la plante de l'inventaire.
     * @param variety plante à supprimer
     */
    public void removePlantStock (PlantVarietyEnum variety){
        this.inventory.remove(variety);
    }
}
