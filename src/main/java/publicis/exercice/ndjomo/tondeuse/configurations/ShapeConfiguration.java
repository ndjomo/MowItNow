package publicis.exercice.ndjomo.tondeuse.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import publicis.exercice.ndjomo.tondeuse.domain.RectangularShape;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;

/**
 * Gestion des implémentations
 */
@Configuration
public class ShapeConfiguration {

    /**
     * Création d'une implémentation pour une surface rectengulaire
     * @return
     */
    @Bean
    public Form grassField() {
        return new RectangularShape();
    }
}
