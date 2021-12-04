package publicis.exercice.ndjomo.tondeuse.domain.abstracts;

/**
 * Définition abstraite du type de surfaces où travail la tondeuse
 * T est le système de localisation
 * @param <T>
 */
public interface Form <T> {


    /**
     * Construit une position à partir d'une chaine
     * @param locate
     * @return
     */
    public void init(String locate) throws Exception;

    /**
     * Déplacement de la tondeuse
     *
     * @param movement type de mouvenemt à effectuer
     * @param location La limite de la surface
     */
    public void move(char movement, T location) throws Exception;

    /**
     * Fixe les limites de la forme
     * @param string
     */
    public void limit(String string)  throws Exception;

    /**
     * Comparaison de deux position
     * @param location1
     * @param location2
     * @return
     */
    public boolean isEquals(T location1, T location2);

    /**
     * Affichage d'une position
     * @return
     */
    public String locate();

    /**
     * Parcourir la forme
     * @param instruction
     */
    public void walk(String instruction) throws Exception;

}
