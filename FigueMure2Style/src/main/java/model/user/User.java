package model.user;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ModelException;
import model.bd.BDFile;
import model.plant.Carotte;
import model.plant.Figue;
import model.plant.Mure;
import model.plant.Patate;
import model.plant.Plant;
import model.plant.PlantVarietyEnum;
import model.plant.Pomme;
import model.plant.Tomate;

/**
 * Utilisateur.
 */
public class User {

    private String pseudo;
    private String gender;
    private String password;
    private String passwordConfirm;
    private int score;
    private double money;
    private boolean didacticiel;
    
    private EnumSet<PlantVarietyEnum> plantUnlock;
    private HashMap<PlantVarietyEnum, Integer> inventory;
    /**
     * Données (victoire, défaites, ratio) pour chaque plante débloquée
     */
    private HashMap<PlantVarietyEnum, DataPlantRatio> dataSucces;

    // Listes de données : Fuits et légumes
    private final Plant carotte = new Carotte();
    private final Plant figue = new Figue();
    private final Plant mure = new Mure();
    private final Plant patate = new Patate();
    private final Plant pomme = new Pomme();
    private final Plant tomate = new Tomate();

    private final List<String> listNames = Arrays.asList(carotte.getName().toString(), figue.getName().toString(), mure.getName().toString(), patate.getName().toString(), pomme.getName().toString(), tomate.getName().toString());

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
        this.pseudo = pseudo;
        if (gender.equals("fermier")) {
            this.gender = "/assets/img/user/farmer_man.jpg";
        } else {
            this.gender = "/assets/img/user/farmer_woman.jpg";
        }
        this.score = 0;
        this.money = 100;
        this.didacticiel = true;

        // Creation d'un fichier de BD user
        Map<String, String> map = new HashMap<>();
        map.put("pseudo", this.pseudo);
        map.put("gender", this.gender);
        map.put("score", Integer.toString(this.score));
        map.put("money", String.valueOf(this.money));
        map.put("didacticiel", Boolean.toString(this.didacticiel));

        // Légumes débloqués
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
        initPlantUnlock();
        map.put("plantUnlock", this.plantUnlock.toString());

        // Inventaire
        inventory = new HashMap<>();
        initStock();
        map.put("PlantVarietyEnum.CAROTTE", Integer.toString(inventory.get(PlantVarietyEnum.CAROTTE)));
        map.put("PlantVarietyEnum.FIGUE", Integer.toString(inventory.get(PlantVarietyEnum.FIGUE)));
        map.put("PlantVarietyEnum.MURE", Integer.toString(inventory.get(PlantVarietyEnum.MURE)));
        map.put("PlantVarietyEnum.PATATE", Integer.toString(inventory.get(PlantVarietyEnum.PATATE)));
        map.put("PlantVarietyEnum.POMME", Integer.toString(inventory.get(PlantVarietyEnum.POMME)));
        map.put("PlantVarietyEnum.TOMATE", Integer.toString(inventory.get(PlantVarietyEnum.TOMATE)));

