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

    public StylisticDevice(StylisticDeviceEnum sdType, String sentence) {
        this.sdType = sdType;
        this.sentence = sentence;
        this.author = "Anonyme";
    }

    
    public StylisticDevice(StylisticDeviceEnum sdType, String sentence, String author) {
        this.sdType = sdType;
        this.sentence = sentence;
        this.author = author;
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
    
    
}
