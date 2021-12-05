package publicis.exercice.ndjomo.tondeuse.services.implementations;

import publicis.exercice.ndjomo.tondeuse.services.AbstractArchiveProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Archivage vers un système de fichier
 */
public class FlatFileInstructionArchivImpl implements AbstractArchiveProgram<Path, Path>  {

    /**
     * Archivage du fichier d'instruction
     *  Le nom du fichier de destination est péfixé par un ID unique
     * @param source
     * @param target
     * @throws IOException
     */
    @Override
    public void archiv(Path source, Path target) throws IOException {
        Files.move(source, target.resolve(UUID.randomUUID() + "_" + source.getFileName()));
    }
}
