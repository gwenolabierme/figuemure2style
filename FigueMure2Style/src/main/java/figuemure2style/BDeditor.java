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
        createAccumulation();
        printFile(StylisticDeviceEnum.ACCUMULATION);
        
        createAllegorie();
        printFile(StylisticDeviceEnum.ALLEGORIE);
        
        createAntiphrase();
        printFile(StylisticDeviceEnum.ANTIPHRASE);
        
        createCalembour();
        printFile(StylisticDeviceEnum.CALEMBOUR);
        
        createChiasme();
        printFile(StylisticDeviceEnum.CHIASME);
        
        createComparaison();
        printFile(StylisticDeviceEnum.COMPARAISON);
        
        createEuphemisme();
        printFile(StylisticDeviceEnum.EUPHEMISME);
       
        createHyperbole();
        printFile(StylisticDeviceEnum.HYPERBOLE);
        
        createMetaphore();
        printFile(StylisticDeviceEnum.METAPHORE);
        
        createMetonymie();
        printFile(StylisticDeviceEnum.METONYMIE);
        
        createOxymore();
        printFile(StylisticDeviceEnum.OXYMORE);
        
        createPeriphrase();
        printFile(StylisticDeviceEnum.PERIPHRASE);
        
        createPersonnification();
        printFile(StylisticDeviceEnum.PERSONNIFICATION);
    }
    
    public static void createAccumulation() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.ACCUMULATION);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Au ciel, aux vents, aux rocs, à la nuit, à la brume, \n"
                            + "Le sinistre océan jette son noir sanglot.",
                    "Hugo", "Légende des siècles, Les Pauvres gens");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "C’est un roc ! c’est un pic ! c’est un cap ! \nQue dis-je, "
                            + "c’est un cap ? … c’est une péninsule !",
                    "Rostand", "Cyrano de Bergerac");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ACCUMULATION,
                    "Au ciel, aux vents, aux rocs, à la nuit, à la brume,\n"
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
            System.err.println("***** Problème d'enregistrement dans accumulation *****");
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
                    "Je veux peindre la France une mère affligée, \nQui est, "
                            + "entre ses bras, de deux enfants chargée.",
                    "Agrippa d’Aubigné", "Les Tragiques");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "Bon chevalier masqué qui chevauche en silence, \nLe Malheur "
                            + "a percé mon vieux cœur de sa lance.",
                    "Verlaine", "Sagesses");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ALLEGORIE,
                    "Mon beau navire ô ma mémoire \nAvons-nous assez navigué \n"
                            + "Dans une onde mauvaise à boire",
                    "Apollinaire", "La Chanson du mal aimé");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans allégorie *****");
        }
        
        file.save();
    }
    
    public static void createAntiphrase() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.ANTIPHRASE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.ANTIPHRASE,
                    "La [torture] est une invention merveilleuse et tout à fait "
                            + "sûre pour perdre un innocent qui a la complexion "
                            + "faible, et sauver un coupable qui est né robuste ",
                    "La Bruyère", "Les Caractères");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ANTIPHRASE,
                    "Quel crétin ! Je n'ai jamais vu quelqu'un d'aussi intélligent !",
                    "Jérémy");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ANTIPHRASE,
                    "Tous étaient prêts à donner 30€, sauf Jean, qui ne voulait "
                            + "pas céder plus de 5€. « Quelle générosité ! », lui dit Nicolas.",
                    "laculturegenerale.com");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ANTIPHRASE,
                    "La pluie tombait depuis des heures. J'ai toujours aimer ces "
                            + "jours de beau temps ou je passe mes journées à "
                            + "m'ennuyer en attendant le soleil. ",
                    "Jérémy");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.ANTIPHRASE,
                    "Pendant son absence, Oggi, son chat, était monté sur la table, "
                            + "renversant le plat et la vaiselle. En rentrant, Victor s'exclama :"
                            + "« Eh bien ! C'est du joli ! »",
                    "Jérémy");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans antiphrase *****");
        }
        
        file.save();
    }
    
    public static void createCalembour() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.CALEMBOUR);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Chassez le naturiste, il revient au bungalow.",
                    "Jean-Paul Gousset");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Le roi de Perse habite, inquiet, redouté, \n"
                            + "En hiver Ispahan et Tiflis en été ;",
                    "Hugo", "Légende des siècles");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Je suis romaine, hélas ! Puisque mon époux l’est ;",
                    "Horace", "Sabine");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Travailler plus pour gagner plus, mais si tu végètes, t’as rien.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Rien n’est plus détestable qu’un nabot minable.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Je vous remercie pour votre bon thé.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "La faim justifie les moyens.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Les mots rendent les cris vains.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Qui mange un chien chihuahua.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Les bricoleurs du dimanche en ont marre tôt.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Élisez le président et lisez ensuite les gros titres.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "En s’asseyant sur une chaise inconfortable, on a le dos scié.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "A t-on déjà vu un carreleur déposer une plinthe au commissariat ?");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Paradoxalement, pour être dans les normes, il faut rester mince.");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CALEMBOUR,
                    "Le veau qu’a bu l’air.");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans calembour *****");
        }
        
        file.save();
    }
    
    public static void createChiasme() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.CHIASME);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.CHIASME,
                    "Un roi chantait en bas, en haut mourait un Dieu.",
                    "Hugo", "La légende des siècles, Booz endormi");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CHIASME,
                    "Bonnet blanc et blanc bonnet.",
                    "laculturegenerale.com");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CHIASME,
                    "Joyeux la nuit, le jour triste je suis. \nJ’ay en dormant "
                            + "ce, qu’en veillant poursuis",
                    "Du Bellay", "Du Bellay");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CHIASME,
                    "Qui craint de souffrir, il souffre desjà de ce qu’il craint.",
                    "Montaigne", "Essais");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.CHIASME,
                    "Vous êtes aujourd’hui ce qu’autrefois je fus.",
                    "Corneille", "Le Cid");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans chiasme *****");
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
                    "Le Poète est semblable au prince des nuées \nQui hante la "
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
                    "Hugo", "La légende des siècles, Booz endormi");
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
                    "Mon esprit est pareil à la tour qui succombe \nSous les "
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
    
    public static void createEuphemisme() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.EUPHEMISME);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.EUPHEMISME,
                    "L’Époux d’une jeune Beauté \nPartait pour l’autre monde",
                    "La Fontaine", "Fables, La Jeune Veuve");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.EUPHEMISME,
                    "Elle a vécu, Myrto, la jeune Tarentine",
                    "Chénier", "La Jeune Tarentine");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.EUPHEMISME,
                    "Il me fait des déclarations et m’embrasse, et me menace "
                            + "de… de… son autorité.",
                    "Maupassant", "La Paix du ménage");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.EUPHEMISME,
                    "Son regard est pareil au regard des statues, \nEt, pour sa voix, "
                            + "lointaine, et calme, et grave, elle a \nL’inflexion "
                            + "des voix chères qui se sont tues.",
                    "Verlaine", "Mon rêve familier");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.EUPHEMISME,
                    "Les parfums ne font pas frissonner sa narine ; \nIl dort "
                            + "dans le soleil, la main sur sa poitrine, \nTranquille. "
                            + "Il a deux trous rouges au côté droit.",
                    "Rimbaud", "Le dormeur du val");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans euphemisme *****");
        }
        
        file.save();
    }
    
    public static void createHyperbole() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.HYPERBOLE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.HYPERBOLE,
                    "J'ai pris un zéro au contrôle de maths ; je vais me faire "
                            + "tuer par ma mère en rentrant !",
                    "Jérémy");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.HYPERBOLE,
                    "– J’ai vu, dit-il, un chou plus grand qu’une maison. \n– Et moi, "
                            + "dit l’autre, un pot aussi grand qu’une Eglise.",
                    "La Fontaine", "Fables, Le Dépositaire infidèle");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.HYPERBOLE,
                    "Ses moindres actions lui semblent des miracles, \nEt tous "
                            + "les mots qu’il dit, sont pour lui des oracles.",
                    "Molière", "Tartuffe");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.HYPERBOLE,
                    "Console-moi ce soir, je me meurs d’espérance.",
                    "Musset", "La Nuit de mai");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.HYPERBOLE,
                    "Serais-je donc le seul lâche sur la terre ?",
                    "Céline", "Voyage au bout de la nuit");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans hyperbole *****");
        }
        
        file.save();
    }
    
    public static void createMetaphore() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.METAPHORE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.METAPHORE,
                    "Bonjour, mon trésor !",
                    "laculturegenerale.com");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METAPHORE,
                    "Tout l’automne à la fin n’est plus qu’une tisane froide.",
                    "Ponge", "La fin de l’automne");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METAPHORE,
                    "Je parle un langage de décombres où voisinent les soleils et les plâtras.",
                    "Aragon", "Traité du style");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METAPHORE,
                    "Je me suis baigné dans le poème de la mer.",
                    "Rimbaud", "Le Bateau ivre");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METAPHORE,
                    "Un gros serpent de fumée noire.",
                    "Maupassant", "La Peur");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans métaphore *****");
        }
        
        file.save();
    }
    
    public static void createMetonymie() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.METONYMIE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.METONYMIE,
                    "Ah ! quelle cruauté qui tout en jour tue \nLe père par "
                            + "le fer, la fille par la vue !",
                    "Corneille", "Le Cid");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METONYMIE,
                    "Paris a froid, Paris a faim",
                    "Éluard", "Courage");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METONYMIE,
                    "Rome à ne vous plus voir m’a-t-elle condamnée ?",
                    "Racine", "Britannicus");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METONYMIE,
                    "Le phallus en ce siècle devient doctrinaire.",
                    "Michaux", "Face aux verrous");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.METONYMIE,
                    "Avez-vous du feu ?",
                    "laculturegenerale.com");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans metonymie *****");
        }
        
        file.save();
    }
    
    public static void createOxymore() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.OXYMORE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.OXYMORE,
                    "Cette obscure clarté qui tombe des étoiles",
                    "Corneille", "Le Cid");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.OXYMORE,
                    "Par ma foi, voilà un beau jeune vieillard pour quatre-vingt-dix ans !",
                    "Molière", "Le Malade imaginaire");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.OXYMORE,
                    "Candide, […], se cacha du mieux qu’il put pendant cette boucherie héroïque.",
                    "Voltaire", "Candide");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.OXYMORE,
                    "Éphémère immortel",
                    "Valéry", "Charmes");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.OXYMORE,
                    "Le superflu, chose très nécessaire",
                    "Voltaire", "Le Mondain");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans oxymore *****");
        }
        
        file.save();
    }
    
    public static void createPeriphrase() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.PERIPHRASE);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.PERIPHRASE,
                    "Le bateau venait d'accoster ; les colons allaient enfin "
                            + "pouvoir découvrir le Nouveau Monde",
                    "Jérémy");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERIPHRASE,
                    "C’était l’heure tranquille où les lions vont boire",
                    "Hugo", "La Légende des siècles, Booz endormi");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERIPHRASE,
                    "Ce voyageur ailé",
                    "Baudelaire", "Fleurs du mal, L’Albatros");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERIPHRASE,
                    "Cela faisait déjà bien longtemps qu'il maîtrisait la langue de Shakespeare.",
                    "Jérémy");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERIPHRASE,
                    "Il poussa un puissant rugissement, signifiant qu'il "
                            + "était toujours le roi des animaux",
                    "Jérémy");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans periphrase *****");
        }
        
        file.save();
    }
    
    public static void createPersonnification() {
        FileStylisticD file = new FileStylisticD(StylisticDeviceEnum.PERSONNIFICATION);
        StylisticDevice sd;
        
        try {
            sd = new StylisticDevice(StylisticDeviceEnum.PERSONNIFICATION,
                    "Le mistral était en colère, et les éclats de sa grande voix "
                            + "m’ont tenu éveillé jusqu’au matin.",
                    "Daudet", "Lettres de mon moulin, Le phare des Sanguinaires");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERSONNIFICATION,
                    "Avec quelle rigueur, destin, tu me poursuis ! \nJe ne sais "
                            + "où je vais, je ne sais où je suis.",
                    "Racine", "Phèdre");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERSONNIFICATION,
                    "L’enfance a des manières de voir, de penser, de sentir qui "
                            + "lui sont propres ; rien n’est moins sensé que "
                            + "d’y vouloir substituer les nôtres.",
                    "Rousseau", "Julie ou la Nouvelle Héloïse");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERSONNIFICATION,
                    "J’en doute : ces flots, ces vents, cette solitude qui furent "
                            + "mes premiers maîtres, convenaient peut-être mieux "
                            + "à mes dispositions natives.",
                    "Chateaubriand", "Mémoires d’outre-tombe");
            file.addStylisiticD(sd);
            
            sd = new StylisticDevice(StylisticDeviceEnum.PERSONNIFICATION,
                    "Le crépuscule ami s’endort dans la vallée.",
                    "Vigny", "La Maison du berger");
            file.addStylisiticD(sd);
            
        } catch (DifferentsStylisticDeviceType ex) {
            Logger.getLogger(BDeditor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("***** Problème d'enregistrement dans personnification *****");
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
        System.out.println("");
    }
}
