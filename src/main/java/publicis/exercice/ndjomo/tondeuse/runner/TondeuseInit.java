package publicis.exercice.ndjomo.tondeuse.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerProperties;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;

import java.util.List;

/**
 * Ce service permet de lancer la tondeuse
 */
@Component
public class TondeuseInit implements ApplicationRunner {

    @Autowired
    private MowerProperties     mowerProperties;

    @Autowired
    private Tondeuse            tondeuse;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        List<String> instructions = tondeuse.getReader().read(mowerProperties.getFolder().getInstruction());

        if(instructions.size() < 2) {
            throw new BuisnessException("Pas assez d'instruction pour lancer la tondeuse");
        } else {
            tondeuse.getGrassField().init(instructions.get(0));
            tondeuse.getGrassField().limit(instructions.get(1));
            for (int i = 2; i < instructions.size(); i++) {
                tondeuse.getGrassField().walk(instructions.get(i));
                tondeuse.getGrassField().locate();
            }
        }

    }
}