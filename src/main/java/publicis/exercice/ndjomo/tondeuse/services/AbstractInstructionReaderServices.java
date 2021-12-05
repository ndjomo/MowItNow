package publicis.exercice.ndjomo.tondeuse.services;

import java.util.List;

/**
 * Définition abstraite de la source de données des instruction pouvant être traitées
 * @param <E>
 * @param <T>
 */
public interface AbstractInstructionReaderServices<E> {

    public List<String> read(E e) throws Exception;

}