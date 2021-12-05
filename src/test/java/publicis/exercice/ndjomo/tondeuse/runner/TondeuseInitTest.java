package publicis.exercice.ndjomo.tondeuse.runner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import publicis.exercice.ndjomo.tondeuse.AbstractPublicisSapientTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TondeuseInitTest extends AbstractPublicisSapientTest {


    @Autowired
    private TondeuseInit tondeuseInit;

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

    @Test
    void run() {
        assertDoesNotThrow(() -> tondeuseInit.run());
    }
}