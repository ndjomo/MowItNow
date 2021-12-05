package publicis.exercice.ndjomo.tondeuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublicisSapientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicisSapientApplication.class, args);
    }

}
