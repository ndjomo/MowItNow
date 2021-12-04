package publicis.exercice.ndjomo.tondeuse.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.nio.file.Path;

/**
 * Cette classe permet de lire les paramétres du fichier de properties
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "tondeuse")
@Getter
@Setter
public class MowerProperties {

    public Origine  origine = new Origine();
    public Folder   folder  = new Folder();

    @Getter
    @Setter
    public static class Origine {
        private int     x;
        private int     y;
        private char    orientation;
    }

    @Getter
    @Setter
    public static class Folder {
        private Path instruction;
        private Path archive;
    }
}
