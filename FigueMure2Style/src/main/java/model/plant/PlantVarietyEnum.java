package model.plant;

/**
 *
 * @author jeremy
 */
public enum PlantVarietyEnum implements Comparable<PlantVarietyEnum> {
    CAROTTE("carotte"),
    FIGUE("figue"),
    MURE("mure"),
    PATATTE("pattate"),
    POMME("pomme"),
    TOMATE("tomate");

    private final String status;

    /**
     * Constructeur de PlantVariety.
     *
     * @param Valeur de la variété de plante
     */
    PlantVarietyEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
