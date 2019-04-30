package model.user;

import java.util.HashMap;
import java.util.Map;
import model.ModelException;
import model.bd.BDFile;

/**
 * Utilisateur.
 */
public class User {
    private String pseudo;
    private String gender;
    private String password;
    private String passwordConfirm;
    private int score;
    
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
        }
    }
    

    /**
     * getUser.
     * Recupere l'utilisateur dans les fichiers de BD user.
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
            this.score = Integer.parseInt( (String) mapUser.get("score"));
        }
        else {
            throw new ModelException("Le mot de passe ne correspond pas");
        }
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
    
    /**
     * isUserExist.
     * Fichier BD user existe.
     * @param pseudo Pseudo de l'utilisateur
     * @return True si le fichier exist
     */
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
     * @param passwordConfirm Mot de passe de confirmation
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
        
}
