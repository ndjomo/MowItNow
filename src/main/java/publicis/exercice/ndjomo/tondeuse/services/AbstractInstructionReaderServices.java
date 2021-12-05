package publicis.exercice.ndjomo.tondeuse.services;

/**
 * Définition abstraite de la source de données des instruction pouvant être traitées
 * @param <E>
 * @param <T>
 */
public interface AbstractInstructionReaderServices<E, T> {

    T read(E e) throws Exception;

}
