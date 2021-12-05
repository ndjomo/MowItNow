package publicis.exercice.ndjomo.tondeuse.configurations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import publicis.exercice.ndjomo.tondeuse.AbstractPublicisSapientTest;

class MowerPropertiesTest extends AbstractPublicisSapientTest  {

    @Autowired
    private MowerProperties mowerProperties;

    @Test
    void getOrigine() {
        Assert.notNull(mowerProperties.getOrigine());
        Assert.notNull(mowerProperties.getOrigine().getOrientation());
        Assert.notNull(mowerProperties.getOrigine().getX());
        Assert.notNull(mowerProperties.getOrigine().getY());
    }

    @Test
    void getFolder() {
        Assert.notNull(mowerProperties.getFolder());
        Assert.notNull(mowerProperties.getFolder().getArchive());
        Assert.notNull(mowerProperties.getFolder().getInstruction());
    }
}