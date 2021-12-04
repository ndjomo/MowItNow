package publicis.exercice.ndjomo.tondeuse.services.implementations;

import org.springframework.stereotype.Service;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Implementation du composant source : lecture de fichier plat
 * Instruction stockées dans une fichier text
 */
@Service
public class FlatFileInstructionReaderImpl implements AbstractInstructionReaderServices<Path> {

    @Override
    public List<String> read(Path path) throws Exception {
        List<String> instructions;
        try {
            instructions = Files.readAllLines(path);
        } catch (IOException e) {
            throw new BuisnessException("Impossible de lire la source des instruction");
        }
        return instructions;
    }
}
