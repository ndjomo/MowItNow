package publicis.exercice.ndjomo.tondeuse.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;
import publicis.exercice.ndjomo.tondeuse.utils.CircularList;

import java.util.Arrays;

@Getter
@Setter
@Slf4j
public class Coordinate {

    private int x;
    private int y;
    private char orientation;

    private CircularList<Character> circularDirections = new CircularList<>(Arrays.asList('W','N','E','S'));

    public Coordinate(String location) throws Exception {
        this.buildWithString(location);
    }

    /**
     * Déplacement de la tondeuse. Rotation 90 ° droite et gauche ou Avancement d'une case
     * @param movement
     * @param cornerCoodinate
     * @throws Exception
     */
    public void move(char movement, Coordinate cornerCoodinate) {
        int indexCourant = circularDirections.indexOf(orientation);
        switch (movement) {
            case 'D':
                this.orientation = circularDirections.get(indexCourant + 1);
                break;
            case 'G':
                this.orientation = circularDirections.get(indexCourant - 1);
                break;
            case 'A':
                switch (orientation) {
                    case 'W':
                        if(x > 0) x--;
                        break;
                    case 'N':
                        if(y < cornerCoodinate.getY()) y++;
                        break;
                    case 'E':
                        if(x < cornerCoodinate.getX()) x++;
                        break;
                    case 'S':
                        if(y > 0) y--;
                        break;
                    default: break;
                }
                break;
            default :
                log.warn("L'instruction " + movement + " n'est pas reconnue par la tondeuse !");
        }
    }

    /**
     * Construit une cordonnées à partir d'une chaîne de caractère
     * @param location
     */
    public void buildWithString(String location) throws Exception {
        String[] ch = location.split(" ");
        if (ch.length != 2 && ch.length != 3) {
            throw new BuisnessException("Impossible d'initialiser la tondeuse");
        }
        this.x = Integer.parseInt(ch[0]);
        this.y = Integer.parseInt(ch[1]);
        if (ch.length == 3) this.orientation = ch[2].charAt(0);
    }

    /**
     * Renvoie la position de la tondeuse
     * @return
     */
    public String toString() {
        StringBuilder printer = new StringBuilder();
        return printer
                .append(x).append(" ")
                .append(y).append(" ")
                .append(orientation)
                .toString();
    }
}