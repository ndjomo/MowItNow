package publicis.exercice.ndjomo.tondeuse.runner;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import publicis.exercice.ndjomo.tondeuse.domain.abstracts.Form;

@Component
@RequiredArgsConstructor
@Getter
public class Tondeuse {
    /**
     * La surface
     */
    private final Form grassField;
}
