package publicis.exercice.ndjomo.tondeuse.services;

import java.io.IOException;
import java.util.List;

/**
 * Archive un programme dejà exécuté
 */
public interface AbstractArchiveProgram<T, U> {
    public void archiv(T source, U target) throws Exception;
}
