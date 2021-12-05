package publicis.exercice.ndjomo.tondeuse.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation du composant source : lecture de fichier plat
 * Instruction stockées dans une fichier text
 */
@Service
@Slf4j
public class FlatFileInstructionReaderImpl implements AbstractInstructionReaderServices<Path, List<String>> {

    /**
     * Lire le fichier d'instruction à partir de la source "path"
     * @param path
     * @return
     */
    @Override
    public List<String> read(Path path) {
        List<String> instructions = new ArrayList<>();
        try {
            instructions = Files.readAllLines(path);
        } catch (IOException e) {
            log.warn("Pas de fichier d'instruction et/ou erreur de lecture. En attente ...");
        }
        return instructions;
    }
}
