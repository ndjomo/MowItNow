package publicis.exercice.ndjomo.tondeuse.services;

/**
 * Archive un programme dejà exécuté
 * @param <T>
 * @param <U>
 */
public interface AbstractArchiveProgram<T, U> {
    public void archiv(T source, U target) throws Exception;
}
