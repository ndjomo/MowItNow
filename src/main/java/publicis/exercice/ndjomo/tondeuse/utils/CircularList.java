package publicis.exercice.ndjomo.tondeuse.utils;

import java.util.ArrayList;

/**
 * Liste circulaire
 * Permet d'effectuer les rotation à 90° de la tondeuse
 * @param <E>
 */
public class CircularList<E> extends ArrayList<E> {

    @Override
    public E get(int index) {
        return super.get(index % size());
    }
}