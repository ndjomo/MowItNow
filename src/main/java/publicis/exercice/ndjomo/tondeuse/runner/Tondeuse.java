package publicis.exercice.ndjomo.tondeuse.runner;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;
import publicis.exercice.ndjomo.tondeuse.services.AbstractInstructionReaderServices;

@Component
@RequiredArgsConstructor
@Getter
public class Tondeuse {

    /**
     * La surface
     */
    private final Form grassField;

    /**
     * Le lecteur sources
     */
    @Autowired
    private final AbstractInstructionReaderServices reader;
}