        // Ratios
        dataSucces = new HashMap<>();
        initRatio();
        map.put("PlantVarietyEnum.CAROTTE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getNbVictory()));
        map.put("PlantVarietyEnum.CAROTTE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getNbDefeat()));
        map.put("PlantVarietyEnum.CAROTTE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getRatio()));
        map.put("PlantVarietyEnum.FIGUE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getNbVictory()));
        map.put("PlantVarietyEnum.FIGUE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getNbDefeat()));
        map.put("PlantVarietyEnum.FIGUE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getRatio()));
        map.put("PlantVarietyEnum.MURE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getNbVictory()));
        map.put("PlantVarietyEnum.MURE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getNbDefeat()));
        map.put("PlantVarietyEnum.MURE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getRatio()));
        map.put("PlantVarietyEnum.PATATE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getNbVictory()));
        map.put("PlantVarietyEnum.PATATE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getNbDefeat()));
        map.put("PlantVarietyEnum.PATATE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getRatio()));
        map.put("PlantVarietyEnum.POMME.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getNbVictory()));
        map.put("PlantVarietyEnum.POMME.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getNbDefeat()));
        map.put("PlantVarietyEnum.POMME.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getRatio()));
        map.put("PlantVarietyEnum.TOMATE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getNbVictory()));
        map.put("PlantVarietyEnum.TOMATE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getNbDefeat()));
        map.put("PlantVarietyEnum.TOMATE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getRatio()));

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
            this.pseudo = pseudo;
            if (gender.equals("fermier")) {
                this.gender = "/assets/img/user/farmer_man.jpg";
            } else {
                this.gender = "/assets/img/user/farmer_woman.jpg";
            }
            this.password = password;
            this.passwordConfirm = passwordConfirm;
            this.score = 0;
            this.money = 100;
            this.didacticiel = true;

            // Creation d'un fichier de BD user
            Map<String, String> map = new HashMap<>();
            map.put("pseudo", this.pseudo);
            map.put("gender", this.gender);
            map.put("password", this.password);
            map.put("passwordConfirm", this.passwordConfirm);
            map.put("score", Integer.toString(this.score));
            map.put("money", String.valueOf(this.money));
            map.put("didacticiel", Boolean.toString(this.didacticiel));

            // Légumes débloqués
            plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);
            initPlantUnlock();
            map.put("plantUnlock", this.plantUnlock.toString());

            // Inventaire
            inventory = new HashMap<>();
            initStock();
            map.put("PlantVarietyEnum.CAROTTE", Integer.toString(inventory.get(PlantVarietyEnum.CAROTTE)));
            map.put("PlantVarietyEnum.FIGUE", Integer.toString(inventory.get(PlantVarietyEnum.FIGUE)));
            map.put("PlantVarietyEnum.MURE", Integer.toString(inventory.get(PlantVarietyEnum.MURE)));
            map.put("PlantVarietyEnum.PATATE", Integer.toString(inventory.get(PlantVarietyEnum.PATATE)));
            map.put("PlantVarietyEnum.POMME", Integer.toString(inventory.get(PlantVarietyEnum.POMME)));
            map.put("PlantVarietyEnum.TOMATE", Integer.toString(inventory.get(PlantVarietyEnum.TOMATE)));

            // Ratios
            dataSucces = new HashMap<>();
            initRatio();
            map.put("PlantVarietyEnum.CAROTTE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getNbVictory()));
            map.put("PlantVarietyEnum.CAROTTE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getNbDefeat()));
            map.put("PlantVarietyEnum.CAROTTE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.CAROTTE).getRatio()));
            map.put("PlantVarietyEnum.FIGUE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getNbVictory()));
            map.put("PlantVarietyEnum.FIGUE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getNbDefeat()));
            map.put("PlantVarietyEnum.FIGUE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.FIGUE).getRatio()));
            map.put("PlantVarietyEnum.MURE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getNbVictory()));
            map.put("PlantVarietyEnum.MURE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getNbDefeat()));
            map.put("PlantVarietyEnum.MURE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.MURE).getRatio()));
            map.put("PlantVarietyEnum.PATATE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getNbVictory()));
            map.put("PlantVarietyEnum.PATATE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getNbDefeat()));
            map.put("PlantVarietyEnum.PATATE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.PATATE).getRatio()));
            map.put("PlantVarietyEnum.POMME.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getNbVictory()));
            map.put("PlantVarietyEnum.POMME.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getNbDefeat()));
            map.put("PlantVarietyEnum.POMME.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.POMME).getRatio()));
            map.put("PlantVarietyEnum.TOMATE.nbVictory", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getNbVictory()));
            map.put("PlantVarietyEnum.TOMATE.nbDefeat", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getNbDefeat()));
            map.put("PlantVarietyEnum.TOMATE.ratio", String.valueOf(dataSucces.get(PlantVarietyEnum.TOMATE).getRatio()));

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
        this.money = Double.parseDouble((String) mapUser.get("money"));
        this.didacticiel = Boolean.parseBoolean((String) mapUser.get("didacticiel"));

        // Légumes débloqués
        String listPlantUnlock = (String) mapUser.get("plantUnlock");
        EnumSet<PlantVarietyEnum> listVarietyPlantUnlock = null;
        plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);

        if (listPlantUnlock.contains(listNames.get(0))) {
            addPlantUnlock(PlantVarietyEnum.CAROTTE);
        }
        if (listPlantUnlock.contains(listNames.get(1))) {
            addPlantUnlock(PlantVarietyEnum.FIGUE);
        }
        if (listPlantUnlock.contains(listNames.get(2))) {
            addPlantUnlock(PlantVarietyEnum.MURE);
        }
        if (listPlantUnlock.contains(listNames.get(3))) {
            addPlantUnlock(PlantVarietyEnum.PATATE);
        }
        if (listPlantUnlock.contains(listNames.get(4))) {
            addPlantUnlock(PlantVarietyEnum.POMME);
        }
        if (listPlantUnlock.contains(listNames.get(5))) {
            addPlantUnlock(PlantVarietyEnum.TOMATE);
        }

        // Inventaire
        String listInventory;
        inventory = new HashMap<>();
        this.inventory.put(PlantVarietyEnum.CAROTTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE")));
        this.inventory.put(PlantVarietyEnum.FIGUE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE")));
        this.inventory.put(PlantVarietyEnum.MURE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE")));
        this.inventory.put(PlantVarietyEnum.PATATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE")));
        this.inventory.put(PlantVarietyEnum.POMME, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME")));
        this.inventory.put(PlantVarietyEnum.TOMATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE")));

        // Ratios
        dataSucces = new HashMap<>();
        this.dataSucces.put(PlantVarietyEnum.CAROTTE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.CAROTTE.ratio"))));
        this.dataSucces.put(PlantVarietyEnum.FIGUE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.FIGUE.ratio"))));
        this.dataSucces.put(PlantVarietyEnum.MURE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.MURE.ratio"))));
        this.dataSucces.put(PlantVarietyEnum.PATATE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.PATATE.ratio"))));
        this.dataSucces.put(PlantVarietyEnum.POMME, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.POMME.ratio"))));
        this.dataSucces.put(PlantVarietyEnum.TOMATE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.TOMATE.ratio"))));
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
            this.money = Double.parseDouble((String) mapUser.get("money"));
            this.didacticiel = Boolean.parseBoolean((String) mapUser.get("didacticiel"));

            // Légumes débloqués
            String listPlantUnlock = (String) mapUser.get("plantUnlock");
            EnumSet<PlantVarietyEnum> listVarietyPlantUnlock = null;
            plantUnlock = EnumSet.noneOf(PlantVarietyEnum.class);

            if (listPlantUnlock.contains(listNames.get(0))) {
                addPlantUnlock(PlantVarietyEnum.CAROTTE);
            }
            if (listPlantUnlock.contains(listNames.get(1))) {
                addPlantUnlock(PlantVarietyEnum.FIGUE);
            }
            if (listPlantUnlock.contains(listNames.get(2))) {
                addPlantUnlock(PlantVarietyEnum.MURE);
            }
            if (listPlantUnlock.contains(listNames.get(3))) {
                addPlantUnlock(PlantVarietyEnum.PATATE);
            }
            if (listPlantUnlock.contains(listNames.get(4))) {
                addPlantUnlock(PlantVarietyEnum.POMME);
            }
            if (listPlantUnlock.contains(listNames.get(5))) {
                addPlantUnlock(PlantVarietyEnum.TOMATE);
            }

            // Inventaire
            String listInventory;
            this.inventory = new HashMap<>();
            this.inventory.put(PlantVarietyEnum.CAROTTE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE")));
            this.inventory.put(PlantVarietyEnum.FIGUE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE")));
            this.inventory.put(PlantVarietyEnum.MURE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE")));
            this.inventory.put(PlantVarietyEnum.PATATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE")));
            this.inventory.put(PlantVarietyEnum.POMME, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME")));
            this.inventory.put(PlantVarietyEnum.TOMATE, Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE")));

            // Ratios
            dataSucces = new HashMap<>();
            this.dataSucces.put(PlantVarietyEnum.CAROTTE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.CAROTTE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.CAROTTE.ratio"))));
            this.dataSucces.put(PlantVarietyEnum.FIGUE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.FIGUE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.FIGUE.ratio"))));
            this.dataSucces.put(PlantVarietyEnum.MURE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.MURE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.MURE.ratio"))));
            this.dataSucces.put(PlantVarietyEnum.PATATE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.PATATE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.PATATE.ratio"))));
            this.dataSucces.put(PlantVarietyEnum.POMME, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.POMME.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.POMME.ratio"))));
            this.dataSucces.put(PlantVarietyEnum.TOMATE, new DataPlantRatio(Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE.nbVictory")), Integer.parseInt((String) mapUser.get("PlantVarietyEnum.TOMATE.nbDefeat")), Double.parseDouble((String) mapUser.get("PlantVarietyEnum.TOMATE.ratio"))));
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

    public double getMoney() {
        return money;
    }

    public boolean isDidacticiel() {
        return didacticiel;
    }

    /**
     * setPseudo remplace le pseudo de l'utilisateur dans la BD.
     *
     * @param pseudo Pseudo de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setPseudo(String pseudo) throws ModelException {
        if (pseudo == null) {
            throw new ModelException("Le champ pseudo est vide");
        } else {
            this.pseudo = pseudo;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("pseudo", this.pseudo);
            f = new BDFile();
            f.newFile(pseudo, mapUser);
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
        f = new BDFile();
        f.newFile(pseudo, mapUser);
    }

    /**
     * setPassword remplace le mot de passe de l'utilisateur dans la BD.
     *
     * @param password Mot de passe de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setPassword(String password, String pseudo) throws ModelException {
        if (password == null) {
            throw new ModelException("Le champ mot de passe est vide");
        } else {
            this.password = password;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("password", this.password);
            f = new BDFile();
            f.newFile(pseudo, mapUser);
        }
    }

    /**
     * setPasswordConfirm remplace le mot de passe de confirmation de
     * l'utilisateur dans la BD.
     *
     * @param passwordConfirm Mot de passe de confirmation de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur
     * @throws model.ModelException erreur
     */
    public void setPasswordConfirm(String passwordConfirm, String pseudo) throws ModelException {
        if (passwordConfirm == null) {
            throw new ModelException("Le champ confirmation de mot de passe est vide");
        } else {
            this.passwordConfirm = passwordConfirm;
            BDFile f = new BDFile();
            Map mapUser = f.loadFile(pseudo);
            mapUser.replace("passwordConfirm", this.passwordConfirm);
            f = new BDFile();
            f.newFile(pseudo, mapUser);
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
        mapUser.replace("score", Integer.toString(this.score));
        f = new BDFile();
        f.newFile(pseudo, mapUser);
    }

    /**
     * setMoney remplace l'money de l'utilisateur dans la BD.
     * 
     * @param money Money de l'utilisateur
     * @param pseudo Pseudo de l'utilisateur
     */
    public void setMoney(double money, String pseudo) {
        this.money = money;
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        System.out.println(mapUser.get(money));
        mapUser.replace("money", String.valueOf(this.money));
        f = new BDFile();
        f.newFile(pseudo, mapUser);
        System.out.println(mapUser.get(money));
    }

    /**
     * setDidacticiel Active ou déactive le didacticiel.
     * 
     * @param pseudo Pseudo de l'utilisateur
     */
    public void setDidacticiel(String pseudo) {
        if (this.didacticiel) {
            this.didacticiel = false;
        }
        else {
            this.didacticiel = true;
        }
        
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        mapUser.replace("didacticiel", Boolean.toString(this.didacticiel));
        f = new BDFile();
        f.newFile(pseudo, mapUser);
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
    public final void initPlantUnlock() {
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
    public final void initStock() {
        this.inventory.put(PlantVarietyEnum.CAROTTE, 0);
        this.inventory.put(PlantVarietyEnum.FIGUE, 0);
        this.inventory.put(PlantVarietyEnum.MURE, 0);
        this.inventory.put(PlantVarietyEnum.PATATE, 0);
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
     * Vide le stock de la plante.
     *
     * @param variety variété de la plante
     * @param pseudo utilisateur
     */
    public void emptyQtyStock(PlantVarietyEnum variety, String pseudo) {
        this.inventory.replace(variety, 0);
        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);
        switch (variety.toString()) {
            case "carotte":
                mapUser.replace("PlantVarietyEnum.CAROTTE", Integer.toString(inventory.get(variety)));
                break;
            case "figue":
                mapUser.replace("PlantVarietyEnum.FIGUE", Integer.toString(inventory.get(variety)));
                break;
            case "mure":
                mapUser.replace("PlantVarietyEnum.MURE", Integer.toString(inventory.get(variety)));
                break;
            case "patate":
                mapUser.replace("PlantVarietyEnum.PATATE", Integer.toString(inventory.get(variety)));
                break;
            case "pomme":
                mapUser.replace("PlantVarietyEnum.POMME", Integer.toString(inventory.get(variety)));
                break;
            case "tomate":
                mapUser.replace("PlantVarietyEnum.TOMATE", Integer.toString(inventory.get(variety)));
                break;
            default:
                break;
        }
        f = new BDFile();
        f.newFile(pseudo, mapUser);
    }

    /**
     * Change la quantité de la plante dans l'inventaire.
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

    public HashMap<PlantVarietyEnum, DataPlantRatio> getDataSucces() {
        return dataSucces;
    }

    /**
     * Met a jour le ratio de la stratégie en fonction de leur nombre de
     * victoires et défaites.
     *
     * @param key figure de style concernée
     * @param pseudo utilisateur
     */
    private void updateRatios(PlantVarietyEnum key, String pseudo) {
        double ratio;

        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);

        DataPlantRatio data = this.dataSucces.get(key);
        ratio = (double) data.getNbVictory() / data.getNbDefeat();
        data.setRatio(ratio);

        mapUser.replace(key + ".ratio", String.valueOf(data.getRatio()));
        f = new BDFile();
        f.newFile(pseudo, mapUser);
    }

    /**
     * Met à jour le ratio de probabilité de la plante.
     *
     * @param key plante à mettre à jour
     * @param isSuccess True si le joueur a bien arrosé la plante, false sinon
     * @param pseudo utilisateur
     */
    public void updateDico(PlantVarietyEnum key, boolean isSuccess, String pseudo) {
        DataPlantRatio data = this.dataSucces.get(key);

        BDFile f = new BDFile();
        Map mapUser = f.loadFile(pseudo);

        if (isSuccess) {
            data.setNbVictory(data.getNbVictory() + 1);
            mapUser.replace(key + ".nbVictory", String.valueOf(data.getNbVictory()));
        } else {
            data.setNbDefeat(data.getNbDefeat() + 1);
            mapUser.replace(key + ".nbDefeat", String.valueOf(data.getNbDefeat()));
        }
        
        f = new BDFile();
        f.newFile(pseudo, mapUser);

        this.updateRatios(key, pseudo);
    }

    /**
     * Initialise les ratios à 0.
     */
    public final void initRatio() {
        this.dataSucces.put(PlantVarietyEnum.CAROTTE, new DataPlantRatio());
        this.dataSucces.put(PlantVarietyEnum.FIGUE, new DataPlantRatio());
        this.dataSucces.put(PlantVarietyEnum.MURE, new DataPlantRatio());
        this.dataSucces.put(PlantVarietyEnum.PATATE, new DataPlantRatio());
        this.dataSucces.put(PlantVarietyEnum.POMME, new DataPlantRatio());
        this.dataSucces.put(PlantVarietyEnum.TOMATE, new DataPlantRatio());
    }
}
