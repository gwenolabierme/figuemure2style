package view.plant;

/**
 *
 * @author jeremy
 */
public enum GrowthStateEnum implements Comparable<GrowthStateEnum> {
    SPROUT("sprout"),
    MEDIUM("medium"),
    FINAL("final");

    private final String status;

    /**
     * Constructeur de GrowthStateEnum.
     *
     * @param Valeur de la variété de plante
     */
    GrowthStateEnum(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
