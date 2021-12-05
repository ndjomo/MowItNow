package publicis.exercice.ndjomo.tondeuse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;
import publicis.exercice.ndjomo.tondeuse.runner.Tondeuse;
import publicis.exercice.ndjomo.tondeuse.services.AbstractArchiveProgram;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;


@TestPropertySource(locations = "classpath:/application-test.properties")
@ActiveProfiles("test")
@SpringBootTest
public class AbstractPublicisSapientTest {

    @Autowired
    private AbstractInstructionReaderServices reader;

    @Autowired
    private Form grassField;

    @Autowired
    private Tondeuse tondeuse;

    @Autowired
    private AbstractArchiveProgram archiv;

    @Test
    void contextLoads() {
        Assert.notNull(reader);
        Assert.notNull(grassField);
        Assert.notNull(tondeuse);
        Assert.notNull(archiv);
    }
}
