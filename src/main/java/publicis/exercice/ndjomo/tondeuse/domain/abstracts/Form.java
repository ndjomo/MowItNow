package publicis.exercice.ndjomo.tondeuse.domain.abstracts;

/**
 * Définition abstraite du type de surfaces où travail la tondeuse
 * T est le système de localisation
 * @param <T>
 */
public interface Form <T> {

    /**
     * initialise la forme
     * @param location
     */
    public void init(T location);


    /**
     * Déplacement de la tondeuse
     *
     * @param movement type de mouvenemt à effectuer
     * @param location La limite de la surface
     */
    public void move(char movement, T location);

    /**
     * Fixe les limites de la forme
     * @param location
     */
    public void limit(T location);

    /**
     * Comparaison de deux position
     * @param location1
     * @param location2
     * @return
     */
    public boolean isEquals(T location1, T location2);
}
