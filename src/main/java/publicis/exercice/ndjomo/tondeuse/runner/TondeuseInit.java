package publicis.exercice.ndjomo.tondeuse.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Ce service permet de lancer la tondeuse
 */
@Component
public class TondeuseInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        int i = 1;
        i++;
        System.out.println("C'est bon " + i);

    }
}