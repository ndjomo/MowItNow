package publicis.exercice.ndjomo.tondeuse.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;

/**
 * Implémentation d'un terrain rectangulaire
 */
@Component
@Getter
public class RectangularShape implements Form<Coordinate> {

    /**
     * Coordonnées courant de la tondeuse
     */
    private Coordinate currentCoodinat;
    /**
     * Coordonnées du coin supérieur droit du terrain
     */
    private Coordinate cornerCoodinate;

    /**
     * Initialisation à partir d'une chaine
     * @param locate
     * @throws Exception
     */
    @Override
    public void init (String locate) throws Exception {
        this.currentCoodinat = new Coordinate(locate);
    }
    /**
     * Faire bouger la tondeuse
     * @param movement
     * @return
     */
    @Override
    public void move(char movement, Coordinate cornerCoodinate) throws Exception {
        currentCoodinat.move(movement, cornerCoodinate);
    }

    /**
     * Fixer la bordure supérieur droite
     * @param string
     */
    @Override
    public void limit(String string) throws Exception {
        cornerCoodinate = new Coordinate(string);
    }

    /**
     * Comparait deux position sur la forme (gestion des collisions)
     * @param c1
     * @param c2
     * @return
     */
    @Override
    public boolean isEquals(Coordinate c1, Coordinate c2) {
        if(c1.getX() == c2.getX() && c1.getY() == c2.getY()) return true;
        return false;
    }

    @Override
    public void locate() {
        System.out.println(currentCoodinat.toString());
    }

    /**
     * Marcher sur un rectange
     * @param instruction
     */
    @Override
    public void walk(String instruction) throws Exception {
        char[] ch = instruction.toCharArray();
        for(char c : ch) {
            currentCoodinat.move(c, cornerCoodinate);
        }
    }
}
