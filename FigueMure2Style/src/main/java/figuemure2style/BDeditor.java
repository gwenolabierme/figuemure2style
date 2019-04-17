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
        /*createAccumulation();
        printFile(StylisticDeviceEnum.ACCUMULATION);*/
        
        createAllegorie();
        printFile(StylisticDeviceEnum.ALLEGORIE);
        
        /*createComparaison();
        printFile(StylisticDeviceEnum.COMPARAISON);*/
    }
    
    public static void createAccumulation() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.ACCUMULATION);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Au ciel, aux vents, aux rocs, à la nuit, à la brume, / "
                            + "Le sinistre océan jette son noir sanglot.",
                    "Hugo", "Légende des siècles, Les Pauvres gens");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "C’est un roc ! c’est un pic ! c’est un cap ! / Que dis-je, "
                            + "c’est un cap ? … c’est une péninsule !",
                    "Rostand", "Cyrano de Bergerac");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Au ciel, aux vents, aux rocs, à la nuit, à la brume, /"
                            + "Le sinistre océan jette son noir sanglot.",
                    "Hugo", "Légende des siècles, Les Pauvres gens");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Don Fernand, dans sa province, est oisif, ignorant, médisant,"
                            + " querelleux, fourbe, intempérant, impertinent.",
                    "La bruyère", "Les Caractères, De l’homme");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Devant eux, sur de petites tables carrées ou rondes, des "
                            + "verres contenaient des liquides rouges, jaunes, "
                            + "verts, bruns, de toutes les nuances ;",
                    "Maupassant", "Bel ami");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans comparaison *****");
        }
        
        file.save();
    }
    
    public static void createAllegorie() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.ALLEGORIE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "L’Angleterre est un vaisseau. Notre île en a la forme : la "
                            + "proue tournée au nord, elle est comme à l’ancre au "
                            + "milieu des mers, surveillant le continent.",
                    "Chatterton", "Chatterton");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "La rêverie…une jeune femme merveilleuse, imprévisible, tendre, "
                            + "énigmatique, provocante, à qui je ne demande jamais "
                            + "compte de ses fugues.",
                    "Breton", "Farouche à quatre feuilles");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "Je veux peindre la France une mère affligée, / Qui est, "
                            + "entre ses bras, de deux enfants chargée.",
                    "Agrippa d’Aubigné", "Les Tragiques");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "Bon chevalier masqué qui chevauche en silence, / Le Malheur "
                            + "a percé mon vieux cœur de sa lance.",
                    "Verlaine", "Sagesses");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "Mon beau navire ô ma mémoire / Avons-nous assez navigué / "
                            + "Dans une onde mauvaise à boire",
                    "Apollinaire", "La Chanson du mal aimé");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans comparaison *****");
        }
        
        file.save();
    }
    
    public static void createComparaison() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.COMPARAISON);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Un petit baiser, comme une folle araignée, Te courra par le cou…",
                    "Rimbaud", "Rêvé pour l’hiver");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "L’absence diminue les médiocres passions, et augmente les grandes, "
                            + "comme le vent éteint les bougies, et allume le feu.",
                    "La Rochefoucauld", "Maximes");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Le Poète est semblable au prince des nuées / Qui hante la "
                            + "tempête et se rit de l’archer […]",
                    "Baudelaire", "L'Albatros");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Elle ressemblait aux femmes des livres romantiques. Il n’aurait "
                            + "voulu rien ajouter, rien retrancher à sa personne.",
                    "Flaubert", "L’Éducation sentimentale");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "De même que le vent qui souffle avec violence disperse un monceau "
                            + "de pailles sèches qu’il emporte çà et là, de même la mer"
                            + " dispersa les longues poutres",
                    "Homère", "L’Odyssée");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Sa barbe était d’argent comme un ruisseau d’avril",
                    "Hugo", "La Légende des siècles");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "La terre est bleue comme une orange",
                    "Éluard", "L’amour la poésie");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "La mer est si bleue qu’il n’y a que le sang qui soit plus rouge.",
                    "Françoise Soublin", "Sur une règle rhétorique d’effacement");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "Mon esprit est pareil à la tour qui succombe / Sous les "
                            + "coups du bélier infatigable et lourd.",
                    "Baudelaire", "Chant D'Automne");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.COMPARAISON,
                    "On était pareil à un chat qui s’est glissé dans le buffet "
                            + "pour manger une sauce.",
                    "Romains", "Les Copains");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans comparaison *****");
        }
        
        file.save();
    }
    
    public static void printFile(StylisticDeviceEnum sd) {
        FileStylisticD file =  FileStylisticD.load(sd);
        
        System.out.println("*** " + sd.toString());
        
        StylisticDevice[] sdTab = file.get();
        for(int i = 0; i< sdTab.length; ++i) {
            System.out.println((i + 1) + "- " + sdTab[i]);
        }
    }
}
