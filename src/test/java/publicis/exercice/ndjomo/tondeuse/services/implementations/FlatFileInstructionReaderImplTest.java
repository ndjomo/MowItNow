package publicis.exercice.ndjomo.tondeuse.services.implementations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;
import publicis.exercice.ndjomo.tondeuse.AbstractPublicisSapientTest;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerProperties;
import publicis.exercice.ndjomo.tondeuse.domain.Coordinate;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;
import publicis.exercice.ndjomo.tondeuse.runner.TondeuseInit;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatFileInstructionReaderImplTest extends AbstractPublicisSapientTest {

    @Autowired
    private MowerProperties mowerProperties;
    @Autowired
    private AbstractInstructionReaderServices reader;

    @Autowired
    TondeuseInit tondeuseInit;

    @Value( "${tondeuse.folder.instruction.errorfile}" )
    private String errorSourcePath;

    /**
     * Test de lecture de la source
     * @throws Exception
     */
    @Test
    void nominalRead() throws Exception {
        List<String> programme = (List<String>) reader.read(mowerProperties.getFolder().getInstruction());
        assertNotNull(programme);
        assertTrue(programme.size() == 11);
        assertTrue("5 5".equals(programme.get(0)));

    }

    /**
     * Test d'erreur de lecture du fichier de programme
     */
    @Test
    public void errorRead() {
        Exception exception = assertThrows(IOException.class, () -> {
            reader.read(Paths.get(errorSourcePath));
        });

        assertNotNull(exception);
    }
}