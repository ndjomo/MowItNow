package publicis.exercice.ndjomo.tondeuse.runner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import publicis.exercice.ndjomo.tondeuse.AbstractPublicisSapientTest;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerProperties;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

class TondeuseInitTest extends AbstractPublicisSapientTest {


    @Autowired
    private MowerProperties mowerProperties;
    @Autowired
    private AbstractInstructionReaderServices reader;

    @Value( "${tondeuse.folder.instruction.errorfile}" )
    private String errorSourcePath;

    @Test
    void run() {

    }
}