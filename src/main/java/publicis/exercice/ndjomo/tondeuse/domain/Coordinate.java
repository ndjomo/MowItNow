package publicis.exercice.ndjomo.tondeuse.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;
import publicis.exercice.ndjomo.tondeuse.utils.CircularList;

import java.util.Arrays;

@Getter
@Setter
@Builder
public class Coordinate {
    private int x;
    private int y;
    private char orientation;
    private CircularList<Character> directions = (CircularList<Character>) Arrays.asList('W','N','E','S');

    public Coordinate(String location) throws Exception {
        this.buildWithString(location);
    }

    public void move(char movement, Coordinate cornerCoodinate) throws Exception {
        int indexCourant = directions.get(orientation);
        switch (movement) {
            case 'D':
                this.orientation = directions.get(indexCourant - 1);
                break;
            case 'G':
                this.orientation = directions.get(indexCourant + 1);
                break;
            case 'A':
                switch (orientation) {
                    case 'W':
                        if(x > 0) x--;
                        break;
                    case 'N':
                        if(x < cornerCoodinate.getY()) y++;
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
                throw new BuisnessException("L'instruction " + movement + " n'est pas reconnue par la tondeuse !");
        }
    }

    /**
     * Construit une cordonnées à partir d'une chaîne de caractère
     * @param location
     */
    public void buildWithString(String location) throws Exception {
        char[] ch = location.toCharArray();
        if(ch.length != 3 && ch.length != 2) {
            throw new BuisnessException("Impossible d'initialiser la tondeuse");
        }
        this.x = ch[0];
        this.y = ch[1];
        if(ch.length == 3) this.orientation = ch[2];
    }

    public String toString() {
        return x + y + orientation + "";
    }
}