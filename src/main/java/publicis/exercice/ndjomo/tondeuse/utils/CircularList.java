package publicis.exercice.ndjomo.tondeuse.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Liste circulaire
 * Permet d'effectuer les rotation à 90° de la tondeuse dans la liste ['W','N','E','S']
 * @param <E>
 */
public class CircularList<E> extends ArrayList<E> {

    public CircularList(List<E> list) {
        super.addAll(list);
    }

    /**
     * Recupération générique d'un élément dans une liste
     * exemple : pour size() = 4
     *      * si index = 2  alors i = (4 + 2) % 4 = 2
     *      * si index = 4  alors i = (4 + 4) % 4 = 0
     *      * si index = -1 alors i = (4 - 1) % 4 = 3
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return super.get((size() + index) % size());
    }
}