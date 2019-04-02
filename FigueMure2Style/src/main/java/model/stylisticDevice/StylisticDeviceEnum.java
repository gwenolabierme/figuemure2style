package model.stylisticDevice;

/**
 *
 * @author jeremy
 */
public enum StylisticDeviceEnum implements Comparable<StylisticDeviceEnum> {
    ACCUMULATION("accumulation"),
    ALLEGORIE("allegorie"),
    ANTIPHRASE("antiphrase"),
    CALEMBOUR("calembour"),
    CHIASME("chiasme"),
    COMPARAISON("comparaison"),
    EUPHEMISME("euphemisme"),
    HYPERBOLE("hyperbole"),
    METAPHORE("metaphore"),
    METONYMIE("metonymie"),
    OXYMORE("oxymore"),
    PERIPHRASE("periphrase"),
    PERSONNIFICATION("personnification");

    private final String status;

    /**
     * Constructeur de StylisticDeviceEnum.
     *
     * @param Valeur de la figure de style
     */
    StylisticDeviceEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
