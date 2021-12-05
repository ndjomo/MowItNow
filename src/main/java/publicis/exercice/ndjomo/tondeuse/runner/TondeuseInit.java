package publicis.exercice.ndjomo.tondeuse.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerConfiguration;
import publicis.exercice.ndjomo.tondeuse.configurations.MowerProperties;
import publicis.exercice.ndjomo.tondeuse.services.AbstractArchiveProgram;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;
import publicis.exercice.ndjomo.tondeuse.utils.PaginationList;

import java.util.List;

/**
 * Ce service permet de lancer la tondeuse
 */
@Component
public class TondeuseInit {

    Logger logger = LoggerFactory.getLogger(TondeuseInit.class);

    @Autowired
    private MowerProperties                     mowerProperties;

    /**
     * Le lecteur sources
     */
    @Autowired
    private AbstractInstructionReaderServices   reader;

    /**
     * L'archivage
     */
    @Autowired
    private AbstractArchiveProgram              archiv;

    @Scheduled(cron = "${tondeuse.reader.cron}")
    public void run() throws Exception {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MowerConfiguration.class);

        List<String> programme = (List<String>) reader.read(mowerProperties.getFolder().getInstruction());


        if (programme.size() != 0) {
            logger.info("-- Début d'exécution du programme --");
            // Pagination des instruction - regrouper pour chaque tondeuse sur 2 ligne
            // Index de début = 1 et
            List<List<String>> groupeInstruction = PaginationList.getPages(programme.subList(1, programme.size()), 2);

            // Traitement de chaque groupe d'instruction
            groupeInstruction.forEach(tondeuseInstruction -> {
                if (tondeuseInstruction.size() == 2) {
                    try {
                        // Récupération d'une nouvelle la tondeuse
                        Tondeuse tondeuse = context.getBean(Tondeuse.class);

                        tondeuse.getGrassField().limit(programme.get(0));
                        tondeuse.getGrassField().init(tondeuseInstruction.get(0));
                        tondeuse.getGrassField().walk(tondeuseInstruction.get(1));
                        tondeuse.getGrassField().locate();

                    } catch (Exception e) {
                        logger.error("La tondeuse n'a pas finit son travail : " + e.getMessage());
                    }
                }
            });

            logger.info("-- Archivage du programme --");
            // Archivage
            archiv.archiv(mowerProperties.getFolder().getInstruction(), mowerProperties.getFolder().getArchive());
            logger.info("-- Fin d'exécution du programme --");
        }
    }
}