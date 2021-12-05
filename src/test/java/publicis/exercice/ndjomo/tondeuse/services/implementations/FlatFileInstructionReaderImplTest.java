package publicis.exercice.ndjomo.tondeuse.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import publicis.exercice.ndjomo.tondeuse.AbstractPublicisSapientTest;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerProperties;
import publicis.exercice.ndjomo.tondeuse.runner.TondeuseInit;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlatFileInstructionReaderImplTest extends AbstractPublicisSapientTest {

    @Autowired
    private MowerProperties mowerProperties;
    @Autowired
    private AbstractInstructionReaderServices reader;

    @Autowired
    TondeuseInit tondeuseInit;

    @Value( "${tondeuse.folder.instruction.errorfile}" )
    private String errorSourcePath;

    @Value( "${tondeuse.folder.instruction.testfile}" )
    private String testFilePath;

    @Value( "${tondeuse.folder.instruction.sourcetestfile}" )
    private String folderTestFilePath;

    /**
     * Copy du fichier de test dans le dossier d'instruction
     * @throws IOException
     */
    @BeforeEach
    public void initTest() throws IOException {
        Files.copy(Paths.get(testFilePath), Paths.get(folderTestFilePath).resolve("imput-test.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

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
     * Aucune instruction n'est retourné
     */
    @Test
    public void errorRead() throws Exception {
        List<String> programme = (List<String>) reader.read(Paths.get(errorSourcePath));
        assertTrue(programme.isEmpty());
    }
}