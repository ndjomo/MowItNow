package publicis.exercice.ndjomo.tondeuse.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Cette classe permet de lire les paramétres du fichier de properties
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "tondeuse")
@Getter
@Setter
public class ApplicationProperties {
    public Origine origine;

    @Getter
    @Setter
    class Origine {
        private int x;
        private int y;
        private char orientation;
    }
}
