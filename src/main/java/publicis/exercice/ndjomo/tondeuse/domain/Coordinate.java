package publicis.exercice.ndjomo.tondeuse.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

    public void move(char movement, Coordinate cornerCoodinate) {
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
            default : break;
        }
    }
}