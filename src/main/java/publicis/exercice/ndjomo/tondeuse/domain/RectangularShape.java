package publicis.exercice.ndjomo.tondeuse.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;

/**
 * Implémentation d'un terrain rectangulaire
 */
@Component
public class RectangularShape implements Form<Coordinate> {

    /**
     * Coordonnées courant de la tondeuse
     */
    private Coordinate currentCoodinat;
    /**
     * Coordonnées du coin supérieur droit du terrain
     */
    private Coordinate cornerCoodinate;

    @Override
    public void init(Coordinate currentCoodinat) {
        this.currentCoodinat = currentCoodinat;
    }

    /**
     * Faire bouger la tondeuse
     * @param movement
     * @return
     */
    @Override
    public void move(char movement, Coordinate cornerCoodinate) {
        currentCoodinat.move(movement, cornerCoodinate);
    }

    @Override
    public void limit(Coordinate cornerCoodinate) {
        this.cornerCoodinate = cornerCoodinate;
    }

    @Override
    public boolean isEquals(Coordinate c1, Coordinate c2) {
        if(c1.getX() == c2.getX() && c1.getY() == c2.getY()) return true;
        return false;
    }
}
