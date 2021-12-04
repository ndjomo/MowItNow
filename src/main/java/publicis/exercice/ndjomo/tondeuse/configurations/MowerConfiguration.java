package publicis.exercice.ndjomo.tondeuse.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import publicis.exercice.ndjomo.tondeuse.domain.RectangularShape;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;
import publicis.exercice.ndjomo.tondeuse.services.implementations.FlatFileInstructionReaderImpl;

/**
 * Gestion des implémentations
 */
@Configuration
public class MowerConfiguration {

    /**
     * Composant de gestion des surfaces rectengulaire
     * @return
     */
    @Bean
    public Form grassField() {
        return new RectangularShape();
    }

    /**
     * Création du composant de lecture dans un fichier flat
     * @return
     */
    @Bean
    public AbstractInstructionReaderServices reader() {
        return new FlatFileInstructionReaderImpl();
    }
}
