package publicis.exercice.ndjomo.tondeuse.configurations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import publicis.exercice.ndjomo.tondeuse.domain.RectangularShape;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;
import publicis.exercice.ndjomo.tondeuse.runner.Tondeuse;
import publicis.exercice.ndjomo.tondeuse.services.AbstractArchiveProgram;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;
import publicis.exercice.ndjomo.tondeuse.services.implementations.FlatFileInstructionArchivImpl;
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

    /**
     * Composant d'archivate des programmes déjà excécutés
     * @return
     */
    @Bean
    public AbstractArchiveProgram archiv() {
        return new FlatFileInstructionArchivImpl();
    }

    /**
     * Création d'un composant tondeuse avec le scope Prototype
     *  A chaque injection de ce composant, une nouvelles instance est créée
     * @param grassField
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Tondeuse tondeuse(Form grassField) {
        return new Tondeuse(grassField);
    }
}
