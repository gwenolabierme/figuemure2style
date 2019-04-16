package model.stylisticDevice;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public class StylisticDevice  implements Serializable{
    /**
     * Type de figure de style du fichier.
     */
    protected final StylisticDeviceEnum sdType;
    
    protected final String sentence;
    
    protected final String author;
    
    protected final String oeuvre;

    public StylisticDevice(StylisticDeviceEnum sdType, String sentence) {
        this.sdType = sdType;
        this.sentence = sentence;
        this.author = "Anonyme";
        this.oeuvre = "inconnue";
    }

    
    public StylisticDevice(StylisticDeviceEnum sdType, String sentence, String author) {
        this.sdType = sdType;
        this.sentence = sentence;
        this.author = author;
        this.oeuvre = "inconnue";
    }
    
    public StylisticDevice(StylisticDeviceEnum sdType, String sentence,
            String author, String oeuvre) {
        this.sdType = sdType;
        this.sentence = sentence;
        this.author = author;
        this.oeuvre = oeuvre;
    }

    public StylisticDeviceEnum getSdType() {
        return sdType;
    }

    public String getSentence() {
        return sentence;
    }

    public String getAuthor() {
        return author;
    }

    public String getOeuvre() {
        return oeuvre;
    }
    
    @Override
    public String toString() {
        return "\"" + this.sentence + "\", " + this.author + ", " + this.oeuvre;
    }
    
}
